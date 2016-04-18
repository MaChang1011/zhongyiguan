package com.zyt.entity.doctor;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zyt.base.BaseEntity;
import com.google.gson.annotations.Expose;

/**
 * @author ljw
 * @Date 2016��3��12��
 * @Project zhongyiguan
 * @Version 1.0
 */
public class PatientEntity
  extends BaseEntity
{
  protected int id;

	private int userid;
  
  private String name;
  
  private String address;

  private Timestamp pubtime;
  
  private String images;
  //ҩƷ�ַ���
  private String drug;
  
  private float money;
  //������
  private String orderid;
  //���״̬
  private int status;
  //֧��״̬
  private int status_zf;

  private int age;
  
  private String sex;
  
  private int is_hy;
  
  private int is_wy;
  
  private int is_fp;
  
  private int is_jz;
  
  private int is_gf;
  
  private int is_ps;
  
  //����������ϴ�
  private int type;
  
  //�绰����
  private String mobile;

  @JsonIgnore
  private int caseImageCount;
  
  

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public int getUserid() {
	return userid;
}

public void setUserid(int userid) {
	this.userid = userid;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public Timestamp getPubtime() {
	return pubtime;
}

public void setPubtime(Timestamp pubtime) {
	this.pubtime = pubtime;
}

public String getImages() {
	return images;
}

public void setImages(String images) {
	this.images = images;
}

public String getDrug() {
	return drug;
}

public void setDrug(String drug) {
	this.drug = drug;
}

public float getMoney() {
	return money;
}

public void setMoney(float money) {
	this.money = money;
}

public String getOrderid() {
	return orderid;
}

public void setOrderid(String orderid) {
	this.orderid = orderid;
}

public int getStatus() {
	return status;
}

public void setStatus(int status) {
	this.status = status;
}

public int getStatus_zf() {
	return status_zf;
}

public void setStatus_zf(int status_zf) {
	this.status_zf = status_zf;
}

public int getAge() {
	return age;
}

public void setAge(int age) {
	this.age = age;
}

public String getSex() {
	return sex;
}

public void setSex(String sex) {
	this.sex = sex;
}

public int getIs_hy() {
	return is_hy;
}

public void setIs_hy(int is_hy) {
	this.is_hy = is_hy;
}

public int getIs_wy() {
	return is_wy;
}

public void setIs_wy(int is_wy) {
	this.is_wy = is_wy;
}

public int getIs_fp() {
	return is_fp;
}

public void setIs_fp(int is_fp) {
	this.is_fp = is_fp;
}

public int getIs_jz() {
	return is_jz;
}

public void setIs_jz(int is_jz) {
	this.is_jz = is_jz;
}

public int getIs_gf() {
	return is_gf;
}

public void setIs_gf(int is_gf) {
	this.is_gf = is_gf;
}

public int getIs_ps() {
	return is_ps;
}

public void setIs_ps(int is_ps) {
	this.is_ps = is_ps;
}

public int getType() {
	return type;
}

public void setType(int type) {
	this.type = type;
}

public String getMobile() {
	return mobile;
}

public void setMobile(String mobile) {
	this.mobile = mobile;
}

public int getCaseImageCount() {
	return caseImageCount;
}

public void setCaseImageCount(int caseImageCount) {
	this.caseImageCount = caseImageCount;
}



}

