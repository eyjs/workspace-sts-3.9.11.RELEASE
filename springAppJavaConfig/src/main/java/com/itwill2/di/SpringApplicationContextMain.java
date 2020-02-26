package com.itwill2.di;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.itwill.user.User;
import com.itwill.user.UserService;

public class SpringApplicationContextMain {

	public static void main(String[] args) throws Exception{
		/*
		 * ApplicationContext[BeanFactory]객체생성
		 *  - Spring Container객체생성
		 */
		System.out.println("-------------Spring Container초기화시작--------");
		ApplicationContext applicationContext=
				new AnnotationConfigApplicationContext(RootConfig.class);
		System.out.println("-------------Spring Container초기화끝----------");
		System.out.println("***********constructor injection***************");
		System.out.println("1.기본형");
		User user0=(User)applicationContext.getBean("constructorUser0");
		User user1=(User)applicationContext.getBean("constructorUser1");
		User user2=(User)applicationContext.getBean("constructorUser2");
		System.out.println("### "+user0);
		System.out.println("### "+user1);
		System.out.println("### "+user2);
		
		System.out.println("2.참조형");
		UserService userService=
				(UserService)applicationContext.getBean("userService");
		userService.findUser("userId");
		userService.create(null);
		System.out.println("***********setter injection***************");
		System.out.println("1.기본형");
		User setUser1=(User)applicationContext.getBean("setUser1");
		User setUser2=(User)applicationContext.getBean("setUser2");
		System.out.println("### "+setUser1);
		System.out.println("### "+setUser2);
		System.out.println("2.참조형");
		UserService setUserService=
				(UserService)applicationContext.getBean("setUserService");
		setUserService.findUser(null);
		setUserService.create(null);
		
	}
}









