package com.itwill3.dao;

import javax.sql.DataSource;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.itwill.user.UserDao;
import com.itwill.user.UserDaoImplMyBatisMapperInterface;
import com.itwill.user.mapper.MyMapper;
import com.itwill.user.mapper.UserMapper;

@Configuration
public class UserDaoImplMyBatisMapperInterfaceConfig {
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
    public SqlSessionFactory sqlSessionFactory() throws Exception{
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(springDataSource());
		return factoryBean.getObject();
    }
	/*****************************case1***************************
	/*
		<bean id="userMapper" class="org.mybatis.spring.mapper.MapperFactoryBean">
			<property name="mapperInterface" value="com.itwill.user.mapper.UserMapper"/>
			<property name="sqlSessionFactory" ref="sqlSessionFactory"/>
		</bean>
	*************************************************************/
	@Bean
	public UserMapper userMapper() throws Exception {
	  MapperFactoryBean<UserMapper> factoryBean = new MapperFactoryBean<>();
	  factoryBean.setSqlSessionFactory(sqlSessionFactory());
	  factoryBean.setMapperInterface(UserMapper.class);
	  factoryBean.afterPropertiesSet();
	  return factoryBean.getObject();
	}
	/*****************************case2***************************
	<bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
	     <property name="basePackage" value="com.itwill.user.mapper" />
	     <property name="sqlSessionFactoryBeanName"  value="sqlSessionFactory"/>
	</bean>
	*************************************************************/
	//@Bean
	public MapperScannerConfigurer mapperScannerConfigurer1() {
	    MapperScannerConfigurer configurer = new MapperScannerConfigurer();
	    configurer.setBasePackage("com.itwill.user.mapper");
	    configurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
	    return configurer;
	}
	
	/*************************case 3********************************
	<bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
	     <property name="basePackage" value="com.itwill.user.mapper" />
	     <property name="sqlSessionFactoryBeanName"  value="sqlSessionFactory"/>
	     <property name="annotationClass" value="com.itwill.user.mapper.MyMapper" />
	</bean>
	*************************************************************/
	//@Bean
	public MapperScannerConfigurer mapperScannerConfigurer2() {
	    MapperScannerConfigurer scannerConfigurer = new MapperScannerConfigurer();
	    scannerConfigurer.setBasePackage("com.itwill.user.mapper");
	    scannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
	    //scannerConfigurer.setAnnotationClass(Mapper.class);
	    scannerConfigurer.setAnnotationClass(MyMapper.class);
	    return scannerConfigurer;
	}
	
	
	
	@Bean
	public UserDao userDao(UserMapper userMapper) throws Exception{
		  UserDaoImplMyBatisMapperInterface userDao=
				new UserDaoImplMyBatisMapperInterface();
		  userDao.setUserMapper(userMapper);
		return userDao;
	}
	
}
