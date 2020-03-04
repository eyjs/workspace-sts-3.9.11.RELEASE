package com.itwill.user.client;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.user.User;
import com.itwill.user.UserDao;
import com.itwill.user.UserDaoImpl;
import com.itwill.user.UserService;
import com.itwill.user.UserServiceImpl;

public class UserServiceClient {
	public static void main(String[] args) throws Exception{		
		//ApplicationContext applicationContext = 
		//	new ClassPathXmlApplicationContext("com/itwill/user/client/99.user.xml");
		//UserDao userDao=(UserDao)applicationContext.getBean("userDao");
		//UserService userService = (UserService)applicationContext.getBean("userService");
		UserDao userDao=new UserDaoImpl();
		UserService userService=new UserServiceImpl();
		userService.findUser("id");
		userService.remove("id");
		userService.findUserList();
		
	}
}
