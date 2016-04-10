package com.zyt.entity.resource;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zyt.base.BaseEntity;

public class AddressEntity
		extends BaseEntity
{
	@JsonIgnore
	protected int id;
	@JsonIgnore
	private int userid;
	private String name;
	private String tel;
	private String provinces;
	private String city;
	private String zone;
	private String detailed;
	private String code;
	
	
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
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getProvinces() {
		return provinces;
	}
	public void setProvinces(String provinces) {
		this.provinces = provinces;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZone() {
		return zone;
	}
	public void setZone(String zone) {
		this.zone = zone;
	}
	public String getDetailed() {
		return detailed;
	}
	public void setDetailed(String detailed) {
		this.detailed = detailed;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public String toString()
	{
	   return "AddressEntity(id=" + getId() + ", userid=" + getUserid() + ", name" + getName() + ", tel=" + getTel() + ", provinces=" + getProvinces() + ", city=" + getCity() + ", zone=" + getZone() + ", detailed=" + getDetailed() + ", code=" + getCode() + ")";
	}
}
