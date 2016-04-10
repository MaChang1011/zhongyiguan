package com.zyt.dao.doctor;

import java.util.List;
import java.util.Map;

import com.zyt.base.IBaseMapper;
import com.zyt.bo.doctor.RvtUserBo;
import com.zyt.entity.doctor.ReservationEntity;


public abstract interface IReservationMapper
  extends IBaseMapper<ReservationEntity>
{
  public abstract List<RvtUserBo> findPageBo(Map<String, Object> paramMap);
  
  public abstract int findPageBoCount(Map<String, Object> paramMap);
}
