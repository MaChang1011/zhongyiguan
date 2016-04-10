package com.zyt.base;

import java.beans.ConstructorProperties;

public class AjaxResult
{
  public boolean isSuccess()
  {
    return this.success;
  }
  
  public String getMsg()
  {
    return this.msg;
  }
  
  public void setSuccess(boolean success)
  {
    this.success = success;
  }
  
  public void setMsg(String msg)
  {
    this.msg = msg;
  }
  
  public String toString()
  {
    return "AjaxResult(success=" + isSuccess() + ", msg=" + getMsg() + ")";
  }
  
  @ConstructorProperties({"success", "msg"})
  public AjaxResult(boolean success, String msg)
  {
    this.success = success;this.msg = msg;
  }
  
  public boolean equals(Object o)
  {
    if (o == this) {
      return true;
    }
    if (!(o instanceof AjaxResult)) {
      return false;
    }
    AjaxResult other = (AjaxResult)o;
    if (!other.canEqual(this)) {
      return false;
    }
    if (isSuccess() != other.isSuccess()) {
      return false;
    }
    Object this$msg = getMsg();Object other$msg = other.getMsg();return this$msg == null ? other$msg == null : this$msg.equals(other$msg);
  }
  
  protected boolean canEqual(Object other)
  {
    return other instanceof AjaxResult;
  }
  
  public int hashCode()
  {
    int PRIME = 59;int result = 1;result = result * 59 + (isSuccess() ? 79 : 97);Object $msg = getMsg();result = result * 59 + ($msg == null ? 0 : $msg.hashCode());return result;
  }
  
  private boolean success = true;
  private String msg = "操作成功";
  
  public AjaxResult() {}
}
