package com.zyt.api.company;

import com.google.common.collect.Maps;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import com.zyt.api.BaseApi;
import com.zyt.base.PageQuery;
import com.zyt.entity.company.MessageEntity;
import com.zyt.service.company.IMessageManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping({"/api/message"})
public class MessageApi
  extends BaseApi
{
  @Autowired
  private IMessageManager messageManager;
  
  @RequestMapping(value={"/detail/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public ModelAndView detail(@PathVariable String id)
  {
    Map<String, Object> data = Maps.newHashMap();
    data.put("entity", this.messageManager.findById(id));
    return new ModelAndView("/api/message", data);
  }
  
  @ResponseBody
  @RequestMapping(value={"/get/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public MessageEntity get(@PathVariable String id)
  {
    Map<String, Object> params = Maps.newHashMap();
    params.put("id", id);
    params.put("userId", this.request.getParameter("userId"));
    return this.messageManager.findById(params);
  }
  
  @ResponseBody
  @RequestMapping(value={"/list/{start}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public List<MessageEntity> list(@PathVariable int start)
  {
    PageQuery<MessageEntity> page = getPageQuery(start);
    page.getCondition().put("userId", this.request.getParameter("userId"));
    PageQuery<MessageEntity> result = this.messageManager.findPage(page);
    return result.getList();
  }
  
  @ResponseBody
  @RequestMapping(value={"/list/{userId}/{start}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public List<MessageEntity> list(@PathVariable int userId, @PathVariable int start)
  {
    PageQuery<MessageEntity> page = getPageQuery(start);
    page.getCondition().put("userId", Integer.valueOf(userId));
    PageQuery<MessageEntity> result = this.messageManager.findPage(page);
    return result.getList();
  }
}
