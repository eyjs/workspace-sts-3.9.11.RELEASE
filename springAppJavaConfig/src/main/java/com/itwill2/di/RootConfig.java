package com.itwill2.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.itwill.user.User;
import com.itwill.user.UserDao;
import com.itwill.user.UserDaoImpl;
import com.itwill.user.UserService;
import com.itwill.user.UserServiceImpl;

@Configuration
public class RootConfig {
	@Bean("constructorUser0")
	public User user1() {
		return new User();
	}
	@Bean("constructorUser1")
	public User user2() {
		return new User("xxx","xxx","xxx","xxx");
		
	}
	@Bean("constructorUser2")
	public User user3() {
		return new User("yyy","yyy");
	}
	@Bean("setUser1")
	public User setUser1() {
		User user=new User();
		user.setUserId("zzz");
		user.setName("zzz");
		user.setEmail("zzz");
		user.setPassword("zzz");
		return user;
	}
	@Bean("setUser2")
	public User setUser2() {
		User user=new User();
		user.setUserId("ttt");
		user.setName("ttt");
		user.setEmail("zzz");
		user.setPassword("zzz");
		return user;
	}
	@Bean("userDao")
	public UserDao userDao() {
		return new UserDaoImpl();
	}
	@Bean("userService")
	public UserService userService() {
		return new UserServiceImpl(userDao());
	}
	@Bean("setUserService")
	public UserService setUserService() {
		return new UserServiceImpl(userDao());
	}
	
}
