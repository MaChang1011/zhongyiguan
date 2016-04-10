package com.zyt.service.chat;

import com.zyt.base.ApiResult;
import com.zyt.base.PageQuery;
import com.zyt.entity.doctor.AnswerEntity;

public abstract interface IChatManager
{
  public abstract ApiResult register(String paramString1, String paramString2, String paramString3);
  
  public abstract ApiResult delete(String paramString);
  
  public abstract ApiResult modifyPassword(String paramString1, String paramString2);
  
  public abstract ApiResult modifyNickname(String paramString1, String paramString2);
  
  public abstract ApiResult login(String paramString1, String paramString2);
  
  public abstract ApiResult sendMsg(String paramString1, String paramString2, String paramString3);
  
  public abstract PageQuery<AnswerEntity> findMsgPage(PageQuery<AnswerEntity> paramPageQuery);
  
  public abstract void sendOpenMsg(String paramString1, String paramString2, String[] paramArrayOfString);
}
