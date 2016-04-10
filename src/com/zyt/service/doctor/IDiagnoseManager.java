package com.zyt.service.doctor;

import com.zyt.base.IBaseManager;
import com.zyt.base.PageQuery;
import com.zyt.bo.doctor.DiagnoseBo;
import com.zyt.entity.doctor.DiagnoseEntity;

public abstract interface IDiagnoseManager
  extends IBaseManager<DiagnoseEntity>
{
  public abstract PageQuery<DiagnoseBo> findPageBo(PageQuery<DiagnoseBo> paramPageQuery);
}
