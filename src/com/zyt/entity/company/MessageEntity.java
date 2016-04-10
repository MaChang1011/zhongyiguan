package com.zyt.entity.company;

import java.sql.Timestamp;

import com.zyt.base.BaseEntity;

public class MessageEntity
  extends BaseEntity
{
  private String title;
  private String content;
  private String image;
  private Timestamp pubtime;
  private String origin;
  private int pubuser;
  private int isCollection;
  
  public String getTitle()
  {
    return this.title;
  }
  
  public String getContent()
  {
    return this.content;
  }
  
  public String getImage()
  {
    return this.image;
  }
  
  public Timestamp getPubtime()
  {
    return this.pubtime;
  }
  
  public String getOrigin()
  {
    return this.origin;
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
  
  public void setContent(String content)
  {
    this.content = content;
  }
  
  public void setImage(String image)
  {
    this.image = image;
  }
  
  public void setPubtime(Timestamp pubtime)
  {
    this.pubtime = pubtime;
  }
  
  public void setOrigin(String origin)
  {
    this.origin = origin;
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
    return "MessageEntity(title=" + getTitle() + ", content=" + getContent() + ", image=" + getImage() + ", pubtime=" + getPubtime() + ", origin=" + getOrigin() + ", pubuser=" + getPubuser() + ", isCollection=" + getIsCollection() + ")";
  }
  
  public boolean equals(Object o)
  {
    if (o == this) {
      return true;
    }
    if (!(o instanceof MessageEntity)) {
      return false;
    }
    MessageEntity other = (MessageEntity)o;
    if (!other.canEqual(this)) {
      return false;
    }
    Object this$title = getTitle();Object other$title = other.getTitle();
    if (this$title == null ? other$title != null : !this$title.equals(other$title)) {
      return false;
    }
    Object this$content = getContent();Object other$content = other.getContent();
    if (this$content == null ? other$content != null : !this$content.equals(other$content)) {
      return false;
    }
    Object this$image = getImage();Object other$image = other.getImage();
    if (this$image == null ? other$image != null : !this$image.equals(other$image)) {
      return false;
    }
    Object this$pubtime = getPubtime();Object other$pubtime = other.getPubtime();
    if (this$pubtime == null ? other$pubtime != null : !this$pubtime.equals(other$pubtime)) {
      return false;
    }
    Object this$origin = getOrigin();Object other$origin = other.getOrigin();
    if (this$origin == null ? other$origin != null : !this$origin.equals(other$origin)) {
      return false;
    }
    if (getPubuser() != other.getPubuser()) {
      return false;
    }
    return getIsCollection() == other.getIsCollection();
  }
  
  protected boolean canEqual(Object other)
  {
    return other instanceof MessageEntity;
  }
  
  public int hashCode()
  {
    int PRIME = 59;int result = 1;Object $title = getTitle();result = result * 59 + ($title == null ? 0 : $title.hashCode());Object $content = getContent();result = result * 59 + ($content == null ? 0 : $content.hashCode());Object $image = getImage();result = result * 59 + ($image == null ? 0 : $image.hashCode());Object $pubtime = getPubtime();result = result * 59 + ($pubtime == null ? 0 : $pubtime.hashCode());Object $origin = getOrigin();result = result * 59 + ($origin == null ? 0 : $origin.hashCode());result = result * 59 + getPubuser();result = result * 59 + getIsCollection();return result;
  }
}