package com.zyt.dao.company;

import java.util.Map;

import com.zyt.base.IBaseMapper;
import com.zyt.entity.company.ProductEntity;


public abstract interface IProductMapper
  extends IBaseMapper<ProductEntity>
{
  public abstract ProductEntity findByParams(Map<String, Object> paramMap);
}
