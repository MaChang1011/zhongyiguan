package com.zyt.entity.doctor;

import java.sql.Timestamp;

import com.zyt.base.BaseEntity;

/*
 * ’Ô∂œ µÃÂ¿‡
 * */
public class DiagnoseEntity
  extends BaseEntity
{
  private int patientId;
  private String question;
  private Timestamp createTime;
  
  public int getPatientId()
  {
    return this.patientId;
  }
  
  public String getQuestion()
  {
    return this.question;
  }
  
  public Timestamp getCreateTime()
  {
    return this.createTime;
  }
  
  public void setPatientId(int patientId)
  {
    this.patientId = patientId;
  }
  
  public void setQuestion(String question)
  {
    this.question = question;
  }
  
  public void setCreateTime(Timestamp createTime)
  {
    this.createTime = createTime;
  }
  
  public String toString()
  {
    return "DiagnoseEntity(patientId=" + getPatientId() + ", question=" + getQuestion() + ", createTime=" + getCreateTime() + ")";
  }
  
  public boolean equals(Object o)
  {
    if (o == this) {
      return true;
    }
    if (!(o instanceof DiagnoseEntity)) {
      return false;
    }
    DiagnoseEntity other = (DiagnoseEntity)o;
    if (!other.canEqual(this)) {
      return false;
    }
    if (getPatientId() != other.getPatientId()) {
      return false;
    }
    Object this$question = getQuestion();Object other$question = other.getQuestion();
    if (this$question == null ? other$question != null : !this$question.equals(other$question)) {
      return false;
    }
    Object this$createTime = getCreateTime();Object other$createTime = other.getCreateTime();return this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime);
  }
  
  protected boolean canEqual(Object other)
  {
    return other instanceof DiagnoseEntity;
  }
  
  public int hashCode()
  {
    int PRIME = 59;int result = 1;result = result * 59 + getPatientId();Object $question = getQuestion();result = result * 59 + ($question == null ? 0 : $question.hashCode());Object $createTime = getCreateTime();result = result * 59 + ($createTime == null ? 0 : $createTime.hashCode());return result;
  }
}

