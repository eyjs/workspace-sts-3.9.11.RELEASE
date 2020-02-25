package com.itwill2.di;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.user.User;
import com.itwill.user.UserService;
import com.itwill.user.annotation.UserAnnotation;

public class SpringApplicationContextAnnotationMain {

	public static void main(String[] args) throws Exception{
		/*
		 * ApplicationContext[BeanFactory]객체생성
		 *  - Spring Container객체생성
		 */
		System.out.println("-------------Spring Container초기화시작--------");
		ApplicationContext applicationContext=
				new ClassPathXmlApplicationContext("com/itwill2/di/2.bean_dependency_annotation.xml");
		System.out.println("-------------Spring Container초기화끝----------");
		UserAnnotation user=(UserAnnotation)applicationContext.getBean("userAnnotation");
		System.out.println("### "+user);
		UserService userService=
				(UserService)applicationContext.getBean("userService");
		userService.findUser("xxx");
	}
}









