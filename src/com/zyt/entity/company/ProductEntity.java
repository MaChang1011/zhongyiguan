package com.zyt.entity.company;

import java.sql.Timestamp;

import com.zyt.base.BaseEntity;


public class ProductEntity
  extends BaseEntity
{
  private String title;
  private String name;
  private String standard;
  private String image;
  private String descr;
  private Timestamp pubtime;
  private int pubuser;
  private int isCollection;
  
  public String getTitle()
  {
    return this.title;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getStandard()
  {
    return this.standard;
  }
  
  public String getImage()
  {
    return this.image;
  }
  
  public String getDescr()
  {
    return this.descr;
  }
  
  public Timestamp getPubtime()
  {
    return this.pubtime;
  }
  
  public int getPubuser()
  {
    return this.pubuser;
  }
  
  public int getIsCollection()
  {
    return this.isCollection;
  }
  
  public void setTitle(String title)
  {
    this.title = title;
  }
  
  public void setName(String name)
  {
    this.name = name;
  }
  
  public void setStandard(String standard)
  {
    this.standard = standard;
  }
  
  public void setImage(String image)
  {
    this.image = image;
  }
  
  public void setDescr(String descr)
  {
    this.descr = descr;
  }
  
  public void setPubtime(Timestamp pubtime)
  {
    this.pubtime = pubtime;
  }
  
  public void setPubuser(int pubuser)
  {
    this.pubuser = pubuser;
  }
  
  public void setIsCollection(int isCollection)
  {
    this.isCollection = isCollection;
  }
  
  public String toString()
  {
    return "ProductEntity(title=" + getTitle() + ", name=" + getName() + ", standard=" + getStandard() + ", image=" + getImage() + ", descr=" + getDescr() + ", pubtime=" + getPubtime() + ", pubuser=" + getPubuser() + ", isCollection=" + getIsCollection() + ")";
  }
  
  public boolean equals(Object o)
  {
    if (o == this) {
      return true;
    }
    if (!(o instanceof ProductEntity)) {
      return false;
    }
    ProductEntity other = (ProductEntity)o;
    if (!other.canEqual(this)) {
      return false;
    }
    Object this$title = getTitle();Object other$title = other.getTitle();
    if (this$title == null ? other$title != null : !this$title.equals(other$title)) {
      return false;
    }
    Object this$name = getName();Object other$name = other.getName();
    if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
      return false;
    }
    Object this$standard = getStandard();Object other$standard = other.getStandard();
    if (this$standard == null ? other$standard != null : !this$standard.equals(other$standard)) {
      return false;
    }
    Object this$image = getImage();Object other$image = other.getImage();
    if (this$image == null ? other$image != null : !this$image.equals(other$image)) {
      return false;
    }
    Object this$descr = getDescr();Object other$descr = other.getDescr();
    if (this$descr == null ? other$descr != null : !this$descr.equals(other$descr)) {
      return false;
    }
    Object this$pubtime = getPubtime();Object other$pubtime = other.getPubtime();
    if (this$pubtime == null ? other$pubtime != null : !this$pubtime.equals(other$pubtime)) {
      return false;
    }
    if (getPubuser() != other.getPubuser()) {
      return false;
    }
    return getIsCollection() == other.getIsCollection();
  }
  
  protected boolean canEqual(Object other)
  {
    return other instanceof ProductEntity;
  }
  
  public int hashCode()
  {
    int PRIME = 59;int result = 1;Object $title = getTitle();result = result * 59 + ($title == null ? 0 : $title.hashCode());Object $name = getName();result = result * 59 + ($name == null ? 0 : $name.hashCode());Object $standard = getStandard();result = result * 59 + ($standard == null ? 0 : $standard.hashCode());Object $image = getImage();result = result * 59 + ($image == null ? 0 : $image.hashCode());Object $descr = getDescr();result = result * 59 + ($descr == null ? 0 : $descr.hashCode());Object $pubtime = getPubtime();result = result * 59 + ($pubtime == null ? 0 : $pubtime.hashCode());result = result * 59 + getPubuser();result = result * 59 + getIsCollection();return result;
  }
}
