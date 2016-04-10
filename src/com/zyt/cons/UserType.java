package com.zyt.cons;

public enum UserType
{
  ADMIN(2, "����Ա"),  DOCTOR(1, "ҽ��"),  PATIENT(0, "����");
  
  private int type;
  private String descr;
  
  private UserType(int type, String descr)
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
