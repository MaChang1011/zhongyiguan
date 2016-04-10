package com.zyt.base;

import com.google.common.collect.Maps;
import java.util.List;
import java.util.Map;

/*
 * ·ÖÒ³
 * */
public class PageQuery<T>
{
  private int total;
  private int start;
  private int size;
  
  public String toString()
  {
    return "PageQuery(total=" + getTotal() + ", start=" + getStart() + ", size=" + getSize() + ", limit=" + getLimit() + ", list=" + getList() + ", condition=" + getCondition() + ")";
  }
  
  public int hashCode()
  {
    int PRIME = 59;int result = 1;result = result * 59 + getTotal();result = result * 59 + getStart();result = result * 59 + getSize();result = result * 59 + getLimit();Object $list = getList();result = result * 59 + ($list == null ? 0 : $list.hashCode());Object $condition = getCondition();result = result * 59 + ($condition == null ? 0 : $condition.hashCode());return result;
  }
  
  protected boolean canEqual(Object other)
  {
    return other instanceof PageQuery;
  }
  
  public boolean equals(Object o)
  {
    if (o == this) {
      return true;
    }
    if (!(o instanceof PageQuery)) {
      return false;
    }
    PageQuery<?> other = (PageQuery)o;
    if (!other.canEqual(this)) {
      return false;
    }
    if (getTotal() != other.getTotal()) {
      return false;
    }
    if (getStart() != other.getStart()) {
      return false;
    }
    if (getSize() != other.getSize()) {
      return false;
    }
    if (getLimit() != other.getLimit()) {
      return false;
    }
    Object this$list = getList();Object other$list = other.getList();
    if (this$list == null ? other$list != null : !this$list.equals(other$list)) {
      return false;
    }
    Object this$condition = getCondition();Object other$condition = other.getCondition();return this$condition == null ? other$condition == null : this$condition.equals(other$condition);
  }
  
  public void setCondition(Map<String, Object> condition)
  {
    this.condition = condition;
  }
  
  public void setList(List<T> list)
  {
    this.list = list;
  }
  
  public void setLimit(int limit)
  {
    this.limit = limit;
  }
  
  public void setSize(int size)
  {
    this.size = size;
  }
  
  public void setStart(int start)
  {
    this.start = start;
  }
  
  public void setTotal(int total)
  {
    this.total = total;
  }
  
  public Map<String, Object> getCondition()
  {
    return this.condition;
  }
  
  public List<T> getList()
  {
    return this.list;
  }
  
  public int getLimit()
  {
    return this.limit;
  }
  
  public int getSize()
  {
    return this.size;
  }
  
  public int getStart()
  {
    return this.start;
  }
  
  public int getTotal()
  {
    return this.total;
  }
  
  private int limit = 7;
  private List<T> list;
  private Map<String, Object> condition = Maps.newHashMap();
}

