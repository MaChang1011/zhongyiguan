package com.zyt.dao.doctor;

import java.util.List;
import java.util.Map;

import com.zyt.base.ApiResult;
import com.zyt.base.IBaseMapper;
import com.zyt.bo.doctor.DoctorBo;
import com.zyt.bo.doctor.DoctorNearBo;
import com.zyt.bo.doctor.ReservationBo;
import com.zyt.entity.doctor.DoctorEntity;


public abstract interface IDoctorMapper
  extends IBaseMapper<DoctorEntity>
{
  public abstract DoctorBo findDetailById(String paramString);

  /**
   * @Title : findPageBo
   * @Description : 获取已审核列表
   */
  public abstract List<DoctorBo> findPageBo(Map<String, Object> paramMap);
  
  public abstract int updateReservation(ReservationBo paramReservationBo);
  
  public abstract ReservationBo findReservation(String paramString);
  
  public abstract ApiResult doctorInfo(double paramDouble1, double paramDouble2, int paramInt);
  
  public abstract List<DoctorNearBo> findNearPageBo(Map<String, Object> paramMap);
  
  public abstract int findNearPageBoCount(Map<String, Object> paramMap);

  /**
   * @Title : 新增updateCheck
   * @Description : 更新医生的审核状态
   */
  int updateCheck(DoctorEntity entity);

  /**
   * @Title : findPageBoUncheck
   * @Description : 获取所有医生列表
   */
  List<DoctorBo> findPageBoUncheck(Map<String, Object> cond);
}
