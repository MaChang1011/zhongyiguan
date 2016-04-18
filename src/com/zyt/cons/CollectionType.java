package com.zyt.cons;

/**
 * Author: @author HYS . <br>
 * Date: 2015-10-11 下午8:13:27 . <br>
 * Function: 用户收藏类型
 */
public enum CollectionType {

  PRODUCT(1, "产品"),

  MESSAGE(2, "资讯"),

  DOCTOR(3, "医生");

  /**
   * @Fields : 类型
   */
  private int type;
  /**
   * @Fields : 描述
   */
  private String descr;

  private CollectionType(int type, String descr) {
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
