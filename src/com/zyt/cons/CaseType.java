package com.zyt.cons;

/**
 * Author: @author HYS . <br>
 * Date: 2015-9-20 下午8:56:13 . <br>
 * Function: 案例分类
 */
public enum CaseType {
  JDAL(10, "经典案例"),

  XXZJ(20, "心血之家");

  private int type;
  private String descr;

  private CaseType(int type, String descr) {
    this.type = type;
    this.descr = descr;
  }

  public String getDescr() {
    return descr;
  }

  public int getType() {
    return type;
  }

  public void setDescr(String descr) {
    this.descr = descr;
  }

  public void setType(int type) {
    this.type = type;
  }
}
