package com.zyt.chat.comm;


public enum ChatExceptionEnum
{
  APP_KEY_ERROR(100, "AppKey��ʽ����"),  USERNAME_NOT_NULL(200, "�û�������Ϊ��"),  PASSWORD_NOT_NULL(201, "���벻��Ϊ��"),  NICKNAME_NOT_NULL(202, "�ǳƲ���Ϊ��"),  TOKEN_ERROR(301, "��ȡtoken�쳣"),  CHAT_TYPE_ERROR(303, "��Ϣ�����쳣");
  
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
