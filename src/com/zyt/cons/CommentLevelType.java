package com.zyt.cons;

public enum CommentLevelType
{
  PERFECT(1, "很满意"),  GOOD(2, "满意"),  UNSATISFY(3, "不满意");
  
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
