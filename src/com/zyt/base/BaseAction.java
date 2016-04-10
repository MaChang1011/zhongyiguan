package com.zyt.base;


import com.google.common.collect.Maps;
import com.zyt.entity.system.UserEntity;
import com.zyt.kits.StrKit;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.zyt.service.system.IModuleManager;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseAction
{
  public static final String USER = "user";
  @Autowired
  protected HttpServletRequest request;
  @Autowired
  protected HttpServletResponse response;
  @Autowired
  private IModuleManager moduleManager;
  private String flag;
  
  protected Map<String, Object> getMap()
  {
    Map<String, Object> map = Maps.newHashMap();
    map.put("modules", this.moduleManager.findAll());
    map.put("current", this.moduleManager.findCurrent(this.flag));
    return map;
  }
  
  protected <T> PageQuery<T> getPageQuery()
  {
    PageQuery<T> pageQuery = new PageQuery();
    String start = this.request.getParameter("start");
    if (StrKit.isBlank(start)) {
      start = "1";
    }
    pageQuery.setStart(Integer.parseInt(start));
    pageQuery.getCondition().put("start", 
      Integer.valueOf((pageQuery.getStart() - 1) * pageQuery.getLimit()));
    pageQuery.getCondition().put("limit", Integer.valueOf(pageQuery.getLimit()));
    return pageQuery;
  }
  
  protected String getSuccessUrl(String url)
  {
    if (!StrKit.contains(url, "?s=true")) {
      url = url + "?s=true";
    }
    return url;
  }
  
  protected UserEntity getUser()
  {
    Subject subject = SecurityUtils.getSubject();
    return (UserEntity)subject.getSession().getAttribute("user");
  }
  
  protected void setFlag(String flag)
  {
    this.flag = flag;
  }
}
