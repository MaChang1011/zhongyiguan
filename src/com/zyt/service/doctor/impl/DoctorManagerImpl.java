package com.zyt.service.doctor.impl;

import java.text.DecimalFormat;
import java.util.List;
import java.util.concurrent.TimeUnit;
import com.zyt.base.ApiResult;
import com.zyt.base.PageQuery;
import com.zyt.bo.doctor.DoctorBo;
import com.zyt.bo.doctor.DoctorNearBo;
import com.zyt.bo.doctor.ReservationBo;
import com.zyt.cons.ApiStatus;
import com.zyt.cons.UserType;
import com.zyt.dao.doctor.IDoctorMapper;
import com.zyt.dao.system.IUserMapper;
import com.zyt.entity.doctor.DoctorEntity;
import com.zyt.entity.doctor.DoctorInfoEntity;
import com.zyt.entity.system.UserEntity;
import com.zyt.kits.StrKit;
import com.zyt.service.chat.IChatManager;
import com.zyt.service.doctor.IDoctorInfoManager;
import com.zyt.service.doctor.IDoctorManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
class DoctorManagerImpl
  implements IDoctorManager
{
  @Autowired
  private IDoctorMapper doctorMapper;
  @Autowired
  private IUserMapper userMapper;
  @Autowired
  private IDoctorInfoManager doctorInfoManager;
  @Autowired
  private IChatManager chatManager;
  private static final String TIME_REG = "^([0-1]\\d|2[0-3]):([0-5]\\d)$";
  private static final String DAY_OF_WEEK_REG = "^[1-7]{1}(,[1-7])*$";
  
  public ApiResult doctorInfo(DoctorInfoEntity entity)
  {
    this.doctorInfoManager.saveOrUpdate(entity);
    
    int totalCount = this.userMapper.findPatientsIdCount();
    int size = (int)Math.ceil(totalCount * 1.0F / 20.0F);
    for (int start = 1; start <= size; start++)
    {
      int from = (start - 1) * 20;
      List<String> userList = this.userMapper.findPatientsId(from);
      String[] users = new String[userList.size()];
      for (int i = 0; i < userList.size(); i++) {
        users[i] = ("u" + (String)userList.get(i));
      }
      this.chatManager.sendOpenMsg("notify", "admin", users);
      try
      {
        TimeUnit.SECONDS.sleep(1L);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
    return new ApiResult(ApiStatus.SUCCESS, "操作成功");
  }
  
  public DoctorEntity findById(String userid)
  {
    return (DoctorEntity)this.doctorMapper.findById(userid);
  }
  
  public DoctorBo findDetailById(String id)
  {
    return this.doctorMapper.findDetailById(id);
  }
  
  public PageQuery<DoctorNearBo> findNearPageBo(PageQuery<DoctorNearBo> page)
  {
    List<DoctorNearBo> list = this.doctorMapper.findNearPageBo(page
      .getCondition());
    DecimalFormat format1 = new DecimalFormat("0");
    DecimalFormat format2 = new DecimalFormat("0.00");
    for (DoctorNearBo bo : list) {
      if (bo.getDistanceFloat() < 10000.0F)
      {
        bo.setDistance(format1.format(bo.getDistanceFloat()));
        bo.setMeasure("米");
      }
      else
      {
        bo.setDistance(format2.format(bo.getDistanceFloat() / 1000.0F));
        bo.setMeasure("公里");
      }
    }
    page.setList(list);
    page.setTotal(this.doctorMapper.findNearPageBoCount(page.getCondition()));
    
    int size = (int)Math.ceil(page.getTotal() * 1.0F / page.getLimit());
    page.setSize(size);
    return page;
  }
  
  public PageQuery<DoctorBo> findPageBo(PageQuery<DoctorBo> page)
  {
    page.setList(this.doctorMapper.findPageBo(page.getCondition()));
    page.setTotal(this.doctorMapper.findAllCount(page.getCondition()));
    
    int size = (int)Math.ceil(page.getTotal() * 1.0F / page.getLimit());
    page.setSize(size);
    return page;
  }
  
  public ReservationBo findReservation(String id)
  {
    return this.doctorMapper.findReservation(id);
  }
  
  public ApiResult saveOrUpdate(DoctorEntity entity)
  {
    ApiResult apiResult = new ApiResult(ApiStatus.FAILED);
    UserEntity user = (UserEntity)this.userMapper.findById(String.valueOf(entity.getUserid()));
    if (user == null)
    {
      apiResult.setMsg("该用户不存在");
      return apiResult;
    }
    if (user.getType() != UserType.DOCTOR.getType())
    {
      apiResult.setMsg("非医生无法更新");
      return apiResult;
    }
    if (this.doctorMapper.update(entity) == 0) {
      this.doctorMapper.save(entity);
    }
    UserEntity userEntity = new UserEntity();
    userEntity.setId(entity.getUserid());
    if (!StrKit.isBlank(entity.getName())) {
      userEntity.setName(entity.getName());
    }
    if (!StrKit.isBlank(entity.getNickname())) {
      userEntity.setNickname(entity.getNickname());
    }
    if ((!StrKit.isBlank(userEntity.getName())) || 
      (!StrKit.isBlank(userEntity.getNickname()))) {
      this.userMapper.update(userEntity);
    }
    apiResult.setResult(ApiStatus.SUCCESS);
    apiResult.setMsg("更新信息成功");
    return apiResult;
  }
  
  public ApiResult updateReservation(ReservationBo reservation)
  {
    ApiResult apiResult = new ApiResult(ApiStatus.FAILED);
    if ((StrKit.isBlank(reservation.getStartTime())) || 
      (!reservation.getStartTime().matches("^([0-1]\\d|2[0-3]):([0-5]\\d)$")))
    {
      apiResult.setMsg("开始预约时间格式错误");
      return apiResult;
    }
    if ((StrKit.isBlank(reservation.getEndTime())) || 
      (!reservation.getEndTime().matches("^([0-1]\\d|2[0-3]):([0-5]\\d)$")))
    {
      apiResult.setMsg("结束预约时间格式错误");
      return apiResult;
    }
    if ((StrKit.isBlank(reservation.getDayOfWeek())) || 
      (!reservation.getDayOfWeek().matches("^[1-7]{1}(,[1-7])*$")))
    {
      apiResult.setMsg("预约星期格式错误");
      return apiResult;
    }
    if (this.doctorMapper.updateReservation(reservation) > 0)
    {
      apiResult.setResult(ApiStatus.SUCCESS);
      apiResult.setMsg("更新成功");
      return apiResult;
    }
    apiResult.setMsg("更新失败");
    return apiResult;
  }
}
