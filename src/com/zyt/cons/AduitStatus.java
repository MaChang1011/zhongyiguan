package com.zyt.cons;

public enum AduitStatus
{
  WAITING(0, "�����"),  PASSED(10, "ͨ��"),  FAILED(20, "δͨ��");
  
  private int status;
  private String descr;
  
  private AduitStatus(int status, String descr)
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
