package com.zyt.cons;

public enum ChatStatus
{
  OFFLINE(0, "����"),  ONLINE(1, "����"),  BUSY(2, "æµ");
  
  private int status;
  private String descr;
  
  private ChatStatus(int status, String descr)
  {
    this.status = status;
    this.descr = descr;
  }
  
  public String getDescr()
  {
    return this.descr;
  }
  
  public int getStatus()
  {
    return this.status;
  }
  
  public void setDescr(String descr)
  {
    this.descr = descr;
  }
  
  public void setStatus(int status)
  {
    this.status = status;
  }
}
