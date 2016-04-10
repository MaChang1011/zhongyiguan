package com.zyt.api.company;

import com.google.common.collect.Maps;
import java.util.Map;
import com.zyt.entity.system.ConfigEntity;
import com.zyt.service.system.IConfigManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({"/api/profile"})
public class ProfileApi
{
  @Autowired
  private IConfigManager configManager;
  
  @ResponseBody
  @RequestMapping({"/get/{type}"})
  public Map<String, String> get(@PathVariable int type)
  {
    ConfigEntity config = this.configManager.findOneByFlags(getFlag(type));
    Map<String, String> data = Maps.newHashMap();
    if (config != null)
    {
      data.put("title", config.getTitle());
      data.put("content", config.getContent());
    }
    return data;
  }
  
  private String[] getFlag(int type)
  {
    if (type == 20) {
      return new String[] { "service" };
    }
    return new String[] { "company" };
  }
}
