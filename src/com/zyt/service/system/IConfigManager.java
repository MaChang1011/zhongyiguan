package com.zyt.service.system;

import java.util.List;

import com.zyt.entity.system.ConfigEntity;


public abstract interface IConfigManager
{
  public abstract List<ConfigEntity> findByFlags(String[] paramArrayOfString);
  
  public abstract ConfigEntity findOneByFlags(String[] paramArrayOfString);
  
  public abstract ConfigEntity findById(String paramString);
  
  public abstract int saveOrUpdate(ConfigEntity paramConfigEntity);
}
