package com.itwill3.dao;


import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.user.User;
import com.itwill.user.UserDao;
import com.itwill.user.UserDaoImplJdbcTemplate;
import com.itwill.user.UserService;

public class UserDaoImplJdbcTemplateMain {

	public static void main(String[] args) throws Exception{
		/*
		 * ApplicationContext[BeanFactory]객체생성
		 *  - Spring Container객체생성
		 */
		System.out.println("-------------Spring Container초기화시작--------");
		ApplicationContext applicationContext=
				new ClassPathXmlApplicationContext("com/itwill3/dao/3-7.user_dao_jdbc_template.xml");
		System.out.println("-------------Spring Container초기화끝----------");
		UserDao userDao=
				(UserDao)applicationContext.getBean("userDao");
		System.out.println("### "+userDao.findUser("a"));
		System.out.println("### "+userDao.findUserList());
		
	}
}









