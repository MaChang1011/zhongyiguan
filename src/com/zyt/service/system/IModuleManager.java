package com.zyt.service.system;

import java.util.List;
import com.zyt.entity.system.ModuleEntity;


public abstract interface IModuleManager
{
  public abstract List<ModuleEntity> findAll();
  
  public abstract List<ModuleEntity> findCurrent(String paramString);
}
