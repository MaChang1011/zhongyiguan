package com.zyt.kits;

public enum ModuleEnum
{
  SYSTEM_USER(
  
    "user");
  
  private String flag;
  
  private ModuleEnum(String flag)
  {
    this.flag = flag;
  }
  
  public String getFlag()
  {
    return this.flag;
  }
}
