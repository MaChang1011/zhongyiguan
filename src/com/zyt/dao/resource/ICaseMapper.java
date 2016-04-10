package com.zyt.dao.resource;

import java.util.List;
import java.util.Map;

import com.zyt.base.IBaseMapper;
import com.zyt.bo.resource.CaseBo;
import com.zyt.entity.resource.CaseEntity;


public abstract interface ICaseMapper
  extends IBaseMapper<CaseEntity>
{
  public abstract List<CaseBo> findAllBo(Map<String, Object> paramMap);
}