package com.itwill.address;
/*
이름      널?       유형           
------- -------- ------------ 
NO      NOT NULL NUMBER(4)    
ID               VARCHAR2(20) 
NAME             VARCHAR2(20) 
PHONE            VARCHAR2(15) 
ADDRESS          VARCHAR2(60) 
 */
/*
 *  주소록객체를 추상화한클래스
 * DTO(Data Transfer Object)객체,도메인객체
 *   -  1개의  주소록데이타를 가지고있는 객체
 *   -  Address DB 테이블 한개 row
 */
public class Address {
	private int no;
	private String id;
	private String name;
	private String phone;
	private String address;
	public Address() {
		// TODO Auto-generated constructor stub
	}
	public Address(int no, String id, String name, String phone, String address) {
		super();
		this.no = no;
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.address = address;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Address [no=" + no + ", id=" + id + ", name=" + name + ", phone=" + phone + ", address=" + address
				+ "]\n";
	}
	
	
}










