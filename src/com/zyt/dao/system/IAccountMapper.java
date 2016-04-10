package com.zyt.dao.system;

import java.util.List;
import com.zyt.entity.system.AccountEntity;


public abstract interface IAccountMapper
{
  public abstract List<String> findUserByUid(String paramString);
  
  public abstract void saveAccount(AccountEntity paramAccountEntity);
}
