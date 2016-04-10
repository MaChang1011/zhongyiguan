package com.zyt.kits;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlKit
{
  public static final int LENGTH = 50;
  public static String HTML_REG = "(<[^>]+>)|(&nbsp;)|(\t)";
  public static String IMAGE_REG = "<img.*src=\"/health/(.+)\"\\s+(.+)/>";
  
  public static String filter(String str)
  {
    return StrKit.isBlank(str) ? "" : str.replaceAll(HTML_REG, "");
  }
  
  public static String filterImage(String str)
  {
    Pattern iamgePatten = Pattern.compile(IMAGE_REG, 
      2);
    Matcher matcher = iamgePatten.matcher(str);
    if (matcher.find()) {
      return matcher.group(1);
    }
    return "";
  }
  
  public static String filterSubstring(String str, int length)
  {
    if (StrKit.isBlank(str)) {
      return "";
    }
    String temp = filter(str);
    if ((!StrKit.isBlank(temp)) && (temp.length() > length)) {
      return temp.substring(0, length - 3) + "...";
    }
    return temp;
  }
}
