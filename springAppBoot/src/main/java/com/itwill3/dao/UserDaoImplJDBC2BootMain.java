package com.itwill3.dao;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.itwill.user.UserDao;
@SpringBootApplication
@ComponentScan(basePackages = "com.itwill.user")
public class UserDaoImplJDBC2BootMain {
	public static void main(String[] args) throws Exception{
		System.out.println("------------Spring Container 초기화시작---------");
		ApplicationContext applicationContext=
				SpringApplication.run(UserDaoImplJDBC2BootMain.class);
		System.out.println("------------Spring Container 초기화끝---------");
		UserDao userDao=(UserDao)applicationContext.getBean("userDaoJDBC2");
		System.out.println("### "+userDao.findUser("a"));
		System.out.println("### "+userDao.findUserList());
		
	}
}









