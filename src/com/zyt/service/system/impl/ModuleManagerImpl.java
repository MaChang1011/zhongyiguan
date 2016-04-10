package com.zyt.service.system.impl;

import com.google.common.collect.Lists;
import java.util.List;
import com.zyt.dao.system.IModuleMapper;
import com.zyt.entity.system.ModuleEntity;
import com.zyt.service.system.IModuleManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ModuleManagerImpl
  implements IModuleManager
{
  @Autowired
  private IModuleMapper mapper;
  
  public List<ModuleEntity> findAll()
  {
    List<ModuleEntity> modules = this.mapper.findAll();
    List<ModuleEntity> list = Lists.newArrayList();
    for (ModuleEntity module : modules) {
      if (module.getParent() == 0)
      {
        module.setChildren(getChildren(module.getId(), modules));
        list.add(module);
      }
    }
    return list;
  }
  
  public List<ModuleEntity> findCurrent(String flag)
  {
    return this.mapper.findCurrent(flag);
  }
  
  private List<ModuleEntity> getChildren(int id, List<ModuleEntity> modules)
  {
    List<ModuleEntity> list = Lists.newArrayList();
    for (ModuleEntity module : modules) {
      if (module.getParent() == id) {
        list.add(module);
      }
    }
    return list;
  }
}
