package com.zyt.service.system;

import com.zyt.base.ApiResult;
import com.zyt.entity.system.AccountEntity;

public abstract interface IAccountManager
{
  public abstract ApiResult checkAccount(String paramString);
  
  public abstract ApiResult saveAccount(AccountEntity paramAccountEntity);
}
