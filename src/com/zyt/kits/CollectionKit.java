package com.zyt.kits;

import java.util.List;
import java.util.Map;

public class CollectionKit
{
  public static boolean containsKey(Map<?, ?> map, String key)
  {
    return (map != null) && (map.containsKey(key));
  }
  
  public static boolean isNull(List<?> list)
  {
    return (list == null) || (list.size() == 0);
  }
  
  public static boolean isNull(Map<?, ?> map)
  {
    return (map == null) || (map.keySet().size() == 0);
  }
}
