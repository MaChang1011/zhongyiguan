package com.zyt.bo.doctor;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ReservationBo
{
  @JsonIgnore
  private int userid;
  private String startTime;
  private String endTime;
  private String dayOfWeek;
  private String location;
  
  public String toString()
  {
    return "ReservationBo(userid=" + getUserid() + ", startTime=" + getStartTime() + ", endTime=" + getEndTime() + ", dayOfWeek=" + getDayOfWeek() + ", location=" + getLocation() + ")";
  }
  
  public int hashCode()
  {
    int PRIME = 59;int result = 1;result = result * 59 + getUserid();Object $startTime = getStartTime();result = result * 59 + ($startTime == null ? 0 : $startTime.hashCode());Object $endTime = getEndTime();result = result * 59 + ($endTime == null ? 0 : $endTime.hashCode());Object $dayOfWeek = getDayOfWeek();result = result * 59 + ($dayOfWeek == null ? 0 : $dayOfWeek.hashCode());Object $location = getLocation();result = result * 59 + ($location == null ? 0 : $location.hashCode());return result;
  }
  
  protected boolean canEqual(Object other)
  {
    return other instanceof ReservationBo;
  }
  
  public boolean equals(Object o)
  {
    if (o == this) {
      return true;
    }
    if (!(o instanceof ReservationBo)) {
      return false;
    }
    ReservationBo other = (ReservationBo)o;
    if (!other.canEqual(this)) {
      return false;
    }
    if (getUserid() != other.getUserid()) {
      return false;
    }
    Object this$startTime = getStartTime();Object other$startTime = other.getStartTime();
    if (this$startTime == null ? other$startTime != null : !this$startTime.equals(other$startTime)) {
      return false;
    }
    Object this$endTime = getEndTime();Object other$endTime = other.getEndTime();
    if (this$endTime == null ? other$endTime != null : !this$endTime.equals(other$endTime)) {
      return false;
    }
    Object this$dayOfWeek = getDayOfWeek();Object other$dayOfWeek = other.getDayOfWeek();
    if (this$dayOfWeek == null ? other$dayOfWeek != null : !this$dayOfWeek.equals(other$dayOfWeek)) {
      return false;
    }
    Object this$location = getLocation();Object other$location = other.getLocation();return this$location == null ? other$location == null : this$location.equals(other$location);
  }
  
  public void setLocation(String location)
  {
    this.location = location;
  }
  
  public void setDayOfWeek(String dayOfWeek)
  {
    this.dayOfWeek = dayOfWeek;
  }
  
  public void setEndTime(String endTime)
  {
    this.endTime = endTime;
  }
  
  public void setStartTime(String startTime)
  {
    this.startTime = startTime;
  }
  
  public void setUserid(int userid)
  {
    this.userid = userid;
  }
  
  public String getLocation()
  {
    return this.location;
  }
  
  public String getDayOfWeek()
  {
    return this.dayOfWeek;
  }
  
  public String getEndTime()
  {
    return this.endTime;
  }
  
  public String getStartTime()
  {
    return this.startTime;
  }
  
  public int getUserid()
  {
    return this.userid;
  }
}
