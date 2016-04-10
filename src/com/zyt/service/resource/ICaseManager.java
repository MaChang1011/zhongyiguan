package com.zyt.service.resource;

import com.zyt.base.IBaseManager;
import com.zyt.base.PageQuery;
import com.zyt.bo.resource.CaseBo;
import com.zyt.entity.resource.CaseEntity;

public abstract interface ICaseManager
  extends IBaseManager<CaseEntity>
{
  public abstract PageQuery<CaseBo> findPageBo(PageQuery<CaseBo> paramPageQuery);
}
