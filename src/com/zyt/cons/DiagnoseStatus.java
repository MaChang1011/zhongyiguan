package com.zyt.cons;

public enum DiagnoseStatus
{
  WAIT_ANSWER(1, "���ظ�"),  WAIT_COMMENT(2, "�ѻظ�"),  COMPLETE(3, "������");
  
  private int status;
  private String msg;
  
  private DiagnoseStatus(int status, String msg)
  {
    this.status = status;
    this.msg = msg;
  }
  
  public String getMsg()
  {
    return this.msg;
  }
  
  public int getStatus()
  {
    return this.status;
  }
  
  public void setMsg(String msg)
  {
    this.msg = msg;
  }
  
  public void setStatus(int status)
  {
    this.status = status;
  }
}
