package com.zyt.chat.comm;

public class ChatException
  extends Exception
{
  private static final long serialVersionUID = 1L;
  private int code;
  private String msg;
  
  public ChatException(int code, String msg)
  {
    this.code = code;
    this.msg = msg;
  }
  
  public int getCode()
  {
    return this.code;
  }
  
  public String getMessage()
  {
    return this.msg;
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
