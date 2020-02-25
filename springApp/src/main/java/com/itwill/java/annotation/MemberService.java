package com.itwill.java.annotation;
@MyComponent
public class MemberService {
	@TestAnnotation(age = 23,value = "")
	public String member1;
	@TestAnnotation(age = 23,value = "")
	public String member2;
	public MemberService() {
		// TODO Auto-generated constructor stub
	}
	@TestAnnotation(age = 23,value = "")
	public String getMember1() {
		return member1;
	}
	@TestAnnotation(age = 23,value = "")
	public void setMember1(String member1) {
		this.member1 = member1;
	}
	@TestAnnotation(age = 23,value = "")
	public String getMember2() {
		return member2;
	}
	public void setMember2(String member2) {
		this.member2 = member2;
	}
	
}
