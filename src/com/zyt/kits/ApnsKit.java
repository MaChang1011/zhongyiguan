package com.zyt.kits;

import com.dbay.apns4j.IApnsService;
import com.dbay.apns4j.impl.ApnsServiceImpl;
import com.dbay.apns4j.model.ApnsConfig;
import com.dbay.apns4j.model.Payload;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

public class ApnsKit
{
  private static ApnsKit apnsKit;
  private static IApnsService apnsService;
  
  public static ApnsKit getInstance()
  {
    if (apnsKit == null) {
      apnsKit = new ApnsKit();
    }
    return apnsKit;
  }
  
  private ApnsKit()
  {
    ApnsConfig config = new ApnsConfig();
    Properties properties = new Properties();
    try
    {
      InputStream inputStream = ApnsKit.class.getClassLoader()
        .getResourceAsStream("apns.properties");
      
      properties.load(inputStream);
    }
    catch (IOException e1)
    {
      e1.printStackTrace();
    }
    InputStream is = ApnsKit.class.getClassLoader().getResourceAsStream(
      properties.getProperty("HAOXINREN_APNS"));
    config.setKeyStore(is);
    config.setDevEnv("true".equals(properties.getProperty("IS_DEV")));
    config.setPassword(properties.getProperty("PASSWORD"));
    config.setPoolSize(Integer.parseInt(properties.getProperty("POOL_SIZE")));
    apnsService = ApnsServiceImpl.createInstance(config);
  }
  
  public void push(String deviceToken, String content, Map<String, Object> params)
  {
    Payload payload = new Payload();
    payload.setAlert(content);
    
    payload.setSound("msg.mp3");
    if (!CollectionKit.isNull(params)) {
      payload.setParams(params);
    }
    apnsService.sendNotification(deviceToken, payload);
  }
}
