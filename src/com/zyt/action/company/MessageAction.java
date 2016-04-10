package com.zyt.action.company;

import java.util.Map;
import com.zyt.base.AjaxResult;
import com.zyt.base.BaseAction;
import com.zyt.base.PageQuery;
import com.zyt.entity.company.MessageEntity;
import com.zyt.entity.system.UserEntity;
import com.zyt.service.company.IMessageManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping({"/message"})
public class MessageAction
  extends BaseAction
{
  @Autowired
  private IMessageManager messageManager;
  
  public MessageAction()
  {
    setFlag(getClass().getSimpleName());
  }
  
  @RequestMapping({"/add"})
  public ModelAndView add()
  {
    Map<String, Object> data = getMap();
    data.put("entity", new MessageEntity());
    return new ModelAndView("/company/message_form", data);
  }
  
  @RequestMapping({"/del/{id}"})
  @ResponseBody
  public AjaxResult delete(@PathVariable String id)
  {
    this.messageManager.delete(id);
    return new AjaxResult();
  }
  
  @RequestMapping({"/edit/{id}"})
  public ModelAndView edit(@PathVariable String id)
  {
    Map<String, Object> data = getMap();
    data.put("entity", this.messageManager.findById(id));
    return new ModelAndView("/company/message_form", data);
  }
  
  @RequestMapping({"/index"})
  public ModelAndView index()
  {
    Map<String, Object> data = getMap();
    PageQuery<MessageEntity> pageQuery = getPageQuery();
    data.put("messages", this.messageManager.findPage(pageQuery));
    return new ModelAndView("/company/message", data);
  }
  
  @ResponseBody
  @RequestMapping(value={"/push/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public void push(@PathVariable String id)
  {
    this.messageManager.push(id);
  }
  
  @RequestMapping({"/save"})
  @ResponseBody
  public AjaxResult save(@ModelAttribute MessageEntity entity, @RequestHeader("referer") String url)
  {
    entity.setPubuser(getUser().getId());
    this.messageManager.saveOrUpdate(entity);
    AjaxResult ajaxResult = new AjaxResult();
    ajaxResult.setMsg(url);
    return ajaxResult;
  }
}
