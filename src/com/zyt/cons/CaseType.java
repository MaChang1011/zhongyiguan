package com.zyt.cons;

public enum CaseType
{
  JDAL(10, "经典案例"),  XXZJ(10, "心血之家");
  
  private int type;
  private String descr;
  
  private CaseType(int type, String descr)
  {
    this.type = type;
    this.descr = descr;
  }
  
  public String getDescr()
  {
    return this.descr;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public void setDescr(String descr)
  {
    this.descr = descr;
  }
  
  public void setType(int type)
  {
    this.type = type;
  }
}
