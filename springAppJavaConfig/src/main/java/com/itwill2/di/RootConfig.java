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
	/*
	 <!-- 1.Constructor Injection -->
	<!-- primitive type -->
	<bean id="constructorUser0" class="com.itwill.user.User"/>
	<bean id="constructorUser1" class="com.itwill.user.User">
		<constructor-arg value="guard" index="0"/>
		<constructor-arg value="1111" index="1"/>
		<constructor-arg value="김미숙" index="2"/>
		<constructor-arg value="guard@gmail.com" index="3"/>
	</bean>	
	<bean id="constructorUser2" class="com.itwill.user.User">
		<constructor-arg value="xxxx" index="0"/>
		<constructor-arg value="2222" index="1"/>
	</bean>
	<!-- ref(Bean) type -->
	<bean id="userDao" class="com.itwill.user.UserDaoImpl"/>
	<bean id="userService" class="com.itwill.user.UserServiceImpl">
		<constructor-arg ref="userDao" index="0"/>
	</bean>
	<!-- 2.Setter Injection -->
	<!-- primitive type -->
	<bean id="setUser1" class="com.itwill.user.User">
		<property name="userId" value="guard"/>
		<property name="name" value="가아드"/>
		<property name="email" value="guard@google.com"/>
		<property name="password" value="xxxx"/>
	</bean>
	<bean id="setUser2" 
	      p:userId="yyyy"
	      p:name="와이맨"
	      p:password="1111"
	      p:email="y@korea.com"
		  class="com.itwill.user.User"/>
	<!-- ref(Bean) type -->
	<bean id="setUserService" class="com.itwill.user.UserServiceImpl">
		<property name="userDao" ref="userDao"/>
	</bean>
	
	 */
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
