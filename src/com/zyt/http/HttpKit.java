package com.zyt.http;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class HttpKit
  implements Http
{
  public String httpGet(String url, HttpCallback callback)
  {
    try
    {
      URL httpUrl = new URL(url);
      HttpURLConnection conn = (HttpURLConnection)httpUrl
        .openConnection();
      conn.setRequestMethod("GET");
      conn.setRequestProperty("charset", "utf-8");
      conn.setDoOutput(true);
      conn.setReadTimeout(5000);
      conn.setConnectTimeout(5000);
      if (conn.getResponseCode() == 200)
      {
        InputStreamReader in = new InputStreamReader(
          conn.getInputStream());
        BufferedReader br = new BufferedReader(in);
        StringBuilder response = new StringBuilder();
        
        String line = null;
        while ((line = br.readLine()) != null) {
          response.append(line);
        }
        String result = callback.invoke(response.toString());
        br.close();
        conn.disconnect();
        return result;
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return "";
  }
  
  public String httpPost(String url, Map<String, Object> param, HttpCallback callback)
  {
    try
    {
      URL httpUrl = new URL(url);
      HttpURLConnection conn = (HttpURLConnection)httpUrl
        .openConnection();
      conn.setRequestMethod("POST");
      conn.setRequestProperty("charset", "utf-8");
      conn.setDoOutput(true);
      conn.setReadTimeout(5000);
      conn.setConnectTimeout(5000);
      
      DataOutputStream out = new DataOutputStream(conn.getOutputStream());
      if (param != null)
      {
        StringBuilder builder = new StringBuilder();
        for (String key : param.keySet()) {
          builder.append("&" + key + "=" + param.get(key));
        }
        if (builder.length() > 1) {
          out.writeBytes(builder.substring(1));
        }
      }
      out.flush();
      out.close();
      if (conn.getResponseCode() == 200)
      {
        InputStreamReader in = new InputStreamReader(
          conn.getInputStream());
        BufferedReader br = new BufferedReader(in);
        StringBuilder response = new StringBuilder();
        
        String line = null;
        while ((line = br.readLine()) != null) {
          response.append(line);
        }
        String result = callback.invoke(response.toString());
        br.close();
        conn.disconnect();
        return result;
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return "";
  }
}
