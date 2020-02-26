package com.itwill3.dao;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.user.User;
import com.itwill.user.UserDao;
@SpringBootApplication
@ComponentScan(basePackages = "com.itwill.user")
@MapperScan(basePackages = "com.itwill.user.mapper")
public class UserDaoImplMyBatisMapperInterfaceBootMain {
	public static void main(String[] args) throws Exception{
		/*
		 * ApplicationContext[BeanFactory]객체생성
		 *  - Spring Container객체생성
		 */
		System.out.println("------------Spring Container 초기화시작---------");
		ApplicationContext applicationContext=
				SpringApplication.run(UserDaoImplMyBatisMapperInterfaceBootMain.class);
		System.out.println("------------Spring Container 초기화끝---------");
		UserDao userDao=(UserDao)applicationContext.getBean("userDaoImplMyBatisMapperInterface");
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









