package com.zyt.api.user;


import com.zyt.api.BaseApi;
import com.zyt.base.ApiResult;
import com.zyt.entity.system.DeviceTokenEntity;
import com.zyt.service.system.IDeviceTokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({"/api/device"})
public class DeviceApi
  extends BaseApi
{
  @Autowired
  private IDeviceTokenManager deviceTokenManager;
  
  @ResponseBody
  @RequestMapping(value={"/get"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public DeviceTokenEntity get(@RequestParam String deviceToken)
  {
    return this.deviceTokenManager.findByDeviceToken(deviceToken);
  }
  
  @ResponseBody
  @RequestMapping(value={"/post"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public ApiResult post(@ModelAttribute DeviceTokenEntity entity)
  {
    return this.deviceTokenManager.save(entity);
  }
}
