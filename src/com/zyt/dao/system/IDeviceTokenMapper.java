package com.zyt.dao.system;

import java.util.List;

import com.zyt.entity.system.DeviceTokenEntity;


public abstract interface IDeviceTokenMapper
{
  public abstract void save(DeviceTokenEntity paramDeviceTokenEntity);
  
  public abstract void update(DeviceTokenEntity paramDeviceTokenEntity);
  
  public abstract List<String> findAll(int paramInt);
  
  public abstract int findAllCount();
  
  public abstract DeviceTokenEntity findByDeviceToken(String paramString);
}
