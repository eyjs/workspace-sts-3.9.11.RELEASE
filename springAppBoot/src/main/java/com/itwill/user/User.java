package com.itwill.user;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class User {
	@Value("guard")
	private String userId;
	@Value("xxxx")
	private String password;
	@Value("이름")
	private String name;
	@Value("guard@gmail.com")
	private String email;

	public User() {
		System.out.println("#### User : 디폴트생성자호출");
		
	}
	
	//@Autowired
	public User(@Value(value = "yyyy") String userId, @Value(value = "1111")String password, @Value(value = "이름")String name, @Value(value = "이메일")String email) {
		super();
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.email = email;
		System.out.println("#### User : User(String userId, String password, String name, String email) : 생성자호출");
		
	}
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
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
		return "user:"+userId+","+password+","+name+","+email+"\n";
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







