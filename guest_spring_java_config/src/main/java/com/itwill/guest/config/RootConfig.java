package com.itwill.guest.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.itwill.guest.GuestDao;
import com.itwill.guest.GuestDaoImplJDBC;
import com.itwill.guest.GuestService;
import com.itwill.guest.GuestServiceImpl;
/*
<< application-config.xml을 대신할 java 클래스 >>

    <context:property-placeholder location="classpath:db/jdbc.properties"/>
	<!-- Apache DataSource -->
	<bean id="apacheDataSource" 
	      class="org.apache.commons.dbcp2.BasicDataSource">
	      <property name="driverClassName" value="oracle.jdbc.driver.OracleDriver"/>
	      <property name="url" value="${jdbc.url}"/>
	      <property name="username" value="${jdbc.username}"/>
	      <property name="password" value="${jdbc.password}"/>
	</bean>
	<bean id="guestDao" class="com.itwill.guest.GuestDaoImplJDBC">
		<constructor-arg index="0" ref="apacheDataSource"/>
	</bean>
	<bean id="guestService" class="com.itwill.guest.GuestServiceImpl">
		<property name="guestDao" ref="guestDao"/>
	</bean>
*/
@Configuration
@PropertySource("classpath:db/jdbc.properties")
public class RootConfig {
	@Bean
	public DataSource apacheDataSource() {
		BasicDataSource dataSource=new  BasicDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@182.237.126.19:1521:XE");
		dataSource.setUsername("javaspring31");;
		dataSource.setPassword("javaspring31");
		return dataSource;
	}
	@Bean
	public GuestDao guestDao() throws Exception{
		return new GuestDaoImplJDBC(apacheDataSource());
	}
	@Bean
	public GuestService guestService() throws Exception{
		GuestServiceImpl guestService=new GuestServiceImpl();
		guestService.setGuestDao(guestDao());
		return guestService;
	}
    
}
