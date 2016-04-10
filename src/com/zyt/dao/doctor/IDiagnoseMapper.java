package com.zyt.dao.doctor;

import java.util.List;
import java.util.Map;

import com.zyt.base.IBaseMapper;
import com.zyt.bo.doctor.DiagnoseBo;
import com.zyt.entity.doctor.DiagnoseEntity;


public abstract interface IDiagnoseMapper
  extends IBaseMapper<DiagnoseEntity>
{
  public abstract List<DiagnoseBo> findAllBo(Map<String, Object> paramMap);
  
  public abstract int findAllBoCount(Map<String, Object> paramMap);
}
