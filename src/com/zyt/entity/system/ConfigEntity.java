package com.zyt.entity.system;

import com.zyt.base.BaseEntity;

public class ConfigEntity
  extends BaseEntity
{
  private String title;
  private String flag;
  private String content;
  
  public String getTitle()
  {
    return this.title;
  }
  
  public String getFlag()
  {
    return this.flag;
  }
  
  public String getContent()
  {
    return this.content;
  }
  
  public void setTitle(String title)
  {
    this.title = title;
  }
  
  public void setFlag(String flag)
  {
    this.flag = flag;
  }
  
  public void setContent(String content)
  {
    this.content = content;
  }
  
  public String toString()
  {
    return "ConfigEntity(title=" + getTitle() + ", flag=" + getFlag() + ", content=" + getContent() + ")";
  }
  
  public boolean equals(Object o)
  {
    if (o == this) {
      return true;
    }
    if (!(o instanceof ConfigEntity)) {
      return false;
    }
    ConfigEntity other = (ConfigEntity)o;
    if (!other.canEqual(this)) {
      return false;
    }
    Object this$title = getTitle();Object other$title = other.getTitle();
    if (this$title == null ? other$title != null : !this$title.equals(other$title)) {
      return false;
    }
    Object this$flag = getFlag();Object other$flag = other.getFlag();
    if (this$flag == null ? other$flag != null : !this$flag.equals(other$flag)) {
      return false;
    }
    Object this$content = getContent();Object other$content = other.getContent();return this$content == null ? other$content == null : this$content.equals(other$content);
  }
  
  protected boolean canEqual(Object other)
  {
    return other instanceof ConfigEntity;
  }
  
  public int hashCode()
  {
    int PRIME = 59;int result = 1;Object $title = getTitle();result = result * 59 + ($title == null ? 0 : $title.hashCode());Object $flag = getFlag();result = result * 59 + ($flag == null ? 0 : $flag.hashCode());Object $content = getContent();result = result * 59 + ($content == null ? 0 : $content.hashCode());return result;
  }
}

