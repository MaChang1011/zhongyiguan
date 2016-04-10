package com.zyt.entity.resource;

import java.sql.Timestamp;
import com.zyt.base.BaseEntity;

/*
 * 经典案例实体类
 * */
public class CaseEntity
  extends BaseEntity
{
  private String title;
  private int category;
  private String content;
  private String images;
  private Timestamp pubtime;
  public int status;
  private int pubuser;
  
  public String getTitle()
  {
    return this.title;
  }
  
  public int getCategory()
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
  
  public Timestamp getPubtime()
  {
    return this.pubtime;
  }
  
  public int getStatus()
  {
    return this.status;
  }
  
  public int getPubuser()
  {
    return this.pubuser;
  }
  
  public void setTitle(String title)
  {
    this.title = title;
  }
  
  public void setCategory(int category)
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
  
  public void setPubtime(Timestamp pubtime)
  {
    this.pubtime = pubtime;
  }
  
  public void setStatus(int status)
  {
    this.status = status;
  }
  
  public void setPubuser(int pubuser)
  {
    this.pubuser = pubuser;
  }
  
  public String toString()
  {
    return "CaseEntity(title=" + getTitle() + ", category=" + getCategory() + ", content=" + getContent() + ", images=" + getImages() + ", pubtime=" + getPubtime() + ", status=" + getStatus() + ", pubuser=" + getPubuser() + ")";
  }
  
  public boolean equals(Object o)
  {
    if (o == this) {
      return true;
    }
    if (!(o instanceof CaseEntity)) {
      return false;
    }
    CaseEntity other = (CaseEntity)o;
    if (!other.canEqual(this)) {
      return false;
    }
    Object this$title = getTitle();Object other$title = other.getTitle();
    if (this$title == null ? other$title != null : !this$title.equals(other$title)) {
      return false;
    }
    if (getCategory() != other.getCategory()) {
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
    return getPubuser() == other.getPubuser();
  }
  
  protected boolean canEqual(Object other)
  {
    return other instanceof CaseEntity;
  }
  
  public int hashCode()
  {
    int PRIME = 59;int result = 1;Object $title = getTitle();result = result * 59 + ($title == null ? 0 : $title.hashCode());result = result * 59 + getCategory();Object $content = getContent();result = result * 59 + ($content == null ? 0 : $content.hashCode());Object $images = getImages();result = result * 59 + ($images == null ? 0 : $images.hashCode());Object $pubtime = getPubtime();result = result * 59 + ($pubtime == null ? 0 : $pubtime.hashCode());result = result * 59 + getStatus();result = result * 59 + getPubuser();return result;
  }
}

