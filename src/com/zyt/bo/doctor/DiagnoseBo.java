package com.zyt.bo.doctor;

import java.util.Date;

import com.zyt.base.BaseEntity;


public class DiagnoseBo
  extends BaseEntity
{
  private String nickname;
  private String question;
  private int answers;
  private String head;
  private Date createTime;
  
  public String getNickname()
  {
    return this.nickname;
  }
  
  public String getQuestion()
  {
    return this.question;
  }
  
  public int getAnswers()
  {
    return this.answers;
  }
  
  public String getHead()
  {
    return this.head;
  }
  
  public Date getCreateTime()
  {
    return this.createTime;
  }
  
  public void setNickname(String nickname)
  {
    this.nickname = nickname;
  }
  
  public void setQuestion(String question)
  {
    this.question = question;
  }
  
  public void setAnswers(int answers)
  {
    this.answers = answers;
  }
  
  public void setHead(String head)
  {
    this.head = head;
  }
  
  public void setCreateTime(Date createTime)
  {
    this.createTime = createTime;
  }
  
  public String toString()
  {
    return "DiagnoseBo(nickname=" + getNickname() + ", question=" + getQuestion() + ", answers=" + getAnswers() + ", head=" + getHead() + ", createTime=" + getCreateTime() + ")";
  }
  
  public boolean equals(Object o)
  {
    if (o == this) {
      return true;
    }
    if (!(o instanceof DiagnoseBo)) {
      return false;
    }
    DiagnoseBo other = (DiagnoseBo)o;
    if (!other.canEqual(this)) {
      return false;
    }
    Object this$nickname = getNickname();Object other$nickname = other.getNickname();
    if (this$nickname == null ? other$nickname != null : !this$nickname.equals(other$nickname)) {
      return false;
    }
    Object this$question = getQuestion();Object other$question = other.getQuestion();
    if (this$question == null ? other$question != null : !this$question.equals(other$question)) {
      return false;
    }
    if (getAnswers() != other.getAnswers()) {
      return false;
    }
    Object this$head = getHead();Object other$head = other.getHead();
    if (this$head == null ? other$head != null : !this$head.equals(other$head)) {
      return false;
    }
    Object this$createTime = getCreateTime();Object other$createTime = other.getCreateTime();return this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime);
  }
  
  protected boolean canEqual(Object other)
  {
    return other instanceof DiagnoseBo;
  }
  
  public int hashCode()
  {
    int PRIME = 59;int result = 1;Object $nickname = getNickname();result = result * 59 + ($nickname == null ? 0 : $nickname.hashCode());Object $question = getQuestion();result = result * 59 + ($question == null ? 0 : $question.hashCode());result = result * 59 + getAnswers();Object $head = getHead();result = result * 59 + ($head == null ? 0 : $head.hashCode());Object $createTime = getCreateTime();result = result * 59 + ($createTime == null ? 0 : $createTime.hashCode());return result;
  }
}
