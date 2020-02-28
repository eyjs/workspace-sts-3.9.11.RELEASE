package com.itwill2.di;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Primary;

import com.itwill.user.User;
import com.itwill.user.UserDao;
import com.itwill.user.UserDaoImpl;
import com.itwill.user.UserDaoImplJDBC;
import com.itwill.user.UserService;
import com.itwill.user.UserServiceImpl;
import com.itwill.user.annotation.UserDaoImplJDBC2Annotation;
import com.itwill.user.annotation.UserDaoImplJDBCAnnotation;
import com.itwill.user.annotation.UserDaoImplMyBatisAnnotation;

@Configuration
//@Import({AConfig.class, BConfig.class})
//@ImportResource({"classpath:/repository-config.xml"})
@ComponentScan(basePackages = {"com.itwill.user.annotation"},
			  excludeFilters={
					  @ComponentScan.Filter(type=FilterType.ASSIGNABLE_TYPE, value=UserDaoImplJDBCAnnotation.class),
					  @ComponentScan.Filter(type=FilterType.ASSIGNABLE_TYPE, value=UserDaoImplJDBC2Annotation.class),
					  @ComponentScan.Filter(type=FilterType.ASSIGNABLE_TYPE, value=UserDaoImplMyBatisAnnotation.class)
				})

public class RootConfigAnnotation {
	/*
	<context:annotation-config/>
	<context:component-scan base-package="com.itwill.user.annotation"/>	
	*/
}
