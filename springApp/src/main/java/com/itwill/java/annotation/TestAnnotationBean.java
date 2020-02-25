package com.itwill.java.annotation;
@TestAnnotation(age = 23,strArray = {"a","b","c"},value = "test")
public class TestAnnotationBean {
	@TestAnnotation(age = 23,strArray = {},value = "")
	private String member;
	
	@TestAnnotation(age = 34,strArray = {},value = "test2")
	public TestAnnotationBean() {
		// TODO Auto-generated constructor stub
	}
	@TestAnnotation(age = 22,value = "test33")
	public String getMember() {
		return member;
	}

	public void setMember(@TestAnnotation(age = 34,value = "test8") String member) {
		this.member = member;
	}
	
}
