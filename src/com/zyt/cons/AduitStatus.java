package com.zyt.cons;

/**
 * Author: @author HYS . <br>
 * Date: 2015-9-20 下午8:03:02 . <br>
 * Function: 审核状态
 */
public enum AduitStatus {

  WAITING(0, "审核中"),

  PASSED(10, "通过"),

  FAILED(20, "未通过");

  /**
   * @Fields : 状态
   */
  private int status;
  /**
   * @Fields : 描述
   */
  private String descr;

  private AduitStatus(int status, String descr) {
    this.status = status;
    this.descr = descr;
  }

  public String getDescr() {
    return descr;
  }

  public int getStatus() {
    return status;
  }

  public void setDescr(String descr) {
    this.descr = descr;
  }

  public void setStatus(int status) {
    this.status = status;
  }
}
