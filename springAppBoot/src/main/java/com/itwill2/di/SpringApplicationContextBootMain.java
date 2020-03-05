package com.itwill2.di;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import com.itwill.user.User;
import com.itwill.user.UserService;
import com.itwill.user.annotation.UserAnnotation;
import com.itwill.user.annotation.UserDaoImplJDBC2Annotation;
import com.itwill.user.annotation.UserDaoImplJDBCAnnotation;
import com.itwill.user.annotation.UserDaoImplMyBatisAnnotation;
import com.itwill.user.annotation.UserDaoImplMyBatisMapperInterfaceAnnotation;
import com.itwill.user.annotation.UserDaoImplMyBatisMapperInterfaceAnnotation2;
@SpringBootApplication
@ComponentScan(basePackages = {"com.itwill.user.annotation"},
				excludeFilters={
						  @ComponentScan.Filter(type=FilterType.ASSIGNABLE_TYPE, value=UserDaoImplJDBCAnnotation.class),
						  @ComponentScan.Filter(type=FilterType.ASSIGNABLE_TYPE, value=UserDaoImplJDBC2Annotation.class),
						  @ComponentScan.Filter(type=FilterType.ASSIGNABLE_TYPE, value=UserDaoImplMyBatisAnnotation.class),
						  @ComponentScan.Filter(type=FilterType.ASSIGNABLE_TYPE, value=UserDaoImplMyBatisMapperInterfaceAnnotation.class),
						  @ComponentScan.Filter(type=FilterType.ASSIGNABLE_TYPE, value=UserDaoImplMyBatisMapperInterfaceAnnotation2.class)
							}
			  )
public class SpringApplicationContextBootMain {
	public static void main(String[] args) throws Exception{
		/*
		 * ApplicationContext[BeanFactory]객체생성
		 *  - Spring Container객체생성
		 */
		System.out.println("------------Spring Container 초기화시작---------");
		ApplicationContext applicationContext=SpringApplication.run(SpringApplicationContextBootMain.class);
		System.out.println("------------Spring Container 초기화끝---------");
		System.out.println("***********constructor,setter injection***************");
		System.out.println("1.기본형");
		UserAnnotation user=(UserAnnotation)applicationContext.getBean("userAnnotation");
		System.out.println("### "+user);
		System.out.println("2.참조형");
		UserService userService1=
				(UserService)applicationContext.getBean("userService");
		userService1.findUser("userId");
	}
}