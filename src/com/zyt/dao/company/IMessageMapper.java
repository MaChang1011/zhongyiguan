package com.zyt.dao.company;

import java.util.Map;

import com.zyt.base.IBaseMapper;
import com.zyt.entity.company.MessageEntity;


public abstract interface IMessageMapper
  extends IBaseMapper<MessageEntity>
{
  public abstract MessageEntity findByParams(Map<String, Object> paramMap);
}
