package com.zyt.dao.system;

import java.util.List;

import com.zyt.base.IBaseMapper;
import com.zyt.entity.system.ConfigEntity;


public abstract interface IConfigMapper
  extends IBaseMapper<ConfigEntity>
{
  public abstract List<ConfigEntity> findByFlags(String[] paramArrayOfString);
}
