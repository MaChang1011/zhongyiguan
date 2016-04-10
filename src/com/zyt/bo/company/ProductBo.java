package com.zyt.bo.company;

import com.zyt.entity.company.ProductEntity;

public class ProductBo
  extends ProductEntity
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
    return "ProductBo(isCollection=" + getIsCollection() + ")";
  }
  
  public boolean equals(Object o)
  {
    if (o == this) {
      return true;
    }
    if (!(o instanceof ProductBo)) {
      return false;
    }
    ProductBo other = (ProductBo)o;
    if (!other.canEqual(this)) {
      return false;
    }
    return getIsCollection() == other.getIsCollection();
  }
  
  protected boolean canEqual(Object other)
  {
    return other instanceof ProductBo;
  }
  
  public int hashCode()
  {
    int PRIME = 59;int result = 1;result = result * 59 + getIsCollection();return result;
  }
}

