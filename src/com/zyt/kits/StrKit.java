package com.zyt.kits;

public class StrKit
{
  public static boolean contains(String str, String s)
  {
    return (!isBlank(str)) && (str.contains(s));
  }
  
  public static boolean isBlank(String str)
  {
    return (str == null) || ("".equals(str.trim()));
  }
  
  public static boolean isBlank(String str, String... strs)
  {
    if (isBlank(str)) {
      return true;
    }
    boolean isBlank = false;
    String[] arrayOfString;
    int j = (arrayOfString = strs).length;
    for (int i = 0; i < j; i++)
    {
      String s = arrayOfString[i];
      isBlank = isBlank(s);
      if (isBlank) {
        return isBlank;
      }
    }
    return isBlank;
  }
  
  public static String replace(String str, String oldStr, String newStr)
  {
    return isBlank(str) ? "" : str.replace(oldStr, newStr);
  }
}
