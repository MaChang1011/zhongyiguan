package com.zyt.chat.comm;


public enum ChatExceptionEnum
{
  APP_KEY_ERROR(100, "AppKey格式错误"),  USERNAME_NOT_NULL(200, "用户名不能为空"),  PASSWORD_NOT_NULL(201, "密码不能为空"),  NICKNAME_NOT_NULL(202, "昵称不能为空"),  TOKEN_ERROR(301, "获取token异常"),  CHAT_TYPE_ERROR(303, "消息类型异常");
  
  private int code;
  private String msg;
  
  private ChatExceptionEnum(int code, String msg)
  {
    this.code = code;
    this.msg = msg;
  }
  
  public int getCode()
  {
    return this.code;
  }
  
  public String getMsg()
  {
    return this.msg;
  }
  
  public void setCode(int code)
  {
    this.code = code;
  }
  
  public void setMsg(String msg)
  {
    this.msg = msg;
  }
}
