package com.zyt.entity.doctor;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zyt.base.BaseEntity;


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
  /**
   * @Fields : 是否审核
   */
  private int d_check;

  public int getD_check(){return this.d_check;}

  public void setD_check(int d_check){ this.d_check=d_check;}
  
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

}

