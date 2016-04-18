package com.zyt.cons;

public enum ReservationType {
  DEFAULT(0, "默认"),

  AGREE(1, "同意"),

  REFUSE(2, "拒绝");

  private int status;
  private String msg;

  private ReservationType(int status, String msg) {
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
