package com.mybatis3.domain;

import java.util.Date;
/*
STUD_ID NOT NULL NUMBER(11)   
NAME    NOT NULL VARCHAR2(50) 
EMAIL   NOT NULL VARCHAR2(50) 
PHONE            VARCHAR2(15) 
DOB              DATE         
BIO              CLOB         
PIC              BLOB         
ADDR_ID          NUMBER(11)    
*/


public class Student
{
	private Integer studId;
	private String name;
	private String email;
	private Date dob;
	private Address address;
	public Student() {
		
	}
	
	public Student(Integer studId) {
		this.studId = studId;
	}
	
	public Student(Integer studId, String name, String email, Date dob) {
		this.studId = studId;
		this.name = name;
		this.email = email;
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Student [studId=" + studId + ", name=" + name + ", email="
				+ email + ", dob=" + dob + ",address="+address+"]\n";
	}
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	public Integer getStudId() {
		return studId;
	}
	public void setStudId(Integer studId) {
		this.studId = studId;
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
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	
}
