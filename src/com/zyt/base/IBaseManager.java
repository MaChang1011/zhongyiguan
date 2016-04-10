package com.zyt.base;

import java.util.List;
import java.util.Map;

public abstract interface IBaseManager<T>
{
  public abstract List<T> findByCond(Map<String, Object> paramMap);
  
  public abstract T findById(String paramString);
  
  public abstract PageQuery<T> findPage(PageQuery<T> paramPageQuery);
  
  public abstract int saveOrUpdate(T paramT);
  
  public abstract void delete(String paramString);
}
