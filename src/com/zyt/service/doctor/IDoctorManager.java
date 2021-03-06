package com.zyt.service.doctor;

import com.zyt.base.ApiResult;
import com.zyt.base.PageQuery;
import com.zyt.bo.doctor.DoctorBo;
import com.zyt.bo.doctor.DoctorNearBo;
import com.zyt.bo.doctor.ReservationBo;
import com.zyt.entity.doctor.DoctorEntity;
import com.zyt.entity.doctor.DoctorInfoEntity;

public abstract interface IDoctorManager
{
  /**
  * @Title : Update
  * @Description : 更新
  */
  int updateCheck(DoctorEntity entity);

  public abstract ApiResult saveOrUpdate(DoctorEntity paramDoctorEntity);

  public abstract DoctorEntity findById(String userid);
  /**
   * @Title : findPageBo
   * @Description : 查询全部已审核
   */
  public abstract PageQuery<DoctorBo> findPageBo(PageQuery<DoctorBo> paramPageQuery);

  /**
   * @Title : findPageBo
   * @Description : 查询全部
   */
  PageQuery<DoctorBo> findPageBoUncheck(PageQuery<DoctorBo> page);

  public abstract PageQuery<DoctorNearBo> findNearPageBo(PageQuery<DoctorNearBo> paramPageQuery);

  public abstract DoctorBo findDetailById(String paramString);

  public abstract ApiResult updateReservation(ReservationBo paramReservationBo);

  public abstract ReservationBo findReservation(String paramString);

  public abstract ApiResult doctorInfo(DoctorInfoEntity paramDoctorInfoEntity);
}
