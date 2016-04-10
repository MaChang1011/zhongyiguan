package com.zyt.bo.doctor;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class DoctorNearBo
  extends DoctorBo
{
  @JsonIgnore
  private float distanceFloat;
  private String measure;
  private String distance;
  
  public float getDistanceFloat()
  {
    return this.distanceFloat;
  }
  
  public String getMeasure()
  {
    return this.measure;
  }
  
  public String getDistance()
  {
    return this.distance;
  }
  
  public void setDistanceFloat(float distanceFloat)
  {
    this.distanceFloat = distanceFloat;
  }
  
  public void setMeasure(String measure)
  {
    this.measure = measure;
  }
  
  public void setDistance(String distance)
  {
    this.distance = distance;
  }
  
  public String toString()
  {
    return "DoctorNearBo(distanceFloat=" + getDistanceFloat() + ", measure=" + getMeasure() + ", distance=" + getDistance() + ")";
  }
  
  public boolean equals(Object o)
  {
    if (o == this) {
      return true;
    }
    if (!(o instanceof DoctorNearBo)) {
      return false;
    }
    DoctorNearBo other = (DoctorNearBo)o;
    if (!other.canEqual(this)) {
      return false;
    }
    if (Float.compare(getDistanceFloat(), other.getDistanceFloat()) != 0) {
      return false;
    }
    Object this$measure = getMeasure();Object other$measure = other.getMeasure();
    if (this$measure == null ? other$measure != null : !this$measure.equals(other$measure)) {
      return false;
    }
    Object this$distance = getDistance();Object other$distance = other.getDistance();return this$distance == null ? other$distance == null : this$distance.equals(other$distance);
  }
  
  protected boolean canEqual(Object other)
  {
    return other instanceof DoctorNearBo;
  }
  
  public int hashCode()
  {
    int PRIME = 59;int result = 1;result = result * 59 + Float.floatToIntBits(getDistanceFloat());Object $measure = getMeasure();result = result * 59 + ($measure == null ? 0 : $measure.hashCode());Object $distance = getDistance();result = result * 59 + ($distance == null ? 0 : $distance.hashCode());return result;
  }
}
