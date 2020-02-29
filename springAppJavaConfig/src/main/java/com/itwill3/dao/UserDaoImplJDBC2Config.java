package com.itwill3.dao;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.itwill.user.User;
import com.itwill.user.UserDao;
import com.itwill.user.UserDaoImplJDBC2;

@Configuration
@PropertySource("classpath:jdbc.properties")
public class UserDaoImplJDBC2Config {
	@Value("${jdbc.driverClassName}")
	String driverClassName;
	@Value("${jdbc.url}")
	String url;
	@Value("${jdbc.username}")
	String username;
	@Value("${jdbc.password}")
	String password;
	@Bean
	public DataSource apacheDataSource() {
		BasicDataSource dataSource=new  BasicDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);;
		dataSource.setPassword(password);
		return dataSource;
	}
	@Bean
	public DataSource springDataSource() {
		DriverManagerDataSource dataSource=new  DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@182.237.126.19:1521:XE");
		dataSource.setUsername("javaspring31");
		dataSource.setPassword("javaspring31");
		return dataSource;
	}
	@Bean
	public UserDao userDao() {
		return new UserDaoImplJDBC2(springDataSource());
	}
	
	
}
