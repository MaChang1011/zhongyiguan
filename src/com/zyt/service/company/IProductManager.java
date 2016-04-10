package com.zyt.service.company;

import java.util.Map;
import com.zyt.base.IBaseManager;
import com.zyt.entity.company.ProductEntity;


public abstract interface IProductManager
  extends IBaseManager<ProductEntity>
{
  public abstract void push(String paramString);
  
  public abstract ProductEntity findById(Map<String, Object> paramMap);
}
