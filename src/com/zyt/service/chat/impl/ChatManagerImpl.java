package com.zyt.service.chat.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.sql.Timestamp;
import com.zyt.base.ApiResult;
import com.zyt.base.PageQuery;
import com.zyt.chat.comm.ChatException;
import com.zyt.cons.ApiStatus;
import com.zyt.entity.doctor.AnswerEntity;
import com.zyt.kits.MD5Kit;
import com.zyt.service.chat.IChatManager;
import com.zyt.service.doctor.IAnswerManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class ChatManagerImpl
  extends BaseChatManagerImpl
  implements IChatManager
{
  @Autowired
  private IAnswerManager answerManager;
  
  public ApiResult delete(String userid)
  {
    ApiResult apiResult = new ApiResult(ApiStatus.SUCCESS);
    try
    {
      deleteIMUserByUserName("u" + userid);
    }
    catch (ChatException e)
    {
      apiResult.setResult(ApiStatus.FAILED);
      apiResult.setMsg(e.getMessage());
      e.printStackTrace();
    }
    return apiResult;
  }
  
  public PageQuery<AnswerEntity> findMsgPage(PageQuery<AnswerEntity> page)
  {
    return this.answerManager.findPage(page);
  }
  
  public ApiResult login(String userid, String mobile)
  {
    ApiResult apiResult = new ApiResult(ApiStatus.SUCCESS);
    ObjectNode json2 = JsonNodeFactory.instance.objectNode();
    json2.put("password", MD5Kit.encrypt(mobile));
    try
    {
      imUserLogin("u" + userid, 
        json2.get("password").asText());
    }
    catch (ChatException e)
    {
      apiResult.setResult(ApiStatus.FAILED);
      apiResult.setMsg(e.getMessage());
      e.printStackTrace();
    }
    return apiResult;
  }
  
  public ApiResult modifyNickname(String userid, String nickname)
  {
    ApiResult apiResult = new ApiResult(ApiStatus.SUCCESS);
    ObjectNode json2 = JsonNodeFactory.instance.objectNode();
    json2.put("nickname", nickname);
    try
    {
      modifyIMUserNicknameWithAdminToken("u" + 
        userid, json2);
    }
    catch (ChatException e)
    {
      apiResult.setResult(ApiStatus.FAILED);
      apiResult.setMsg(e.getMessage());
      e.printStackTrace();
    }
    return apiResult;
  }
  
  public ApiResult modifyPassword(String userid, String mobile)
  {
    ApiResult apiResult = new ApiResult(ApiStatus.SUCCESS);
    ObjectNode json2 = JsonNodeFactory.instance.objectNode();
    json2.put("newpassword", MD5Kit.encrypt(mobile));
    try
    {
      modifyIMUserPasswordWithAdminToken("u" + 
        userid, json2);
      
      imUserLogin("u" + userid, 
        json2.get("newpassword").asText());
    }
    catch (ChatException e)
    {
      apiResult.setResult(ApiStatus.FAILED);
      apiResult.setMsg(e.getMessage());
      e.printStackTrace();
    }
    return apiResult;
  }
  
  public ApiResult register(String userid, String mobile, String nickname)
  {
    ApiResult apiResult = new ApiResult(ApiStatus.SUCCESS);
    ObjectNode datanode = JsonNodeFactory.instance.objectNode();
    datanode.put("username", "u" + userid);
    datanode.put("password", MD5Kit.encrypt(mobile));
    datanode.put("nickname", nickname);
    try
    {
      createNewIMUserSingle(datanode);
    }
    catch (ChatException e)
    {
      apiResult.setResult(ApiStatus.FAILED);
      apiResult.setMsg(e.getMessage());
      e.printStackTrace();
    }
    return apiResult;
  }
  
  public ApiResult sendMsg(String msg, String from, String target)
  {
    ApiResult apiResult = new ApiResult(ApiStatus.SUCCESS);
    
    ArrayNode targetusers = this.factory.arrayNode();
    targetusers.add("u" + target);
    ObjectNode txtmsg = this.factory.objectNode();
    txtmsg.put("msg", msg);
    txtmsg.put("type", "txt");
    try
    {
      sendMessages(targetusers, txtmsg, "u" + from, 
        null);
      
      AnswerEntity entity = new AnswerEntity();
      entity.setMsgFrom(from);
      entity.setMsgTo(target);
      entity.setMsg(msg);
      entity.setCreateTime(new Timestamp(System.currentTimeMillis()));
      this.answerManager.save(entity);
    }
    catch (ChatException e)
    {
      apiResult.setResult(ApiStatus.FAILED);
      apiResult.setMsg(e.getMessage());
      e.printStackTrace();
    }
    return apiResult;
  }
  
  public void sendOpenMsg(String action, String from, String[] target)
  {
    ObjectNode cmdmsg = this.factory.objectNode();
    cmdmsg.put("action", action);
    cmdmsg.put("type", "cmd");
    ArrayNode targetUser = this.factory.arrayNode();
    String[] arrayOfString;
    int j = (arrayOfString = target).length;
    for (int i = 0; i < j; i++)
    {
      String u = arrayOfString[i];
      targetUser.add(u);
    }
    try
    {
      sendMessages(targetUser, cmdmsg, from, null);
    }
    catch (ChatException e)
    {
      e.printStackTrace();
    }
  }
}
