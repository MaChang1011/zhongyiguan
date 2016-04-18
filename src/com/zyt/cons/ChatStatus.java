package com.zyt.cons;

/**
 * Author: @author HYS . <br>
 * Date: 2015-10-11 下午4:52:37 . <br>
 * Function: 聊天状态
 */
public enum ChatStatus {

  OFFLINE(0, "离线"),

  ONLINE(1, "在线"),

  BUSY(2, "忙碌");

  /**
   * @Fields : 状态
   */
  private int status;
  /**
   * @Fields : 描述
   */
  private String descr;

  private ChatStatus(int status, String descr) {
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
