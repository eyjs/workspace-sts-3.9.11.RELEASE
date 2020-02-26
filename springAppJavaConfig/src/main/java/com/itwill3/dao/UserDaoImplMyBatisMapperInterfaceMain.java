package com.itwill3.dao;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.user.User;
import com.itwill.user.UserDao;

public class UserDaoImplMyBatisMapperInterfaceMain {

	public static void main(String[] args) throws Exception{
		/*
		 * ApplicationContext[BeanFactory]객체생성
		 *  - Spring Container객체생성
		 */
		System.out.println("-------------Spring Container초기화시작--------");
		ApplicationContext applicationContext=
				new ClassPathXmlApplicationContext("com/itwill3/dao/3-4.user_dao_mybatis_mapper_interface.xml");
		System.out.println("-------------Spring Container초기화끝----------");
		UserDao userDao=(UserDao)applicationContext.getBean("userDao");
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









