package com.zyt.entity.doctor;

import com.zyt.base.BaseEntity;

/*
 * Ò½ÉúÏêÏ¸Î»ÖÃ
 * */
public class DoctorInfoEntity
  extends BaseEntity
{
  private int doctorId;
  private double longitude;
  private double latitude;
  private int status;
  
  public int getDoctorId()
  {
    return this.doctorId;
  }
  
  public double getLongitude()
  {
    return this.longitude;
  }
  
  public double getLatitude()
  {
    return this.latitude;
  }
  
  public int getStatus()
  {
    return this.status;
  }
  
  public void setDoctorId(int doctorId)
  {
    this.doctorId = doctorId;
  }
  
  public void setLongitude(double longitude)
  {
    this.longitude = longitude;
  }
  
  public void setLatitude(double latitude)
  {
    this.latitude = latitude;
  }
  
  public void setStatus(int status)
  {
    this.status = status;
  }
  
  public String toString()
  {
    return "DoctorInfoEntity(doctorId=" + getDoctorId() + ", longitude=" + getLongitude() + ", latitude=" + getLatitude() + ", status=" + getStatus() + ")";
  }
  
  public boolean equals(Object o)
  {
    if (o == this) {
      return true;
    }
    if (!(o instanceof DoctorInfoEntity)) {
      return false;
    }
    DoctorInfoEntity other = (DoctorInfoEntity)o;
    if (!other.canEqual(this)) {
      return false;
    }
    if (getDoctorId() != other.getDoctorId()) {
      return false;
    }
    if (Double.compare(getLongitude(), other.getLongitude()) != 0) {
      return false;
    }
    if (Double.compare(getLatitude(), other.getLatitude()) != 0) {
      return false;
    }
    return getStatus() == other.getStatus();
  }
  
  protected boolean canEqual(Object other)
  {
    return other instanceof DoctorInfoEntity;
  }
  
  public int hashCode()
  {
    int PRIME = 59;int result = 1;result = result * 59 + getDoctorId();long $longitude = Double.doubleToLongBits(getLongitude());result = result * 59 + (int)($longitude ^ $longitude >>> 32);long $latitude = Double.doubleToLongBits(getLatitude());result = result * 59 + (int)($latitude ^ $latitude >>> 32);result = result * 59 + getStatus();return result;
  }
}

