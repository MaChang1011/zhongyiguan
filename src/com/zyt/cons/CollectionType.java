package com.zyt.cons;


public enum CollectionType
{
  PRODUCT(1, "��Ʒ"),  MESSAGE(2, "��ѯ"),  DOCTOR(3, "ҽ��");
  
  private int type;
  private String descr;
  
  private CollectionType(int type, String descr)
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
