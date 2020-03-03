package com.itwill3.dao;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.itwill.user.User;
import com.itwill.user.UserDao;
import com.itwill.user.UserDaoImplJDBC2;
import com.itwill.user.annotation.UserDaoImplAnnotation;
import com.itwill.user.annotation.UserDaoImplJDBCAnnotation;
import com.itwill.user.annotation.UserDaoImplMyBatisAnnotation;
import com.itwill.user.annotation.UserDaoImplMyBatisMapperInterfaceAnnotation;
import com.itwill.user.annotation.UserDaoImplMyBatisMapperInterfaceAnnotation2;

@Configuration
@ComponentScan(	basePackages = {"com.itwill.user.annotation"},
				excludeFilters = @Filter(type = FilterType.ASSIGNABLE_TYPE,
										 classes = {	
											UserDaoImplMyBatisAnnotation.class,
											UserDaoImplMyBatisMapperInterfaceAnnotation.class,
											UserDaoImplMyBatisMapperInterfaceAnnotation2.class
										  }
										)
			 )
/*
<context:component-scan base-package="com.itwill.user.annotation">
		<context:exclude-filter type="assignable" expression="com.itwill.user.annotation.UserDaoImplMyBatisAnnotation"/>
		<context:exclude-filter type="assignable" expression="com.itwill.user.annotation.UserDaoImplMyBatisMapperInterfaceAnnotation"/>
		<context:exclude-filter type="assignable" expression="com.itwill.user.annotation.UserDaoImplMyBatisMapperInterfaceAnnotation2"/>
</context:component-scan>
 */
public class UserDaoImplJDBC2AnnotationConfig {
	@Bean(value = "springDataSource")
	public DataSource springDataSource() {
		DriverManagerDataSource dataSource=new  DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@182.237.126.19:1521:XE");
		dataSource.setUsername("javaspring31");
		dataSource.setPassword("javaspring31");
		return dataSource;
	}
	
}
