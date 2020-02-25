package com.itwill.user.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value = "userAnnotation")
public class UserAnnotation {
	@Value(value = "yyyy")
	private String userId;
	@Value(value = "111")
	private String password;
	@Value(value = "와이맨")
	private String name;
	@Value(value = "y@gmail.com")
	private String email;

	public UserAnnotation() {
		System.out.println("#### UserAnnotation : 디폴트생성자호출");
		
	}

	public UserAnnotation(String userId,String password) {
		super();
		this.userId = userId;
		this.password = password;
		System.out.println("#### UserAnnotation : UserAnnotation(String userId,String password) : 생성자호출");
		
	}
	public UserAnnotation(String userId, String password, String name, String email) {
		super();
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.email = email;
		System.out.println("#### UserAnnotation : UserAnnotation(String userId, String password, String name, String email) : 생성자호출");
		
	}
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		System.out.println("#### UserAnnotation.setUserId("+userId+")메쏘드호출");
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
	@Override
	public String toString() {
		return "UserAnnotation:"+userId+","+password+","+name+","+email;
	}
	/*
	 *패쓰워드 일치여부 검사 
	 */
	public boolean isMatchPassword(String password){
		boolean isMatch=false;
		if(this.password.equals(password)){
			isMatch=true;
		}
		return isMatch;
	}
	

}







