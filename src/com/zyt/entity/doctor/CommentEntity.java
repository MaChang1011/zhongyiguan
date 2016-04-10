package com.zyt.entity.doctor;

import java.sql.Timestamp;
import com.zyt.base.BaseEntity;

/*
 * 评论实体类
 * */
public class CommentEntity
  extends BaseEntity
{
  private int patientId;
  private int doctorId;
  private String comment;
  private int commentLevel;
  private Timestamp createTime;
  
  public int getPatientId()
  {
    return this.patientId;
  }
  
  public int getDoctorId()
  {
    return this.doctorId;
  }
  
  public String getComment()
  {
    return this.comment;
  }
  
  public int getCommentLevel()
  {
    return this.commentLevel;
  }
  
  public Timestamp getCreateTime()
  {
    return this.createTime;
  }
  
  public void setPatientId(int patientId)
  {
    this.patientId = patientId;
  }
  
  public void setDoctorId(int doctorId)
  {
    this.doctorId = doctorId;
  }
  
  public void setComment(String comment)
  {
    this.comment = comment;
  }
  
  public void setCommentLevel(int commentLevel)
  {
    this.commentLevel = commentLevel;
  }
  
  public void setCreateTime(Timestamp createTime)
  {
    this.createTime = createTime;
  }
  
  public String toString()
  {
    return "CommentEntity(patientId=" + getPatientId() + ", doctorId=" + getDoctorId() + ", comment=" + getComment() + ", commentLevel=" + getCommentLevel() + ", createTime=" + getCreateTime() + ")";
  }
  
  public boolean equals(Object o)
  {
    if (o == this) {
      return true;
    }
    if (!(o instanceof CommentEntity)) {
      return false;
    }
    CommentEntity other = (CommentEntity)o;
    if (!other.canEqual(this)) {
      return false;
    }
    if (getPatientId() != other.getPatientId()) {
      return false;
    }
    if (getDoctorId() != other.getDoctorId()) {
      return false;
    }
    Object this$comment = getComment();Object other$comment = other.getComment();
    if (this$comment == null ? other$comment != null : !this$comment.equals(other$comment)) {
      return false;
    }
    if (getCommentLevel() != other.getCommentLevel()) {
      return false;
    }
    Object this$createTime = getCreateTime();Object other$createTime = other.getCreateTime();return this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime);
  }
  
  protected boolean canEqual(Object other)
  {
    return other instanceof CommentEntity;
  }
  
  public int hashCode()
  {
    int PRIME = 59;int result = 1;result = result * 59 + getPatientId();result = result * 59 + getDoctorId();Object $comment = getComment();result = result * 59 + ($comment == null ? 0 : $comment.hashCode());result = result * 59 + getCommentLevel();Object $createTime = getCreateTime();result = result * 59 + ($createTime == null ? 0 : $createTime.hashCode());return result;
  }
}

