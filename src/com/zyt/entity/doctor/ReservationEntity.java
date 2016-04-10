package com.zyt.entity.doctor;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zyt.base.BaseEntity;
import java.sql.Timestamp;

/*
 * 预约实体类
 * */
public class ReservationEntity
  extends BaseEntity
{
  private int patientId;
  private int doctorId;
  private Timestamp rvtTime;
  @JsonIgnore
  private int status;
  @JsonIgnore
  private Timestamp createTime;
  
  public int getPatientId()
  {
    return this.patientId;
  }
  
  public int getDoctorId()
  {
    return this.doctorId;
  }
  
  public Timestamp getRvtTime()
  {
    return this.rvtTime;
  }
  
  public int getStatus()
  {
    return this.status;
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
  
  public void setRvtTime(Timestamp rvtTime)
  {
    this.rvtTime = rvtTime;
  }
  
  public void setStatus(int status)
  {
    this.status = status;
  }
  
  public void setCreateTime(Timestamp createTime)
  {
    this.createTime = createTime;
  }
  
  public String toString()
  {
    return "ReservationEntity(patientId=" + getPatientId() + ", doctorId=" + getDoctorId() + ", rvtTime=" + getRvtTime() + ", status=" + getStatus() + ", createTime=" + getCreateTime() + ")";
  }
  
  public boolean equals(Object o)
  {
    if (o == this) {
      return true;
    }
    if (!(o instanceof ReservationEntity)) {
      return false;
    }
    ReservationEntity other = (ReservationEntity)o;
    if (!other.canEqual(this)) {
      return false;
    }
    if (getPatientId() != other.getPatientId()) {
      return false;
    }
    if (getDoctorId() != other.getDoctorId()) {
      return false;
    }
    Object this$rvtTime = getRvtTime();Object other$rvtTime = other.getRvtTime();
    if (this$rvtTime == null ? other$rvtTime != null : !this$rvtTime.equals(other$rvtTime)) {
      return false;
    }
    if (getStatus() != other.getStatus()) {
      return false;
    }
    Object this$createTime = getCreateTime();Object other$createTime = other.getCreateTime();return this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime);
  }
  
  protected boolean canEqual(Object other)
  {
    return other instanceof ReservationEntity;
  }
  
  public int hashCode()
  {
    int PRIME = 59;int result = 1;result = result * 59 + getPatientId();result = result * 59 + getDoctorId();Object $rvtTime = getRvtTime();result = result * 59 + ($rvtTime == null ? 0 : $rvtTime.hashCode());result = result * 59 + getStatus();Object $createTime = getCreateTime();result = result * 59 + ($createTime == null ? 0 : $createTime.hashCode());return result;
  }
}

