package com.zyt.entity.doctor;

import java.sql.Timestamp;

import com.zyt.base.BaseEntity;

/*
 * 对话实体类
 * */
public class AnswerEntity
  extends BaseEntity
{
  private String diagnoseId;
  private String msgFrom;
  private String msgTo;
  private String msg;
  private Timestamp createTime;
  
  public String getDiagnoseId()
  {
    return this.diagnoseId;
  }
  
  public String getMsgFrom()
  {
    return this.msgFrom;
  }
  
  public String getMsgTo()
  {
    return this.msgTo;
  }
  
  public String getMsg()
  {
    return this.msg;
  }
  
  public Timestamp getCreateTime()
  {
    return this.createTime;
  }
  
  public void setDiagnoseId(String diagnoseId)
  {
    this.diagnoseId = diagnoseId;
  }
  
  public void setMsgFrom(String msgFrom)
  {
    this.msgFrom = msgFrom;
  }
  
  public void setMsgTo(String msgTo)
  {
    this.msgTo = msgTo;
  }
  
  public void setMsg(String msg)
  {
    this.msg = msg;
  }
  
  public void setCreateTime(Timestamp createTime)
  {
    this.createTime = createTime;
  }
  
  public String toString()
  {
    return "AnswerEntity(diagnoseId=" + getDiagnoseId() + ", msgFrom=" + getMsgFrom() + ", msgTo=" + getMsgTo() + ", msg=" + getMsg() + ", createTime=" + getCreateTime() + ")";
  }
  
  public boolean equals(Object o)
  {
    if (o == this) {
      return true;
    }
    if (!(o instanceof AnswerEntity)) {
      return false;
    }
    AnswerEntity other = (AnswerEntity)o;
    if (!other.canEqual(this)) {
      return false;
    }
    Object this$diagnoseId = getDiagnoseId();Object other$diagnoseId = other.getDiagnoseId();
    if (this$diagnoseId == null ? other$diagnoseId != null : !this$diagnoseId.equals(other$diagnoseId)) {
      return false;
    }
    Object this$msgFrom = getMsgFrom();Object other$msgFrom = other.getMsgFrom();
    if (this$msgFrom == null ? other$msgFrom != null : !this$msgFrom.equals(other$msgFrom)) {
      return false;
    }
    Object this$msgTo = getMsgTo();Object other$msgTo = other.getMsgTo();
    if (this$msgTo == null ? other$msgTo != null : !this$msgTo.equals(other$msgTo)) {
      return false;
    }
    Object this$msg = getMsg();Object other$msg = other.getMsg();
    if (this$msg == null ? other$msg != null : !this$msg.equals(other$msg)) {
      return false;
    }
    Object this$createTime = getCreateTime();Object other$createTime = other.getCreateTime();return this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime);
  }
  
  protected boolean canEqual(Object other)
  {
    return other instanceof AnswerEntity;
  }
  
  public int hashCode()
  {
    int PRIME = 59;int result = 1;Object $diagnoseId = getDiagnoseId();result = result * 59 + ($diagnoseId == null ? 0 : $diagnoseId.hashCode());Object $msgFrom = getMsgFrom();result = result * 59 + ($msgFrom == null ? 0 : $msgFrom.hashCode());Object $msgTo = getMsgTo();result = result * 59 + ($msgTo == null ? 0 : $msgTo.hashCode());Object $msg = getMsg();result = result * 59 + ($msg == null ? 0 : $msg.hashCode());Object $createTime = getCreateTime();result = result * 59 + ($createTime == null ? 0 : $createTime.hashCode());return result;
  }
}

