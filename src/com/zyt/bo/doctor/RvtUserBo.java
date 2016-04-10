package com.zyt.bo.doctor;

import java.util.Date;

import com.zyt.base.BaseEntity;


public class RvtUserBo
  extends BaseEntity
{
  private String name;
  private String nickname;
  private String head;
  private int level;
  private Date rvtTime;
  private int status;
  private String company;
  private String job;
  
  public String getName()
  {
    return this.name;
  }
  
  public String getNickname()
  {
    return this.nickname;
  }
  
  public String getHead()
  {
    return this.head;
  }
  
  public int getLevel()
  {
    return this.level;
  }
  
  public Date getRvtTime()
  {
    return this.rvtTime;
  }
  
  public int getStatus()
  {
    return this.status;
  }
  
  public String getCompany()
  {
    return this.company;
  }
  
  public String getJob()
  {
    return this.job;
  }
  
  public void setName(String name)
  {
    this.name = name;
  }
  
  public void setNickname(String nickname)
  {
    this.nickname = nickname;
  }
  
  public void setHead(String head)
  {
    this.head = head;
  }
  
  public void setLevel(int level)
  {
    this.level = level;
  }
  
  public void setRvtTime(Date rvtTime)
  {
    this.rvtTime = rvtTime;
  }
  
  public void setStatus(int status)
  {
    this.status = status;
  }
  
  public void setCompany(String company)
  {
    this.company = company;
  }
  
  public void setJob(String job)
  {
    this.job = job;
  }
  
  public String toString()
  {
    return "RvtUserBo(name=" + getName() + ", nickname=" + getNickname() + ", head=" + getHead() + ", level=" + getLevel() + ", rvtTime=" + getRvtTime() + ", status=" + getStatus() + ", company=" + getCompany() + ", job=" + getJob() + ")";
  }
  
  public boolean equals(Object o)
  {
    if (o == this) {
      return true;
    }
    if (!(o instanceof RvtUserBo)) {
      return false;
    }
    RvtUserBo other = (RvtUserBo)o;
    if (!other.canEqual(this)) {
      return false;
    }
    Object this$name = getName();Object other$name = other.getName();
    if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
      return false;
    }
    Object this$nickname = getNickname();Object other$nickname = other.getNickname();
    if (this$nickname == null ? other$nickname != null : !this$nickname.equals(other$nickname)) {
      return false;
    }
    Object this$head = getHead();Object other$head = other.getHead();
    if (this$head == null ? other$head != null : !this$head.equals(other$head)) {
      return false;
    }
    if (getLevel() != other.getLevel()) {
      return false;
    }
    Object this$rvtTime = getRvtTime();Object other$rvtTime = other.getRvtTime();
    if (this$rvtTime == null ? other$rvtTime != null : !this$rvtTime.equals(other$rvtTime)) {
      return false;
    }
    if (getStatus() != other.getStatus()) {
      return false;
    }
    Object this$company = getCompany();Object other$company = other.getCompany();
    if (this$company == null ? other$company != null : !this$company.equals(other$company)) {
      return false;
    }
    Object this$job = getJob();Object other$job = other.getJob();return this$job == null ? other$job == null : this$job.equals(other$job);
  }
  
  protected boolean canEqual(Object other)
  {
    return other instanceof RvtUserBo;
  }
  
  public int hashCode()
  {
    int PRIME = 59;int result = 1;Object $name = getName();result = result * 59 + ($name == null ? 0 : $name.hashCode());Object $nickname = getNickname();result = result * 59 + ($nickname == null ? 0 : $nickname.hashCode());Object $head = getHead();result = result * 59 + ($head == null ? 0 : $head.hashCode());result = result * 59 + getLevel();Object $rvtTime = getRvtTime();result = result * 59 + ($rvtTime == null ? 0 : $rvtTime.hashCode());result = result * 59 + getStatus();Object $company = getCompany();result = result * 59 + ($company == null ? 0 : $company.hashCode());Object $job = getJob();result = result * 59 + ($job == null ? 0 : $job.hashCode());return result;
  }
}
