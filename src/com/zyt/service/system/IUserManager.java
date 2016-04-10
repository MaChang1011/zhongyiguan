package com.zyt.service.system;

import java.util.Map;

import com.zyt.base.ApiResult;
import com.zyt.base.IBaseManager;
import com.zyt.entity.system.UserEntity;

public abstract interface IUserManager
  extends IBaseManager<UserEntity>
{
  public abstract ApiResult saveRegister(UserEntity paramUserEntity);
  
  public abstract UserEntity findOneByCond(Map<String, Object> paramMap);
  
  public abstract ApiResult changePsw(String paramString1, String paramString2, String paramString3);
  
  public abstract ApiResult authUser(UserEntity paramUserEntity);
  
  public abstract ApiResult update(UserEntity paramUserEntity);
  
  public abstract int improve(UserEntity paramUserEntity);
  
  public abstract UserEntity findUserLogin(UserEntity paramUserEntity);
}
