package com.zyt.bo.company;

import com.zyt.entity.company.MessageEntity;

public class MessageBo
  extends MessageEntity
{
  private int isCollection;
  
  public int getIsCollection()
  {
    return this.isCollection;
  }
  
  public void setIsCollection(int isCollection)
  {
    this.isCollection = isCollection;
  }
  
  public String toString()
  {
    return "MessageBo(isCollection=" + getIsCollection() + ")";
  }
  
  public boolean equals(Object o)
  {
    if (o == this) {
      return true;
    }
    if (!(o instanceof MessageBo)) {
      return false;
    }
    MessageBo other = (MessageBo)o;
    if (!other.canEqual(this)) {
      return false;
    }
    return getIsCollection() == other.getIsCollection();
  }
  
  protected boolean canEqual(Object other)
  {
    return other instanceof MessageBo;
  }
  
  public int hashCode()
  {
    int PRIME = 59;int result = 1;result = result * 59 + getIsCollection();return result;
  }
}
