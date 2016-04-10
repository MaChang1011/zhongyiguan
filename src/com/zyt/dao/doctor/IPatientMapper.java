package com.zyt.dao.doctor;

import java.util.List;
import java.util.Map;

import com.zyt.base.IBaseMapper;
import com.zyt.bo.resource.CaseBo;
import com.zyt.entity.doctor.PatientEntity;


public abstract interface IPatientMapper
  extends IBaseMapper<PatientEntity>
{
  public abstract String getCaseImageCount(String paramString);
  
  public abstract int saveCaseImageCount(PatientEntity paramPatientEntity);
  
  public abstract int updateCaseImageCount(Map<String, Object> paramMap);
  
  public abstract List<PatientEntity> findAllBo(Map<String, Object> paramMap);
}