package com.zyt.cons;

/**
 * Author: @author HYS . <br>
 * Date: 2015-9-20 下午5:45:59 . <br>
 * Function: 用户类型
 */
public enum UserType {

  ADMIN(2, "管理员"),

  DOCTOR(1, "医生"),

  PATIENT(0, "患者");

  /**
   * @Fields : 类型
   */
  private int type;
  /**
   * @Fields : 描述
   */
  private String descr;

  private UserType(int type, String descr) {
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
