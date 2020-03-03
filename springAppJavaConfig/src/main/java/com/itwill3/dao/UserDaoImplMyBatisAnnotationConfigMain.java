package com.itwill3.dao;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.itwill.user.User;
import com.itwill.user.UserDao;

public class UserDaoImplMyBatisAnnotationConfigMain {

	public static void main(String[] args) throws Exception{
		/*
		 * ApplicationContext[BeanFactory]객체생성
		 *  - Spring Container객체생성
		 */
		System.out.println("-------------Spring Container초기화시작--------");
		ApplicationContext applicationContext=
				new AnnotationConfigApplicationContext(UserDaoImplMyBatisAnnotationConfig.class);
		System.out.println("-------------Spring Container초기화끝----------");
		UserDao userDao=(UserDao)applicationContext.getBean("userDaoMyBatis");
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









