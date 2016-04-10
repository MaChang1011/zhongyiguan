package com.zyt.entity.system;

import java.util.List;

import com.zyt.base.BaseEntity;


/**
 * @author ljw
 * @Date 2016Äê3ÔÂ12ÈÕ
 * @Project zhongyiguan
 * @Version 1.0
 */
public class ModuleEntity
  extends BaseEntity
{
  private String name;
  private String url;
  private int parent;
  private int sort;
  private List<ModuleEntity> children;
  
  public String getName()
  {
    return this.name;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public int getParent()
  {
    return this.parent;
  }
  
  public int getSort()
  {
    return this.sort;
  }
  
  public List<ModuleEntity> getChildren()
  {
    return this.children;
  }
  
  public void setName(String name)
  {
    this.name = name;
  }
  
  public void setUrl(String url)
  {
    this.url = url;
  }
  
  public void setParent(int parent)
  {
    this.parent = parent;
  }
  
  public void setSort(int sort)
  {
    this.sort = sort;
  }
  
  public void setChildren(List<ModuleEntity> children)
  {
    this.children = children;
  }
  
  public String toString()
  {
    return "ModuleEntity(name=" + getName() + ", url=" + getUrl() + ", parent=" + getParent() + ", sort=" + getSort() + ", children=" + getChildren() + ")";
  }
  
  public boolean equals(Object o)
  {
    if (o == this) {
      return true;
    }
    if (!(o instanceof ModuleEntity)) {
      return false;
    }
    ModuleEntity other = (ModuleEntity)o;
    if (!other.canEqual(this)) {
      return false;
    }
    Object this$name = getName();Object other$name = other.getName();
    if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
      return false;
    }
    Object this$url = getUrl();Object other$url = other.getUrl();
    if (this$url == null ? other$url != null : !this$url.equals(other$url)) {
      return false;
    }
    if (getParent() != other.getParent()) {
      return false;
    }
    if (getSort() != other.getSort()) {
      return false;
    }
    Object this$children = getChildren();Object other$children = other.getChildren();return this$children == null ? other$children == null : this$children.equals(other$children);
  }
  
  protected boolean canEqual(Object other)
  {
    return other instanceof ModuleEntity;
  }
  
  public int hashCode()
  {
    int PRIME = 59;int result = 1;Object $name = getName();result = result * 59 + ($name == null ? 0 : $name.hashCode());Object $url = getUrl();result = result * 59 + ($url == null ? 0 : $url.hashCode());result = result * 59 + getParent();result = result * 59 + getSort();Object $children = getChildren();result = result * 59 + ($children == null ? 0 : $children.hashCode());return result;
  }
}

