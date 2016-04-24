package com.zyt.service.doctor.impl;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.zyt.base.ApiResult;
import com.zyt.base.PageQuery;
import com.zyt.bo.doctor.DoctorBo;
import com.zyt.bo.doctor.DoctorNearBo;
import com.zyt.bo.doctor.ReservationBo;
import com.zyt.chat.comm.ChatConstants;
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

/**
 * Author: @author HYS . <br>
 * Date: 2015-9-20 下午6:36:51 . <br>
 * Function:
 */
@Service
@Transactional
class DoctorManagerImpl implements IDoctorManager {
  @Autowired
  private IDoctorMapper doctorMapper;
  @Autowired
  private IUserMapper userMapper;
  @Autowired
  private IDoctorInfoManager doctorInfoManager;
  @Autowired
  private IChatManager chatManager;
  /**
   * @Fields : 时间段格式
   */
  private static final String TIME_REG = "^([0-1]\\d|2[0-3]):([0-5]\\d)$";
  /**
   * @Fields : 星期几(星期日-星期六 --> 1-7)
   */
  private static final String DAY_OF_WEEK_REG = "^[1-7]{1}(,[1-7])*$";

  /*
   * (non-Javadoc)
   *
   * @see
   * me.hys.service.doctor.IDoctorManager#doctorInfo(me.hys.entity.doctor.
   * DoctorInfoEntity)
   */
  @Override
  public ApiResult doctorInfo(DoctorInfoEntity entity) {
    // 保存状态
    doctorInfoManager.saveOrUpdate(entity);

    // 对全部患者发送透传信息
    int totalCount = userMapper.findPatientsIdCount();
    int size = (int) Math.ceil(totalCount * 1.0f / 20);
    for (int start = 1; start <= size; start++) {
      int from = (start - 1) * 20;
      List<String> userList = userMapper.findPatientsId(from);
      String[] users = new String[userList.size()];
      for (int i = 0; i < userList.size(); i++) {
        users[i] = ChatConstants.NAME_PREFIX + userList.get(i);
      }
      chatManager.sendOpenMsg("notify", "admin", users);
      try {
        // 每秒最多30次接口调用
        TimeUnit.SECONDS.sleep(1);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    return new ApiResult(ApiStatus.SUCCESS, "操作成功");
  }

  /*
   * (non-Javadoc)
   *
   * @see me.hys.service.doctor.IDoctorManager#findById(java.lang.String)
   */
  @Override
  public DoctorEntity findById(String userid) {
    return doctorMapper.findById(userid);
  }

  /*
   * (non-Javadoc)
   *
   * @see
   * me.hys.service.doctor.IDoctorManager#findDetailById(java.lang.String)
   */
  @Override
  public DoctorBo findDetailById(String id) {
    return doctorMapper.findDetailById(id);
  }

  /*
   * (non-Javadoc)
   *
   * @see
   * me.hys.service.doctor.IDoctorManager#findNearPageBo(me.hys.base.PageQuery
   * )
   */
  @Override
  public PageQuery<DoctorNearBo> findNearPageBo(PageQuery<DoctorNearBo> page) {
    List<DoctorNearBo> list = doctorMapper.findNearPageBo(page
            .getCondition());
    DecimalFormat format1 = new DecimalFormat("0");
    DecimalFormat format2 = new DecimalFormat("0.00");
    for (DoctorNearBo bo : list) {
      if (bo.getDistanceFloat() < 10000) {
        bo.setDistance(format1.format(bo.getDistanceFloat()));
        bo.setMeasure("米");
      } else {
        bo.setDistance(format2.format(bo.getDistanceFloat() / 1000));
        bo.setMeasure("公里");
      }
    }
    page.setList(list);
    page.setTotal(doctorMapper.findNearPageBoCount(page.getCondition()));
    // 总页数
    int size = (int) Math.ceil(page.getTotal() * 1.0f / page.getLimit());
    page.setSize(size);
    return page;
  }

  /*
   * (non-Javadoc)
   *
   * @see
   * me.hys.service.doctor.IDoctorManager#findPageBo(me.hys.base.PageQuery)
   */
  @Override
  public PageQuery<DoctorBo> findPageBo(PageQuery<DoctorBo> page) {
    page.setList(doctorMapper.findPageBo(page.getCondition()));
    page.setTotal(doctorMapper.findAllCount(page.getCondition()));
    // 总页数
    int size = (int) Math.ceil(page.getTotal() * 1.0f / page.getLimit());
    page.setSize(size);
    return page;
  }

  /**
   *新增Service
   * @Papers:
   * @Function:查询出所有审核或未审核的医生
   */
  @Override
  public PageQuery<DoctorBo> findPageBoUncheck(PageQuery<DoctorBo> page) {
    page.setList(doctorMapper.findPageBoUncheck(page.getCondition()));
    page.setTotal(doctorMapper.findAllCount(page.getCondition()));
    // 总页数
    int size = (int) Math.ceil(page.getTotal() * 1.0f / page.getLimit());
    page.setSize(size);
    return page;
  }

  /*
   * (non-Javadoc)
   *
   * @see
   * me.hys.service.doctor.IDoctorManager#findReservation(java.lang.String)
   */
  @Override
  public ReservationBo findReservation(String id) {
    return doctorMapper.findReservation(id);
  }

  /**
   * 更新Service
   * @Paper:DoctorEntity
   * @Function:仅给Controller做更新操作,不做身份验证
   */
  @Override
  public int updateCheck(DoctorEntity entity) {
    if (entity.getId() > 0) {
      return doctorMapper.updateCheck(entity);
    } else{
      doctorMapper.save(entity);
      return entity.getId();
    }
  }
  /*
   * (non-Javadoc)
   *
   * @see
   * me.hys.service.doctor.IDoctorManager#saveOrUpdate(me.hys.entity.doctor
   * .DoctorEntity)
   */
  @Override
  public ApiResult saveOrUpdate(DoctorEntity entity) {
    ApiResult apiResult = new ApiResult(ApiStatus.FAILED);
    UserEntity user = userMapper.findById(entity.getUserid() + "");
    if (null == user) {
      apiResult.setMsg("该用户不存在");
      return apiResult;
    }
    if (user.getType() != UserType.DOCTOR.getType()) {
      apiResult.setMsg("非医生用户无法更新");
      return apiResult;
    }
    // 如果更新影响为0
    if (doctorMapper.update(entity) == 0) {
      // 那么就在医生表中插入一条记录
      doctorMapper.save(entity);
    }
    // 更新用户表的医生姓名
    UserEntity userEntity = new UserEntity();
    userEntity.setId(entity.getUserid());
    if (!StrKit.isBlank(entity.getName())) {
      userEntity.setName(entity.getName());
    }
    if (!StrKit.isBlank(entity.getNickname())) {
      userEntity.setNickname(entity.getNickname());
    }
    if (!StrKit.isBlank(userEntity.getName())
            || !StrKit.isBlank(userEntity.getNickname())) {
      userMapper.update(userEntity);
    }
    apiResult.setResult(ApiStatus.SUCCESS);
    apiResult.setMsg("更新信息成功");
    return apiResult;
  }

  /*
   * (non-Javadoc)
   *
   * @see
   * me.hys.service.doctor.IDoctorManager#updateReservation(me.hys.bo.doctor
   * .ReservationBo)
   */
  @Override
  public ApiResult updateReservation(ReservationBo reservation) {
    ApiResult apiResult = new ApiResult(ApiStatus.FAILED);
    if (StrKit.isBlank(reservation.getStartTime())
            || !reservation.getStartTime().matches(TIME_REG)) {
      apiResult.setMsg("开始预约时间格式错误");
      return apiResult;
    }
    if (StrKit.isBlank(reservation.getEndTime())
            || !reservation.getEndTime().matches(TIME_REG)) {
      apiResult.setMsg("结束预约时间格式错误");
      return apiResult;
    }
    if (StrKit.isBlank(reservation.getDayOfWeek())
            || !reservation.getDayOfWeek().matches(DAY_OF_WEEK_REG)) {
      apiResult.setMsg("预约星期格式错误");
      return apiResult;
    }
    if (doctorMapper.updateReservation(reservation) > 0) {
      apiResult.setResult(ApiStatus.SUCCESS);
      apiResult.setMsg("更新成功");
      return apiResult;
    }
    apiResult.setMsg("更新失败");
    return apiResult;
  }
}
