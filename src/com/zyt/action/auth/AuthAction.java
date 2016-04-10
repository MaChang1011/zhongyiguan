package com.zyt.action.auth;

import com.zyt.base.AjaxResult;
import com.zyt.base.BaseAction;
import com.zyt.entity.system.UserEntity;
import com.zyt.kits.MD5Kit;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping({"/"})
public class AuthAction
  extends BaseAction
{
  @RequestMapping({"/auth"})
  @ResponseBody
  public AjaxResult auth(@ModelAttribute UserEntity user)
  {
    AjaxResult result = new AjaxResult();
    Subject subject = SecurityUtils.getSubject();
    UsernamePasswordToken token = new UsernamePasswordToken(
      user.getNickname(), MD5Kit.encrypt(user.getPassword()));
    try
    {
      subject.login(token);
    }
    catch (Exception e)
    {
      result.setSuccess(false);
      result.setMsg(e.getMessage());
    }
    return result;
  }
  
  @RequestMapping({"/login"})
  public ModelAndView login()
  {
    return new ModelAndView("login");
  }
  
  @RequestMapping({"/logout"})
  public String ModelAndView()
  {
    Subject subject = SecurityUtils.getSubject();
    subject.logout();
    return "redirect:login";
  }
}
