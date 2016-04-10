package com.zyt.service.system;

import java.util.Map;

import com.zyt.base.ApiResult;
import com.zyt.entity.system.DeviceTokenEntity;


public abstract interface IDeviceTokenManager
{
  public abstract ApiResult save(DeviceTokenEntity paramDeviceTokenEntity);
  
  public abstract void push(String paramString, Map<String, Object> paramMap);
  
  public abstract DeviceTokenEntity findByDeviceToken(String paramString);
}
