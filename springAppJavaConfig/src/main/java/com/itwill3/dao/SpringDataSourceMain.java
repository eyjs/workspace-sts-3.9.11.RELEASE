package com.itwill3.dao;


import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.user.User;
import com.itwill.user.UserDao;
import com.itwill.user.UserService;
import com.itwill2.di.RootConfigAnnotation;

public class SpringDataSourceMain {

	public static void main(String[] args) throws Exception{
		/*
		 * ApplicationContext[BeanFactory]객체생성
		 *  - Spring Container객체생성
		 */
		System.out.println("-------------Spring Container초기화시작--------");
		ApplicationContext applicationContext=
				new AnnotationConfigApplicationContext(SpringDataSourceConfig.class);
		System.out.println("-------------Spring Container초기화끝----------");
		DataSource apacheDataSource=
				(DataSource)applicationContext.getBean("apacheDataSource");
		Connection con1 = apacheDataSource.getConnection();
		System.out.println("### apacheDataSource:"+apacheDataSource);
		System.out.println("### apacheDataSource Connection:"+con1);
		DataSource springDataSource=
				(DataSource)applicationContext.getBean("springDataSource");
		Connection con2 = apacheDataSource.getConnection();
		System.out.println("### springDataSource:"+springDataSource);
		System.out.println("### springDataSource Connection:"+con2);
		con1.close();
		con2.close();
		
	
		
	}
}









