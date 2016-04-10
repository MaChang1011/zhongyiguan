package com.zyt.cons;

public enum DiagnoseStatus
{
  WAIT_ANSWER(1, "待回复"),  WAIT_COMMENT(2, "已回复"),  COMPLETE(3, "已评价");
  
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
