package com.zyt.base;

import java.util.List;
import java.util.Map;

public abstract interface IBaseMapper<T>
{
  public abstract T findById(String paramString);
  
  public abstract List<T> findByCond(Map<String, Object> paramMap);
  
  public abstract List<T> findAll(Map<String, Object> paramMap);
  
  public abstract List<T> findAllIsPass(Map<String, Object> paramMap);
  
  public abstract int findAllCount(Map<String, Object> paramMap);
  
  public abstract void save(T paramT);
  
  public abstract int update(T paramT);
  
  public abstract void delete(String paramString);
}