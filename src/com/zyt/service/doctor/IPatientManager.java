package com.zyt.service.doctor;

import com.zyt.base.ApiResult;
import com.zyt.base.PageQuery;
import com.zyt.entity.doctor.PatientEntity;

public abstract interface IPatientManager
{
  public abstract ApiResult saveOrUpdate(PatientEntity paramPatientEntity);
  
  public abstract ApiResult Update(PatientEntity paramPatientEntity);
  
  public abstract PatientEntity findById(String paramString);
  
  public abstract int getCaseImageCount(String paramString);
  
  public abstract ApiResult saveCaseImageCount(String paramString, int paramInt);
  
  public abstract PageQuery<PatientEntity> findPageBo(PageQuery<PatientEntity> paramPageQuery);
  
  public abstract PageQuery<PatientEntity> findPageBoIsPass(PageQuery<PatientEntity> paramPageQuery);

  public abstract void delete(String id);
}
