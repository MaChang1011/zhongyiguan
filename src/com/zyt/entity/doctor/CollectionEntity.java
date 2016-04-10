package com.zyt.entity.doctor;

import java.sql.Timestamp;

import com.zyt.base.BaseEntity;

/*
 * 收藏实体类
 * */
public class CollectionEntity
  extends BaseEntity
{
  private int userId;
  private int type;
  private int recordId;
  private Timestamp createTime;
  
  public int getUserId()
  {
    return this.userId;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public int getRecordId()
  {
    return this.recordId;
  }
  
  public Timestamp getCreateTime()
  {
    return this.createTime;
  }
  
  public void setUserId(int userId)
  {
    this.userId = userId;
  }
  
  public void setType(int type)
  {
    this.type = type;
  }
  
  public void setRecordId(int recordId)
  {
    this.recordId = recordId;
  }
  
  public void setCreateTime(Timestamp createTime)
  {
    this.createTime = createTime;
  }
  
  public String toString()
  {
    return "CollectionEntity(userId=" + getUserId() + ", type=" + getType() + ", recordId=" + getRecordId() + ", createTime=" + getCreateTime() + ")";
  }
  
  public boolean equals(Object o)
  {
    if (o == this) {
      return true;
    }
    if (!(o instanceof CollectionEntity)) {
      return false;
    }
    CollectionEntity other = (CollectionEntity)o;
    if (!other.canEqual(this)) {
      return false;
    }
    if (getUserId() != other.getUserId()) {
      return false;
    }
    if (getType() != other.getType()) {
      return false;
    }
    if (getRecordId() != other.getRecordId()) {
      return false;
    }
    Object this$createTime = getCreateTime();Object other$createTime = other.getCreateTime();return this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime);
  }
  
  protected boolean canEqual(Object other)
  {
    return other instanceof CollectionEntity;
  }
  
  public int hashCode()
  {
    int PRIME = 59;int result = 1;result = result * 59 + getUserId();result = result * 59 + getType();result = result * 59 + getRecordId();Object $createTime = getCreateTime();result = result * 59 + ($createTime == null ? 0 : $createTime.hashCode());return result;
  }
}

