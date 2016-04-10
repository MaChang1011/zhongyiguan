package com.zyt.service.doctor;

import com.zyt.base.ApiResult;
import com.zyt.base.PageQuery;
import com.zyt.bo.doctor.RvtUserBo;
import com.zyt.entity.doctor.ReservationEntity;

public abstract interface IReservationManager
{
  public abstract ApiResult saveOrUpdate(ReservationEntity paramReservationEntity);
  
  public abstract PageQuery<RvtUserBo> findPageBo(PageQuery<RvtUserBo> paramPageQuery);
  
  public abstract PageQuery<RvtUserBo> findPage(PageQuery<RvtUserBo> paramPageQuery);
}
