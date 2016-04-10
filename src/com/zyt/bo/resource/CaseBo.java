package com.zyt.bo.resource;

import java.util.Date;

import com.zyt.base.BaseEntity;


public class CaseBo
  extends BaseEntity
{
  private String title;
  private String category;
  private String content;
  private String images;
  private Date pubtime;
  public int status;
  private String pubuser;
  private int type;
  
  public String getTitle()
  {
    return this.title;
  }
  
  public String getCategory()
  {
    return this.category;
  }
  
  public String getContent()
  {
    return this.content;
  }
  
  public String getImages()
  {
    return this.images;
  }
  
  public Date getPubtime()
  {
    return this.pubtime;
  }
  
  public int getStatus()
  {
    return this.status;
  }
  
  public String getPubuser()
  {
    return this.pubuser;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public void setTitle(String title)
  {
    this.title = title;
  }
  
  public void setCategory(String category)
  {
    this.category = category;
  }
  
  public void setContent(String content)
  {
    this.content = content;
  }
  
  public void setImages(String images)
  {
    this.images = images;
  }
  
  public void setPubtime(Date pubtime)
  {
    this.pubtime = pubtime;
  }
  
  public void setStatus(int status)
  {
    this.status = status;
  }
  
  public void setPubuser(String pubuser)
  {
    this.pubuser = pubuser;
  }
  
  public void setType(int type)
  {
    this.type = type;
  }
  
  public String toString()
  {
    return "CaseBo(title=" + getTitle() + ", category=" + getCategory() + ", content=" + getContent() + ", images=" + getImages() + ", pubtime=" + getPubtime() + ", status=" + getStatus() + ", pubuser=" + getPubuser() + ", type=" + getType() + ")";
  }
  
  public boolean equals(Object o)
  {
    if (o == this) {
      return true;
    }
    if (!(o instanceof CaseBo)) {
      return false;
    }
    CaseBo other = (CaseBo)o;
    if (!other.canEqual(this)) {
      return false;
    }
    Object this$title = getTitle();Object other$title = other.getTitle();
    if (this$title == null ? other$title != null : !this$title.equals(other$title)) {
      return false;
    }
    Object this$category = getCategory();Object other$category = other.getCategory();
    if (this$category == null ? other$category != null : !this$category.equals(other$category)) {
      return false;
    }
    Object this$content = getContent();Object other$content = other.getContent();
    if (this$content == null ? other$content != null : !this$content.equals(other$content)) {
      return false;
    }
    Object this$images = getImages();Object other$images = other.getImages();
    if (this$images == null ? other$images != null : !this$images.equals(other$images)) {
      return false;
    }
    Object this$pubtime = getPubtime();Object other$pubtime = other.getPubtime();
    if (this$pubtime == null ? other$pubtime != null : !this$pubtime.equals(other$pubtime)) {
      return false;
    }
    if (getStatus() != other.getStatus()) {
      return false;
    }
    Object this$pubuser = getPubuser();Object other$pubuser = other.getPubuser();
    if (this$pubuser == null ? other$pubuser != null : !this$pubuser.equals(other$pubuser)) {
      return false;
    }
    return getType() == other.getType();
  }
  
  protected boolean canEqual(Object other)
  {
    return other instanceof CaseBo;
  }
  
  public int hashCode()
  {
    int PRIME = 59;int result = 1;Object $title = getTitle();result = result * 59 + ($title == null ? 0 : $title.hashCode());Object $category = getCategory();result = result * 59 + ($category == null ? 0 : $category.hashCode());Object $content = getContent();result = result * 59 + ($content == null ? 0 : $content.hashCode());Object $images = getImages();result = result * 59 + ($images == null ? 0 : $images.hashCode());Object $pubtime = getPubtime();result = result * 59 + ($pubtime == null ? 0 : $pubtime.hashCode());result = result * 59 + getStatus();Object $pubuser = getPubuser();result = result * 59 + ($pubuser == null ? 0 : $pubuser.hashCode());result = result * 59 + getType();return result;
  }
}
