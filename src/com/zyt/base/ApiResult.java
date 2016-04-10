package com.zyt.base;

import java.beans.ConstructorProperties;

public class ApiResult
{
  private int result;
  private String msg;
  
  public int getResult()
  {
    return this.result;
  }
  
  public String getMsg()
  {
    return this.msg;
  }
  
  public void setResult(int result)
  {
    this.result = result;
  }
  
  public void setMsg(String msg)
  {
    this.msg = msg;
  }
  
  public boolean equals(Object o)
  {
    if (o == this) {
      return true;
    }
    if (!(o instanceof ApiResult)) {
      return false;
    }
    ApiResult other = (ApiResult)o;
    if (!other.canEqual(this)) {
      return false;
    }
    if (getResult() != other.getResult()) {
      return false;
    }
    Object this$msg = getMsg();Object other$msg = other.getMsg();return this$msg == null ? other$msg == null : this$msg.equals(other$msg);
  }
  
  protected boolean canEqual(Object other)
  {
    return other instanceof ApiResult;
  }
  
  public int hashCode()
  {
    int PRIME = 59;int result = 1;result = result * 59 + getResult();Object $msg = getMsg();result = result * 59 + ($msg == null ? 0 : $msg.hashCode());return result;
  }
  
  public String toString()
  {
    return "ApiResult(result=" + getResult() + ", msg=" + getMsg() + ")";
  }
  
  @ConstructorProperties({"result", "msg"})
  public ApiResult(int result, String msg)
  {
    this.result = result;this.msg = msg;
  }
  
  public ApiResult(int result)
  {
    this.result = result;
  }
  
  public ApiResult() {}
}
