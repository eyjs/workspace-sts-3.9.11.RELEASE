package com.itwill3.dao;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import com.itwill.user.User;
import com.itwill.user.UserDao;
@SpringBootApplication
@ComponentScan(	basePackages = {"com.itwill.user.annotation"},

excludeFilters = {
					@Filter( type = FilterType.ASPECTJ,
							 pattern = "*..*.*UserDaoImpl* "
							 		+ "&& !*..*.UserDaoImplAnnotation"
							 		+ "&& !*..*.UserDaoImplJDBCAnnotation"
							 		+ "&& !*..*.UserDaoImplMyBatisMapperInterfaceAnnotation2"
							),
					@Filter(type = FilterType.ANNOTATION, 
							classes = {
										SpringBootApplication.class,
										Configuration.class
									}
							)
				}
)
@MapperScan(basePackages = "com.itwill.user.mapper2")
public class UserDaoImplMyBatisMapperInterface2BootMain {

	public static void main(String[] args) throws Exception{
		/*
		 * ApplicationContext[BeanFactory]객체생성
		 *  - Spring Container객체생성
		 */
		System.out.println("------------Spring Container 초기화시작---------");
		ApplicationContext applicationContext=
				SpringApplication.run(UserDaoImplMyBatisMapperInterface2BootMain.class);
		System.out.println("------------Spring Container 초기화끝---------");
		UserDao userDao=(UserDao)applicationContext.getBean("userDaoMyBatisMapper2");
		System.out.println("### userDao:"+userDao);
		System.out.println("### "+userDao.findUserList());
		System.out.println("### "+userDao.create(new User("x3", "x3","x3","x3")));
		System.out.println("### "+userDao.findUser("x3"));
		System.out.println("### "+userDao.update(new User("x3", "x3변경","x23변경","x3변경")));
		System.out.println("### "+userDao.findUser("x3"));
		System.out.println("### "+userDao.remove("x3"));
		System.out.println("### "+userDao.findUserList());
		
		
	}
}









