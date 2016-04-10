package com.zyt.http;

import java.util.Map;

public abstract interface Http
{
  public abstract String httpGet(String paramString, HttpCallback paramHttpCallback);
  
  public abstract String httpPost(String paramString, Map<String, Object> paramMap, HttpCallback paramHttpCallback);
}
