package com.zyt.cons;

public enum ReservationType
{
  DEFAULT(0, "Ä¬ÈÏ"),  AGREE(1, "Í¬Òâ"),  REFUSE(2, "¾Ü¾ø");
  
  private int status;
  private String msg;
  
  private ReservationType(int status, String msg)
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
