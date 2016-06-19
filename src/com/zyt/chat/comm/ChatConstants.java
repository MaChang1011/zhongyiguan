package com.zyt.chat.comm;

import java.util.Properties;

public abstract interface ChatConstants
{
  public static final String API_HTTP_SCHEMA = "https";
  public static final String API_SERVER_HOST = PropertiesUtils.getProperties()
    .getProperty("API_SERVER_HOST");
  public static final String APPKEY = PropertiesUtils.getProperties().getProperty(
    "APPKEY");
  public static final String APP_CLIENT_ID = PropertiesUtils.getProperties()
    .getProperty("APP_CLIENT_ID");
  public static final String APP_CLIENT_SECRET = PropertiesUtils.getProperties()
    .getProperty("APP_CLIENT_SECRET");
  public static final String NAME_PREFIX = "userhct";
}
