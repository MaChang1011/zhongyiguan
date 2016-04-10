package com.zyt.api.user;

import com.zyt.api.BaseApi;
import com.zyt.base.ApiResult;
import com.zyt.entity.system.AccountEntity;
import com.zyt.service.system.IAccountManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({"/api/user"})
public class AccountApi
  extends BaseApi
{
  @Autowired
  private IAccountManager accountManager;
  
  @ResponseBody
  @RequestMapping(value={"/account_check"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public ApiResult accountCheck(@RequestParam String uid)
  {
    return this.accountManager.checkAccount(uid);
  }
  
  @ResponseBody
  @RequestMapping(value={"/account_conn"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public ApiResult accountConn(@ModelAttribute AccountEntity entity)
  {
    return this.accountManager.saveAccount(entity);
  }
}
