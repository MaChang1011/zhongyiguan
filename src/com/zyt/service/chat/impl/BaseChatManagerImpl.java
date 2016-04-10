package com.zyt.service.chat.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.List;
import com.zyt.chat.JerseyUtils;
import com.zyt.chat.comm.ChatConstants;
import com.zyt.chat.comm.ChatException;
import com.zyt.chat.comm.ChatExceptionEnum;
import com.zyt.chat.vo.ClientSecretCredential;
import com.zyt.chat.vo.Credential;
import com.zyt.chat.vo.EndPoints;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.glassfish.jersey.client.JerseyWebTarget;

public class BaseChatManagerImpl
{
  protected final JsonNodeFactory factory = new JsonNodeFactory(false);
  protected final String APPKEY = ChatConstants.APPKEY;
  protected Credential credential = new ClientSecretCredential(
    ChatConstants.APP_CLIENT_ID, ChatConstants.APP_CLIENT_SECRET, 
    "appAdmin");
  
  protected ObjectNode createNewIMUserSingle(ObjectNode dataNode)
    throws ChatException
  {
    ObjectNode objectNode = this.factory.objectNode();
    if (!JerseyUtils.match("^(?!-)[0-9a-zA-Z\\-]+#[0-9a-zA-Z]+", this.APPKEY)) {
      throw new ChatException(ChatExceptionEnum.APP_KEY_ERROR.getCode(), 
        ChatExceptionEnum.APP_KEY_ERROR.getMsg());
    }
    objectNode.removeAll();
    if ((dataNode != null) && (!dataNode.has("username"))) {
      throw new ChatException(
        ChatExceptionEnum.USERNAME_NOT_NULL.getCode(), 
        ChatExceptionEnum.USERNAME_NOT_NULL.getMsg());
    }
    if ((dataNode != null) && (!dataNode.has("password"))) {
      throw new ChatException(
        ChatExceptionEnum.PASSWORD_NOT_NULL.getCode(), 
        ChatExceptionEnum.PASSWORD_NOT_NULL.getMsg());
    }
    JerseyWebTarget webTarget = EndPoints.USERS_TARGET.resolveTemplate(
      "org_name", this.APPKEY.split("#")[0]).resolveTemplate("app_name", 
      this.APPKEY.split("#")[1]);
    objectNode = JerseyUtils.sendRequest(webTarget, dataNode, this.credential, 
      "POST", null);
    return objectNode;
  }
  
  protected ObjectNode deleteIMUserByUserName(String userName)
    throws ChatException
  {
    ObjectNode objectNode = this.factory.objectNode();
    if (!JerseyUtils.match("^(?!-)[0-9a-zA-Z\\-]+#[0-9a-zA-Z]+", this.APPKEY)) {
      throw new ChatException(ChatExceptionEnum.APP_KEY_ERROR.getCode(), 
        ChatExceptionEnum.APP_KEY_ERROR.getMsg());
    }
    try
    {
      JerseyWebTarget webTarget = EndPoints.USERS_TARGET
        .resolveTemplate("org_name", this.APPKEY.split("#")[0])
        .resolveTemplate("app_name", this.APPKEY.split("#")[1])
        .path(userName);
      objectNode = JerseyUtils.sendRequest(webTarget, null, this.credential, 
        "DELETE", null);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return objectNode;
  }
  
  protected ObjectNode getChatMessages(ObjectNode queryStrNode)
  {
    ObjectNode objectNode = this.factory.objectNode();
    if (!JerseyUtils.match("^(?!-)[0-9a-zA-Z\\-]+#[0-9a-zA-Z]+", this.APPKEY))
    {
      objectNode.put("message", "Bad format of Appkey");
      return objectNode;
    }
    try
    {
      JerseyWebTarget webTarget = EndPoints.CHATMESSAGES_TARGET
        .resolveTemplate("org_name", this.APPKEY.split("#")[0])
        .resolveTemplate("app_name", this.APPKEY.split("#")[1]);
      if ((queryStrNode != null) && (queryStrNode.get("ql") != null) && 
        (!StringUtils.isEmpty(queryStrNode.get("ql").asText()))) {
        webTarget = webTarget.queryParam("ql", new Object[] {queryStrNode.get("ql")
          .asText() });
      }
      if ((queryStrNode != null) && (queryStrNode.get("limit") != null) && 
        (!StringUtils.isEmpty(queryStrNode.get("limit").asText()))) {
        webTarget = webTarget.queryParam("limit", new Object[] {
          queryStrNode.get("limit").asText() });
      }
      if ((queryStrNode != null) && 
        (queryStrNode.get("cursor") != null)) {
        if (!StringUtils.isEmpty(queryStrNode.get("cursor").asText())) {
          webTarget = webTarget.queryParam("cursor", new Object[] {
            queryStrNode.get("cursor").asText() });
        }
      }
      objectNode = JerseyUtils.sendRequest(webTarget, null, this.credential, 
        "GET", null);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return objectNode;
  }
  
  protected ObjectNode imUserLogin(String username, String password)
    throws ChatException
  {
    ObjectNode objectNode = this.factory.objectNode();
    if (!JerseyUtils.match("^(?!-)[0-9a-zA-Z\\-]+#[0-9a-zA-Z]+", this.APPKEY)) {
      throw new ChatException(ChatExceptionEnum.APP_KEY_ERROR.getCode(), 
        ChatExceptionEnum.APP_KEY_ERROR.getMsg());
    }
    if (StringUtils.isEmpty(username)) {
      throw new ChatException(
        ChatExceptionEnum.USERNAME_NOT_NULL.getCode(), 
        ChatExceptionEnum.USERNAME_NOT_NULL.getMsg());
    }
    if (StringUtils.isEmpty(password)) {
      throw new ChatException(
        ChatExceptionEnum.PASSWORD_NOT_NULL.getCode(), 
        ChatExceptionEnum.PASSWORD_NOT_NULL.getMsg());
    }
    try
    {
      ObjectNode dataNode = this.factory.objectNode();
      dataNode.put("grant_type", "password");
      dataNode.put("username", username);
      dataNode.put("password", password);
      List<NameValuePair> headers = new ArrayList();
      headers.add(new BasicNameValuePair("Content-Type", 
        "application/json"));
      objectNode = JerseyUtils.sendRequest(EndPoints.TOKEN_APP_TARGET
        .resolveTemplate("org_name", this.APPKEY.split("#")[0])
        .resolveTemplate("app_name", this.APPKEY.split("#")[1]), 
        dataNode, null, "POST", headers);
    }
    catch (Exception e)
    {
      throw new ChatException(ChatExceptionEnum.TOKEN_ERROR.getCode(), 
        ChatExceptionEnum.TOKEN_ERROR.getMsg());
    }
    return objectNode;
  }
  
  protected ObjectNode isOnline(String targetUserName)
    throws ChatException
  {
    ObjectNode objectNode = this.factory.objectNode();
    if (!JerseyUtils.match("^(?!-)[0-9a-zA-Z\\-]+#[0-9a-zA-Z]+", this.APPKEY)) {
      throw new ChatException(ChatExceptionEnum.APP_KEY_ERROR.getCode(), 
        ChatExceptionEnum.APP_KEY_ERROR.getMsg());
    }
    if (StringUtils.isEmpty(targetUserName)) {
      throw new ChatException(
        ChatExceptionEnum.USERNAME_NOT_NULL.getCode(), 
        ChatExceptionEnum.USERNAME_NOT_NULL.getMsg());
    }
    JerseyWebTarget webTarget = EndPoints.USERS_TARGET
      .resolveTemplate("org_name", this.APPKEY.split("#")[0])
      .resolveTemplate("app_name", this.APPKEY.split("#")[1])
      .path(targetUserName).path("status");
    
    objectNode = JerseyUtils.sendRequest(webTarget, null, this.credential, 
      "GET", null);
    return objectNode;
  }
  
  protected ObjectNode modifyIMUserNicknameWithAdminToken(String userName, ObjectNode dataObjectNode)
    throws ChatException
  {
    ObjectNode objectNode = this.factory.objectNode();
    if (!JerseyUtils.match("^(?!-)[0-9a-zA-Z\\-]+#[0-9a-zA-Z]+", this.APPKEY)) {
      throw new ChatException(ChatExceptionEnum.APP_KEY_ERROR.getCode(), 
        ChatExceptionEnum.APP_KEY_ERROR.getMsg());
    }
    if (StringUtils.isEmpty(userName)) {
      throw new ChatException(
        ChatExceptionEnum.USERNAME_NOT_NULL.getCode(), 
        ChatExceptionEnum.USERNAME_NOT_NULL.getMsg());
    }
    if ((dataObjectNode != null) && (!dataObjectNode.has("nickname"))) {
      throw new ChatException(
        ChatExceptionEnum.NICKNAME_NOT_NULL.getCode(), 
        ChatExceptionEnum.NICKNAME_NOT_NULL.getMsg());
    }
    JerseyWebTarget webTarget = EndPoints.USERS_TARGET
      .resolveTemplate("org_name", this.APPKEY.split("#")[0])
      .resolveTemplate("app_name", this.APPKEY.split("#")[1])
      .path(userName);
    objectNode = JerseyUtils.sendRequest(webTarget, dataObjectNode, 
      this.credential, "PUT", null);
    return objectNode;
  }
  
  protected ObjectNode modifyIMUserPasswordWithAdminToken(String userName, ObjectNode dataObjectNode)
    throws ChatException
  {
    ObjectNode objectNode = this.factory.objectNode();
    if (!JerseyUtils.match("^(?!-)[0-9a-zA-Z\\-]+#[0-9a-zA-Z]+", this.APPKEY)) {
      throw new ChatException(ChatExceptionEnum.APP_KEY_ERROR.getCode(), 
        ChatExceptionEnum.APP_KEY_ERROR.getMsg());
    }
    if (StringUtils.isEmpty(userName)) {
      throw new ChatException(
        ChatExceptionEnum.USERNAME_NOT_NULL.getCode(), 
        ChatExceptionEnum.USERNAME_NOT_NULL.getMsg());
    }
    if ((dataObjectNode != null) && (!dataObjectNode.has("newpassword"))) {
      throw new ChatException(
        ChatExceptionEnum.PASSWORD_NOT_NULL.getCode(), 
        ChatExceptionEnum.PASSWORD_NOT_NULL.getMsg());
    }
    JerseyWebTarget webTarget = EndPoints.USERS_TARGET
      .resolveTemplate("org_name", this.APPKEY.split("#")[0])
      .resolveTemplate("app_name", this.APPKEY.split("#")[1])
      .path(userName).path("password");
    objectNode = JerseyUtils.sendRequest(webTarget, dataObjectNode, 
      this.credential, "PUT", null);
    return objectNode;
  }
  
  protected ObjectNode sendMessages(ArrayNode target, ObjectNode msg, String from, ObjectNode ext)
    throws ChatException
  {
    ObjectNode objectNode = this.factory.objectNode();
    ObjectNode dataNode = this.factory.objectNode();
    if (!JerseyUtils.match("^(?!-)[0-9a-zA-Z\\-]+#[0-9a-zA-Z]+", this.APPKEY)) {
      throw new ChatException(ChatExceptionEnum.APP_KEY_ERROR.getCode(), 
        ChatExceptionEnum.APP_KEY_ERROR.getMsg());
    }
    dataNode.put("target_type", "users");
    dataNode.set("target", target);
    dataNode.set("msg", msg);
    dataNode.put("from", from);
    if (ext != null) {
      dataNode.set("ext", ext);
    }
    JerseyWebTarget webTarget = EndPoints.MESSAGES_TARGET.resolveTemplate(
      "org_name", this.APPKEY.split("#")[0]).resolveTemplate("app_name", 
      this.APPKEY.split("#")[1]);
    
    objectNode = JerseyUtils.sendRequest(webTarget, dataNode, this.credential, 
      "POST", null);
    return objectNode;
  }
}
