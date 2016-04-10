package com.zyt.action.system;

import java.util.Map;
import com.zyt.base.AjaxResult;
import com.zyt.base.BaseAction;
import com.zyt.base.PageQuery;
import com.zyt.entity.system.UserEntity;
import com.zyt.service.system.IUserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping({"/user"})
public class UserAction
  extends BaseAction
{
  @Autowired
  private IUserManager userManager;
  
  public UserAction()
  {
    setFlag(getClass().getSimpleName());
  }
  
  @RequestMapping({"/edit/{userid}"})
  public ModelAndView edit(@PathVariable String userid)
  {
    Map<String, Object> data = getMap();
    data.put("user", this.userManager.findById(userid));
    return new ModelAndView("/system/user_form", data);
  }
  
  @RequestMapping({"/index"})
  public ModelAndView index()
  {
    Map<String, Object> data = getMap();
    PageQuery<UserEntity> pageQuery = getPageQuery();
    data.put("users", this.userManager.findPage(pageQuery));
    return new ModelAndView("/system/user", data);
  }
  
  @RequestMapping({"/save"})
  @ResponseBody
  public AjaxResult save(@ModelAttribute UserEntity entity, @RequestHeader("referer") String url)
  {
    this.userManager.saveOrUpdate(entity);
    AjaxResult ajaxResult = new AjaxResult();
    ajaxResult.setMsg(url);
    return ajaxResult;
  }
}
