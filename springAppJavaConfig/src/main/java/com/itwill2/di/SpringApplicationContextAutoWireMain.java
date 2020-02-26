package com.itwill2.di;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.user.User;
import com.itwill.user.UserService;

public class SpringApplicationContextAutoWireMain {

	public static void main(String[] args) throws Exception{
		/*
		 * ApplicationContext[BeanFactory]객체생성
		 *  - Spring Container객체생성
		 */
		System.out.println("-------------Spring Container초기화시작--------");
		ApplicationContext applicationContext=
				new AnnotationConfigApplicationContext(RootConfigAutoWire.class);
		System.out.println("-------------Spring Container초기화끝----------");
		System.out.println("**********autowire byName***********");
		UserService byNameUserService=
				(UserService)applicationContext.getBean("byNameUserService");
		byNameUserService.findUser("userId");
		System.out.println("**********autowire byType***********");
		UserService byTypeUserService=
				(UserService)applicationContext.getBean("byTypeUserService");
		byTypeUserService.findUser("userId");
		System.out.println("**********autowire constructor***********");
		UserService constructorUserService=
				(UserService)applicationContext.getBean("constructorUserService");
		constructorUserService.findUser("userId");
	}
}









