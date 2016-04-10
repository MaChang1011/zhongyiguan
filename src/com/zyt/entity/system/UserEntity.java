package com.zyt.entity.system;

import java.sql.Timestamp;

import com.zyt.base.BaseEntity;


/**
 * @author ljw
 * @Date 2016��3��12��
 * @Project zhongyiguan
 * @Version 1.0
 */
public class UserEntity
  extends BaseEntity
{
  private String nickname;
  private String head;
  private String name;
  private String mobile;
  private String password;
  private int type;
  private Timestamp regtime;
  private int level;
  private int chatNoti;
  private int msgNoti;
  private Integer age;
  private String sex;
  


public String getNickname()
  {
    return this.nickname;
  }
  
  public String getHead()
  {
    return this.head;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getMobile()
  {
    return this.mobile;
  }
  
  public String getPassword()
  {
    return this.password;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public Timestamp getRegtime()
  {
    return this.regtime;
  }
  
  public int getLevel()
  {
    return this.level;
  }
  
  public int getChatNoti()
  {
    return this.chatNoti;
  }
  
  public int getMsgNoti()
  {
    return this.msgNoti;
  }
  
  public void setNickname(String nickname)
  {
    this.nickname = nickname;
  }
  
  public void setHead(String head)
  {
    this.head = head;
  }
  
  public void setName(String name)
  {
    this.name = name;
  }
  
  public void setMobile(String mobile)
  {
    this.mobile = mobile;
  }
  
  public void setPassword(String password)
  {
    this.password = password;
  }
  
  public void setType(int type)
  {
    this.type = type;
  }
  
  public void setRegtime(Timestamp regtime)
  {
    this.regtime = regtime;
  }
  
  public void setLevel(int level)
  {
    this.level = level;
  }
  
  public void setChatNoti(int chatNoti)
  {
    this.chatNoti = chatNoti;
  }
  
  public void setMsgNoti(int msgNoti)
  {
    this.msgNoti = msgNoti;
  }
  
  public Integer getAge() {
	return age;
}

public void setAge(Integer age) {
	this.age = age;
}

public String getSex() {
	return sex;
}

public void setSex(String sex) {
	this.sex = sex;
}
  
  public String toString()
  {
    return "UserEntity(nickname=" + getNickname() + ", head=" + getHead() + ", name=" + getName() + ", mobile=" + getMobile() + ", password=" + getPassword() + ", type=" + getType() + ", regtime=" + getRegtime() + ", level=" + getLevel() + ", chatNoti=" + getChatNoti() + ", msgNoti=" + getMsgNoti() + ")";
  }
  
  public boolean equals(Object o)
  {
    if (o == this) {
      return true;
    }
    if (!(o instanceof UserEntity)) {
      return false;
    }
    UserEntity other = (UserEntity)o;
    if (!other.canEqual(this)) {
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
    Object this$name = getName();Object other$name = other.getName();
    if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
      return false;
    }
    Object this$mobile = getMobile();Object other$mobile = other.getMobile();
    if (this$mobile == null ? other$mobile != null : !this$mobile.equals(other$mobile)) {
      return false;
    }
    Object this$password = getPassword();Object other$password = other.getPassword();
    if (this$password == null ? other$password != null : !this$password.equals(other$password)) {
      return false;
    }
    if (getType() != other.getType()) {
      return false;
    }
    Object this$regtime = getRegtime();Object other$regtime = other.getRegtime();
    if (this$regtime == null ? other$regtime != null : !this$regtime.equals(other$regtime)) {
      return false;
    }
    if (getLevel() != other.getLevel()) {
      return false;
    }
    if (getChatNoti() != other.getChatNoti()) {
      return false;
    }
    return getMsgNoti() == other.getMsgNoti();
  }
  
  protected boolean canEqual(Object other)
  {
    return other instanceof UserEntity;
  }
  
  public int hashCode()
  {
    int PRIME = 59;int result = 1;Object $nickname = getNickname();result = result * 59 + ($nickname == null ? 0 : $nickname.hashCode());Object $head = getHead();result = result * 59 + ($head == null ? 0 : $head.hashCode());Object $name = getName();result = result * 59 + ($name == null ? 0 : $name.hashCode());Object $mobile = getMobile();result = result * 59 + ($mobile == null ? 0 : $mobile.hashCode());Object $password = getPassword();result = result * 59 + ($password == null ? 0 : $password.hashCode());result = result * 59 + getType();Object $regtime = getRegtime();result = result * 59 + ($regtime == null ? 0 : $regtime.hashCode());result = result * 59 + getLevel();result = result * 59 + getChatNoti();result = result * 59 + getMsgNoti();return result;
  }
}

