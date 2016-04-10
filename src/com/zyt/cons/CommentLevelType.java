package com.zyt.cons;

public enum CommentLevelType
{
  PERFECT(1, "������"),  GOOD(2, "����"),  UNSATISFY(3, "������");
  
  private int status;
  private String msg;
  
  private CommentLevelType(int status, String msg)
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
