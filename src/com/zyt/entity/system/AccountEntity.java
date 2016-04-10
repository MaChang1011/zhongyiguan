package com.zyt.entity.system;

import com.zyt.base.BaseEntity;

public class AccountEntity
  extends BaseEntity
{
  private String uid;
  private String token;
  private String mobile;
  private int type;
  private String nickname;
  
  public String getUid()
  {
    return this.uid;
  }
  
  public String getToken()
  {
    return this.token;
  }
  
  public String getMobile()
  {
    return this.mobile;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public String getNickname()
  {
    return this.nickname;
  }
  
  public void setUid(String uid)
  {
    this.uid = uid;
  }
  
  public void setToken(String token)
  {
    this.token = token;
  }
  
  public void setMobile(String mobile)
  {
    this.mobile = mobile;
  }
  
  public void setType(int type)
  {
    this.type = type;
  }
  
  public void setNickname(String nickname)
  {
    this.nickname = nickname;
  }
  
  public String toString()
  {
    return "AccountEntity(uid=" + getUid() + ", token=" + getToken() + ", mobile=" + getMobile() + ", type=" + getType() + ", nickname=" + getNickname() + ")";
  }
  
  public boolean equals(Object o)
  {
    if (o == this) {
      return true;
    }
    if (!(o instanceof AccountEntity)) {
      return false;
    }
    AccountEntity other = (AccountEntity)o;
    if (!other.canEqual(this)) {
      return false;
    }
    Object this$uid = getUid();Object other$uid = other.getUid();
    if (this$uid == null ? other$uid != null : !this$uid.equals(other$uid)) {
      return false;
    }
    Object this$token = getToken();Object other$token = other.getToken();
    if (this$token == null ? other$token != null : !this$token.equals(other$token)) {
      return false;
    }
    Object this$mobile = getMobile();Object other$mobile = other.getMobile();
    if (this$mobile == null ? other$mobile != null : !this$mobile.equals(other$mobile)) {
      return false;
    }
    if (getType() != other.getType()) {
      return false;
    }
    Object this$nickname = getNickname();Object other$nickname = other.getNickname();return this$nickname == null ? other$nickname == null : this$nickname.equals(other$nickname);
  }
  
  protected boolean canEqual(Object other)
  {
    return other instanceof AccountEntity;
  }
  
  public int hashCode()
  {
    int PRIME = 59;int result = 1;Object $uid = getUid();result = result * 59 + ($uid == null ? 0 : $uid.hashCode());Object $token = getToken();result = result * 59 + ($token == null ? 0 : $token.hashCode());Object $mobile = getMobile();result = result * 59 + ($mobile == null ? 0 : $mobile.hashCode());result = result * 59 + getType();Object $nickname = getNickname();result = result * 59 + ($nickname == null ? 0 : $nickname.hashCode());return result;
  }
}

