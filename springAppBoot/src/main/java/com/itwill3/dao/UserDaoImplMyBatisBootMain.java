package com.itwill3.dao;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import com.itwill.user.UserDao;
@SpringBootApplication
@ComponentScan(	basePackages = {"com.itwill.user.annotation"},

excludeFilters = {
					@Filter( type = FilterType.ASPECTJ,
							 pattern = "*..*.*UserDaoImpl* "
							 		+ "&& !*..*.UserDaoImplAnnotation "
							 		+ "&& !*..*.UserDaoImplJDBCAnnotation"
							 		+ "&& !*..*.UserDaoImplMyBatisAnnotation"
							),
					@Filter(type = FilterType.ANNOTATION, 
							classes = {
										SpringBootApplication.class,
										Configuration.class
									}
							)
				}
)
public class UserDaoImplMyBatisBootMain {

	public static void main(String[] args) throws Exception{
		/*
		 * ApplicationContext[BeanFactory]객체생성
		 *  - Spring Container객체생성
		 */
		System.out.println("------------Spring Container 초기화시작---------");
		ApplicationContext applicationContext=
				SpringApplication.run(UserDaoImplMyBatisBootMain.class);
		System.out.println("------------Spring Container 초기화끝---------");
		UserDao userDao=(UserDao)applicationContext.getBean("userDaoMyBatis");
		System.out.println("### "+userDao.findUser("a"));
		System.out.println("### "+userDao.findUserList());
	}
}









