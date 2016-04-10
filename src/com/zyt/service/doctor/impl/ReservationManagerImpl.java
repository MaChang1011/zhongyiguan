package com.zyt.service.doctor.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import com.zyt.base.ApiResult;
import com.zyt.base.PageQuery;
import com.zyt.bo.doctor.RvtUserBo;
import com.zyt.cons.ApiStatus;
import com.zyt.dao.doctor.IReservationMapper;
import com.zyt.dao.system.IUserMapper;
import com.zyt.entity.doctor.ReservationEntity;
import com.zyt.entity.system.UserEntity;
import com.zyt.service.doctor.IReservationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
class ReservationManagerImpl
  implements IReservationManager
{
  @Autowired
  private IUserMapper userMapper;
  @Autowired
  private IReservationMapper reservationMapper;
  
  public PageQuery<RvtUserBo> findPage(PageQuery<RvtUserBo> page)
  {
    Map<String, Object> condition = page.getCondition();
    List<RvtUserBo> list = this.reservationMapper.findPageBo(condition);
    page.setList(list);
    page.setTotal(this.reservationMapper.findPageBoCount(condition));
    
    int size = (int)Math.ceil(page.getTotal() * 1.0F / page.getLimit());
    page.setSize(size);
    return page;
  }
  
  public PageQuery<RvtUserBo> findPageBo(PageQuery<RvtUserBo> page)
  {
    Map<String, Object> condition = page.getCondition();
    String userid = String.valueOf(condition.get("userid"));
    UserEntity user = (UserEntity)this.userMapper.findById(userid);
    if (user == null) {
      return page;
    }
    condition.put("type", Integer.valueOf(user.getType()));
    if ("history".equals(condition.get("history"))) {
      condition.put("history", Integer.valueOf(1));
    } else {
      condition.put("history", Integer.valueOf(0));
    }
    List<RvtUserBo> list = this.reservationMapper.findPageBo(condition);
    page.setList(list);
    page.setTotal(this.reservationMapper.findPageBoCount(condition));
    
    int size = (int)Math.ceil(page.getTotal() * 1.0F / page.getLimit());
    page.setSize(size);
    return page;
  }
  
  public ApiResult saveOrUpdate(ReservationEntity entity)
  {
    if (entity.getId() > 0)
    {
      this.reservationMapper.update(entity);
    }
    else
    {
      entity.setCreateTime(new Timestamp(System.currentTimeMillis()));
      this.reservationMapper.save(entity);
    }
    return new ApiResult(ApiStatus.SUCCESS, "操作成功");
  }
}
