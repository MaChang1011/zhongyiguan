package com.zyt.dao.system;

import java.util.List;
import com.zyt.entity.system.ModuleEntity;


public abstract interface IModuleMapper
{
  public abstract List<ModuleEntity> findAll();
  
  public abstract List<ModuleEntity> findCurrent(String paramString);
}
