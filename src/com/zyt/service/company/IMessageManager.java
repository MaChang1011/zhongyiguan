package com.zyt.service.company;


import java.util.Map;

import com.zyt.base.IBaseManager;
import com.zyt.entity.company.MessageEntity;


public abstract interface IMessageManager
  extends IBaseManager<MessageEntity>
{
  public abstract void push(String paramString);
  
  public abstract MessageEntity findById(Map<String, Object> paramMap);
}
