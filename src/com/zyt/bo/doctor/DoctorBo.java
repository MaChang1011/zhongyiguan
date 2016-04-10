package com.zyt.bo.doctor;

public class DoctorBo
  extends ReservationBo
{
  private int id;
  private String name;
  private String head;
  private int sex;
  private String card;
  private String company;
  private String department;
  private String job;
  private String techTitle;
  private String profile;
  private int level;
  private int isCollection;
  private int age;
  private int workYear;
  private String goodAt;
  private int follows;
  
  public int getId()
  {
    return this.id;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getHead()
  {
    return this.head;
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
  
  public String getDepartment()
  {
    return this.department;
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
  
  public int getLevel()
  {
    return this.level;
  }
  
  public int getIsCollection()
  {
    return this.isCollection;
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
  
  public int getFollows()
  {
    return this.follows;
  }
  
  public void setId(int id)
  {
    this.id = id;
  }
  
  public void setName(String name)
  {
    this.name = name;
  }
  
  public void setHead(String head)
  {
    this.head = head;
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
  
  public void setDepartment(String department)
  {
    this.department = department;
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
  
  public void setLevel(int level)
  {
    this.level = level;
  }
  
  public void setIsCollection(int isCollection)
  {
    this.isCollection = isCollection;
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
  
  public void setFollows(int follows)
  {
    this.follows = follows;
  }
  
  public String toString()
  {
    return "DoctorBo(id=" + getId() + ", name=" + getName() + ", head=" + getHead() + ", sex=" + getSex() + ", card=" + getCard() + ", company=" + getCompany() + ", department=" + getDepartment() + ", job=" + getJob() + ", techTitle=" + getTechTitle() + ", profile=" + getProfile() + ", level=" + getLevel() + ", isCollection=" + getIsCollection() + ", age=" + getAge() + ", workYear=" + getWorkYear() + ", goodAt=" + getGoodAt() + ", follows=" + getFollows() + ")";
  }
  
  public boolean equals(Object o)
  {
    if (o == this) {
      return true;
    }
    if (!(o instanceof DoctorBo)) {
      return false;
    }
    DoctorBo other = (DoctorBo)o;
    if (!other.canEqual(this)) {
      return false;
    }
    if (getId() != other.getId()) {
      return false;
    }
    Object this$name = getName();Object other$name = other.getName();
    if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
      return false;
    }
    Object this$head = getHead();Object other$head = other.getHead();
    if (this$head == null ? other$head != null : !this$head.equals(other$head)) {
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
    Object this$department = getDepartment();Object other$department = other.getDepartment();
    if (this$department == null ? other$department != null : !this$department.equals(other$department)) {
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
    if (getLevel() != other.getLevel()) {
      return false;
    }
    if (getIsCollection() != other.getIsCollection()) {
      return false;
    }
    if (getAge() != other.getAge()) {
      return false;
    }
    if (getWorkYear() != other.getWorkYear()) {
      return false;
    }
    Object this$goodAt = getGoodAt();Object other$goodAt = other.getGoodAt();
    if (this$goodAt == null ? other$goodAt != null : !this$goodAt.equals(other$goodAt)) {
      return false;
    }
    return getFollows() == other.getFollows();
  }
  
  protected boolean canEqual(Object other)
  {
    return other instanceof DoctorBo;
  }
  
  public int hashCode()
  {
    int PRIME = 59;int result = 1;result = result * 59 + getId();Object $name = getName();result = result * 59 + ($name == null ? 0 : $name.hashCode());Object $head = getHead();result = result * 59 + ($head == null ? 0 : $head.hashCode());result = result * 59 + getSex();Object $card = getCard();result = result * 59 + ($card == null ? 0 : $card.hashCode());Object $company = getCompany();result = result * 59 + ($company == null ? 0 : $company.hashCode());Object $department = getDepartment();result = result * 59 + ($department == null ? 0 : $department.hashCode());Object $job = getJob();result = result * 59 + ($job == null ? 0 : $job.hashCode());Object $techTitle = getTechTitle();result = result * 59 + ($techTitle == null ? 0 : $techTitle.hashCode());Object $profile = getProfile();result = result * 59 + ($profile == null ? 0 : $profile.hashCode());result = result * 59 + getLevel();result = result * 59 + getIsCollection();result = result * 59 + getAge();result = result * 59 + getWorkYear();Object $goodAt = getGoodAt();result = result * 59 + ($goodAt == null ? 0 : $goodAt.hashCode());result = result * 59 + getFollows();return result;
  }
}
