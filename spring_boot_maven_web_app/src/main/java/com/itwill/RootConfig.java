package com.itwill;

import javax.sql.DataSource;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


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
public class RootConfig {
	
    
}
