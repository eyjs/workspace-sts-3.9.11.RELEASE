package com.itwill2.di;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.itwill.user.User;
import com.itwill.user.UserService;
@SpringBootApplication
@ComponentScan(basePackages = "com.itwill.user")
public class SpringBootApplicationContextMain {

	public static void main(String[] args) throws Exception{
		/*
		 * ApplicationContext[BeanFactory]객체생성
		 *  - Spring Container객체생성
		 */
		System.out.println("------------Spring Container 초기화시작---------");
		ApplicationContext applicationContext=SpringApplication.run(SpringBootApplicationContextMain.class);
		System.out.println("------------Spring Container 초기화끝---------");
		System.out.println("***********constructor,setter injection***************");
		System.out.println("1.기본형");
		User user=(User)applicationContext.getBean("user");
		System.out.println("### "+user);
		System.out.println("2.참조형");
		UserService userService1=
				(UserService)applicationContext.getBean("userService");
		userService1.findUser("userId");
		
		
		
	}
}









