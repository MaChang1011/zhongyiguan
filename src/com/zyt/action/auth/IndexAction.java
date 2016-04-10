package com.zyt.action.auth;

import com.zyt.base.BaseAction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping({"/"})
public class IndexAction
  extends BaseAction
{
  public IndexAction()
  {
    setFlag(getClass().getSimpleName());
  }
  
  @RequestMapping({"/index"})
  public ModelAndView index()
  {
    return new ModelAndView("/index", getMap());
  }
}

