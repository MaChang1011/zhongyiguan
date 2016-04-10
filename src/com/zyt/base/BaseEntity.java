package com.zyt.base;

public class BaseEntity
{
  protected int id;
  
  public String toString()
  {
    return "BaseEntity(id=" + getId() + ")";
  }
  
  public int hashCode()
  {
    int PRIME = 59;int result = 1;result = result * 59 + getId();return result;
  }
  
  protected boolean canEqual(Object other)
  {
    return other instanceof BaseEntity;
  }
  
  public boolean equals(Object o)
  {
    if (o == this) {
      return true;
    }
    if (!(o instanceof BaseEntity)) {
      return false;
    }
    BaseEntity other = (BaseEntity)o;
    if (!other.canEqual(this)) {
      return false;
    }
    return getId() == other.getId();
  }
  
  public void setId(int id)
  {
    this.id = id;
  }
  
  public int getId()
  {
    return this.id;
  }
}