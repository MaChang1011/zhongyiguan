package com.zyt.action.system;

import java.util.Map;
import com.zyt.base.AjaxResult;
import com.zyt.base.BaseAction;
import com.zyt.entity.system.ConfigEntity;
import com.zyt.service.system.IConfigManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping({"/profile"})
public class ProfileAction
  extends BaseAction
{
  @Autowired
  private IConfigManager configManager;
  private String flag;
  
  public ProfileAction()
  {
    this.flag = getClass().getSimpleName();
    setFlag(this.flag);
  }
  
  @RequestMapping({"/edit/{id}"})
  public ModelAndView edit(@PathVariable String id)
  {
    Map<String, Object> data = getMap();
    data.put("entity", this.configManager.findById(id));
    return new ModelAndView("/system/profile_form", data);
  }
  
  @RequestMapping({"/index"})
  public ModelAndView index()
  {
    Map<String, Object> data = getMap();
    data.put("data", this.configManager.findByFlags(new String[] { "company", 
      "service" }));
    return new ModelAndView("/system/profile", data);
  }
  
  @RequestMapping({"/save"})
  @ResponseBody
  public AjaxResult save(@ModelAttribute ConfigEntity entity, @RequestHeader("referer") String url)
  {
    this.configManager.saveOrUpdate(entity);
    AjaxResult ajaxResult = new AjaxResult();
    ajaxResult.setMsg(url);
    return ajaxResult;
  }
}
