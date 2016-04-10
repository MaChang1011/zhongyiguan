package com.zyt.service.system.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zyt.dao.system.IConfigMapper;
import com.zyt.entity.system.ConfigEntity;
import com.zyt.kits.CollectionKit;
import com.zyt.service.system.IConfigManager;

@Service
@Transactional
class ConfigManagerImpl
  implements IConfigManager
{
  @Autowired
  private IConfigMapper mapper;
  
  public List<ConfigEntity> findByFlags(String[] flags)
  {
    return this.mapper.findByFlags(flags);
  }
  
  public ConfigEntity findById(String id)
  {
    return (ConfigEntity)this.mapper.findById(id);
  }
  
  public ConfigEntity findOneByFlags(String[] flags)
  {
    List<ConfigEntity> list = findByFlags(flags);
    return CollectionKit.isNull(list) ? null : (ConfigEntity)list.get(0);
  }
  
  public int saveOrUpdate(ConfigEntity entity)
  {
    if (entity.getId() > 0) {
      return this.mapper.update(entity);
    }
    this.mapper.save(entity);
    return entity.getId();
  }
}

