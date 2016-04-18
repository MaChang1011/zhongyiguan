package com.zyt.cons;

/**
 * Author: @author HYS . <br>
 * Date: 2015-10-7 下午9:12:55 . <br>
 * Function: 评论等级
 */
public enum CommentLevelType {
  PERFECT(1, "很满意"),

  GOOD(2, "满意"),

  UNSATISFY(3, "不满意");

  private int status;
  private String msg;

  private CommentLevelType(int status, String msg) {
    this.status = status;
    this.msg = msg;
  }

  public String getMsg() {
    return msg;
  }

  public int getStatus() {
    return status;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public void setStatus(int status) {
    this.status = status;
  }
}
