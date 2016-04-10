package com.zyt.entity.doctor;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zyt.base.BaseEntity;

/*
 * 医生实体类
 * */
public class DoctorEntity
  extends BaseEntity
{
  @JsonIgnore
  protected int id;
  @JsonIgnore
  private int userid;
  @JsonIgnore
  private String name;
  @JsonIgnore
  private String nickname;
  private int sex;
  private String card;
  private String company;
  private String job;
  private String techTitle;
  private String profile;
  private String department;
  private int age;
  private int workYear;
  private String goodAt;
  
  public int getId()
  {
    return this.id;
  }
  
  public int getUserid()
  {
    return this.userid;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getNickname()
  {
    return this.nickname;
  }
  
  public int getSex()
  {
    return this.sex;
  }
  
  public String getCard()
  {
    return this.card;
  }
  
  public String getCompany()
  {
    return this.company;
  }
  
  public String getJob()
  {
    return this.job;
  }
  
  public String getTechTitle()
  {
    return this.techTitle;
  }
  
  public String getProfile()
  {
    return this.profile;
  }
  
  public String getDepartment()
  {
    return this.department;
  }
  
  public int getAge()
  {
    return this.age;
  }
  
  public int getWorkYear()
  {
    return this.workYear;
  }
  
  public String getGoodAt()
  {
    return this.goodAt;
  }
  
  public void setId(int id)
  {
    this.id = id;
  }
  
  public void setUserid(int userid)
  {
    this.userid = userid;
  }
  
  public void setName(String name)
  {
    this.name = name;
  }
  
  public void setNickname(String nickname)
  {
    this.nickname = nickname;
  }
  
  public void setSex(int sex)
  {
    this.sex = sex;
  }
  
  public void setCard(String card)
  {
    this.card = card;
  }
  
  public void setCompany(String company)
  {
    this.company = company;
  }
  
  public void setJob(String job)
  {
    this.job = job;
  }
  
  public void setTechTitle(String techTitle)
  {
    this.techTitle = techTitle;
  }
  
  public void setProfile(String profile)
  {
    this.profile = profile;
  }
  
  public void setDepartment(String department)
  {
    this.department = department;
  }
  
  public void setAge(int age)
  {
    this.age = age;
  }
  
  public void setWorkYear(int workYear)
  {
    this.workYear = workYear;
  }
  
  public void setGoodAt(String goodAt)
  {
    this.goodAt = goodAt;
  }
  
  public String toString()
  {
    return "DoctorEntity(id=" + getId() + ", userid=" + getUserid() + ", name=" + getName() + ", nickname=" + getNickname() + ", sex=" + getSex() + ", card=" + getCard() + ", company=" + getCompany() + ", job=" + getJob() + ", techTitle=" + getTechTitle() + ", profile=" + getProfile() + ", department=" + getDepartment() + ", age=" + getAge() + ", workYear=" + getWorkYear() + ", goodAt=" + getGoodAt() + ")";
  }
  
  public boolean equals(Object o)
  {
    if (o == this) {
      return true;
    }
    if (!(o instanceof DoctorEntity)) {
      return false;
    }
    DoctorEntity other = (DoctorEntity)o;
    if (!other.canEqual(this)) {
      return false;
    }
    if (getId() != other.getId()) {
      return false;
    }
    if (getUserid() != other.getUserid()) {
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
    if (getSex() != other.getSex()) {
      return false;
    }
    Object this$card = getCard();Object other$card = other.getCard();
    if (this$card == null ? other$card != null : !this$card.equals(other$card)) {
      return false;
    }
    Object this$company = getCompany();Object other$company = other.getCompany();
    if (this$company == null ? other$company != null : !this$company.equals(other$company)) {
      return false;
    }
    Object this$job = getJob();Object other$job = other.getJob();
    if (this$job == null ? other$job != null : !this$job.equals(other$job)) {
      return false;
    }
    Object this$techTitle = getTechTitle();Object other$techTitle = other.getTechTitle();
    if (this$techTitle == null ? other$techTitle != null : !this$techTitle.equals(other$techTitle)) {
      return false;
    }
    Object this$profile = getProfile();Object other$profile = other.getProfile();
    if (this$profile == null ? other$profile != null : !this$profile.equals(other$profile)) {
      return false;
    }
    Object this$department = getDepartment();Object other$department = other.getDepartment();
    if (this$department == null ? other$department != null : !this$department.equals(other$department)) {
      return false;
    }
    if (getAge() != other.getAge()) {
      return false;
    }
    if (getWorkYear() != other.getWorkYear()) {
      return false;
    }
    Object this$goodAt = getGoodAt();Object other$goodAt = other.getGoodAt();return this$goodAt == null ? other$goodAt == null : this$goodAt.equals(other$goodAt);
  }
  
  protected boolean canEqual(Object other)
  {
    return other instanceof DoctorEntity;
  }
  
  public int hashCode()
  {
    int PRIME = 59;int result = 1;result = result * 59 + getId();result = result * 59 + getUserid();Object $name = getName();result = result * 59 + ($name == null ? 0 : $name.hashCode());Object $nickname = getNickname();result = result * 59 + ($nickname == null ? 0 : $nickname.hashCode());result = result * 59 + getSex();Object $card = getCard();result = result * 59 + ($card == null ? 0 : $card.hashCode());Object $company = getCompany();result = result * 59 + ($company == null ? 0 : $company.hashCode());Object $job = getJob();result = result * 59 + ($job == null ? 0 : $job.hashCode());Object $techTitle = getTechTitle();result = result * 59 + ($techTitle == null ? 0 : $techTitle.hashCode());Object $profile = getProfile();result = result * 59 + ($profile == null ? 0 : $profile.hashCode());Object $department = getDepartment();result = result * 59 + ($department == null ? 0 : $department.hashCode());result = result * 59 + getAge();result = result * 59 + getWorkYear();Object $goodAt = getGoodAt();result = result * 59 + ($goodAt == null ? 0 : $goodAt.hashCode());return result;
  }
}

