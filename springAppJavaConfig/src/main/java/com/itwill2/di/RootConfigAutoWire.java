package com.itwill2.di;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Primary;

import com.itwill.user.User;
import com.itwill.user.UserDao;
import com.itwill.user.UserDaoImpl;
import com.itwill.user.UserDaoImplJDBC;
import com.itwill.user.UserService;
import com.itwill.user.UserServiceImpl;

@Configuration
//@Import({AConfig.class, BConfig.class})
//@ImportResource({"classpath:/article-repository.xml"})
public class RootConfigAutoWire {
	/*
	<bean id="userDao"  class="com.itwill.user.UserDaoImpl"/>
	<bean id="userDaoJDBC" primary="true" class="com.itwill.user.UserDaoImplJDBC"/>
	<!-- 
		byName wiring(setter injection) 
		UserServiceImpl객체의 property이름과일치하는 
		빈의아이디를 검색하여 injection해준다
		빈의아이디가 존재하지않을경우 예외발생안함
    -->
	<bean id="byNameUserService"
		  autowire="byName" 
		  class="com.itwill.user.UserServiceImpl"/>
	<!-- 
		byType wiring(setter injection) 
		UserServiceImpl객체의 property인자타입과일치하는 
		빈을 검색하여 injection해준다.
		property인자타입과일치하는빈이 두개이상 존재할경우 예외발생함
		primary="true" 설정
	-->
	<bean id="byTypeUserService"
		  autowire="byType" 
		  class="com.itwill.user.UserServiceImpl"/>
	<!-- 
		constructor(byType) wiring(constructor injection) 
		UserServiceImpl객체의 생성자인자타입과일치하는 
		빈을 검색하여 injection해준다.
		생성자인자타입과일치하는빈이 두개이상 존재할경우 예외발생함
		primary="true" 설정
	-->	  
	<bean id="constructorUserService"
		  autowire="constructor" 
		  class="com.itwill.user.UserServiceImpl"/>
	 */
	@Bean("userDao")
	public UserDao userDao() {
		return new UserDaoImpl();
	}
	@Bean("userDaoJDBC")
	@Primary
	public UserDao userDaoJDBC() {
		return new UserDaoImplJDBC();
	}
	@Bean("userService")
	public UserService userService() {
		return new UserServiceImpl(userDao());
	}
	@Bean(value = "byNameUserService",autowire = Autowire.BY_NAME)
	public UserService byNameUserService() {
		return new UserServiceImpl();
	}
	@Bean(value = "byTypeUserService",autowire = Autowire.BY_TYPE)
	public UserService byTypeUserService() {
		return new UserServiceImpl();
	}
	@Bean(value = "constructorUserService")
	public UserService constructorUserService() {
		return new UserServiceImpl(userDaoJDBC());
	}
	
	
}
