package com.newlecture.web.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
//@Table(name=user) : 만약 테이블 이름이 엔티티랑 다른 경우 
public class Member {
	@Id
	private String id;
	private String name;
	private String email;
	private String pwd;
	@Column(insertable=false) //insert 할 때 뺴기 할 수 없다 
	private Date regDate;
	//@Column(name="FOTO") : 컬럼명이 다른 경우
	private String photo;
	
	public Member() {
		
	}
	
	public Member(String id, String name, String email, String pwd, Date regDate) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.pwd = pwd;
		this.regDate = regDate;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	
	
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", email=" + email + ", pwd=" + pwd + ", regDate=" + regDate
				+ "]";
	}
	
	
}
