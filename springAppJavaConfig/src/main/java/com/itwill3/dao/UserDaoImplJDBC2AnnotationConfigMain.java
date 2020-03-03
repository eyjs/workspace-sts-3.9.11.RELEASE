package com.itwill3.dao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.user.UserDao;
public class UserDaoImplJDBC2AnnotationConfigMain {

	public static void main(String[] args) throws Exception {
		/*
		 * ApplicationContext[BeanFactory]객체생성 - Spring Container객체생성
		 */
		System.out.println("-------------Spring Container초기화시작--------");
		ApplicationContext applicationContext=
				new AnnotationConfigApplicationContext(UserDaoImplJDBC2AnnotationConfig.class);
		System.out.println("-------------Spring Container초기화끝----------");
		UserDao userDao = (UserDao) applicationContext.getBean("userDaoJDBC2");
		System.out.println("### " + userDao.findUser("a"));

	}
}
