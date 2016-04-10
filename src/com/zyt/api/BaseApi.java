package com.zyt.api;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;

import com.zyt.base.PageQuery;

public class BaseApi
{
  public static String UPLOAD_PATH = "uploads";
  public static String USER_UPLOAD_PATH_PREFIX = "u";
  protected int LIMIT = 10;
  @Autowired
  protected HttpServletRequest request;
  
  protected <T> PageQuery<T> getPageQuery(int start)
  {
    PageQuery<T> pageQuery = new PageQuery();
    pageQuery.setStart(start);
    pageQuery.setLimit(this.LIMIT);
    pageQuery.getCondition().put("start", 
      Integer.valueOf((start - 1) * pageQuery.getLimit()));
    pageQuery.getCondition().put("limit", Integer.valueOf(pageQuery.getLimit()));
    return pageQuery;
  }
}
