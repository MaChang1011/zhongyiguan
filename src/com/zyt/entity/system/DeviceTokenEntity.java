package com.zyt.entity.system;

import com.zyt.base.BaseEntity;

public class DeviceTokenEntity
  extends BaseEntity
{
  private String deviceToken;
  
  public String getDeviceToken()
  {
    return this.deviceToken;
  }
  
  public int getIsPush()
  {
    return this.isPush;
  }
  
  public void setDeviceToken(String deviceToken)
  {
    this.deviceToken = deviceToken;
  }
  
  public void setIsPush(int isPush)
  {
    this.isPush = isPush;
  }
  
  public String toString()
  {
    return "DeviceTokenEntity(deviceToken=" + getDeviceToken() + ", isPush=" + getIsPush() + ")";
  }
  
  public boolean equals(Object o)
  {
    if (o == this) {
      return true;
    }
    if (!(o instanceof DeviceTokenEntity)) {
      return false;
    }
    DeviceTokenEntity other = (DeviceTokenEntity)o;
    if (!other.canEqual(this)) {
      return false;
    }
    Object this$deviceToken = getDeviceToken();Object other$deviceToken = other.getDeviceToken();
    if (this$deviceToken == null ? other$deviceToken != null : !this$deviceToken.equals(other$deviceToken)) {
      return false;
    }
    return getIsPush() == other.getIsPush();
  }
  
  protected boolean canEqual(Object other)
  {
    return other instanceof DeviceTokenEntity;
  }
  
  public int hashCode()
  {
    int PRIME = 59;int result = 1;Object $deviceToken = getDeviceToken();result = result * 59 + ($deviceToken == null ? 0 : $deviceToken.hashCode());result = result * 59 + getIsPush();return result;
  }
  
  private int isPush = 1;
}

