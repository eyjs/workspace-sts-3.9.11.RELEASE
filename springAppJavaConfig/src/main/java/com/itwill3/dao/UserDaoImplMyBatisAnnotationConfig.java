package com.itwill3.dao;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.itwill.user.UserDao;
import com.itwill.user.UserDaoImplJDBC2;
import com.itwill.user.UserDaoImplMyBatis;

@Configuration
public class UserDaoImplMyBatisAnnotationConfig {
	
	@Bean
	public DataSource springDataSource() {
		DriverManagerDataSource dataSource=new  DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@182.237.126.19:1521:XE");
		dataSource.setUsername("javaspring31");
		dataSource.setPassword("javaspring31");
		return dataSource;
	}

	@Autowired
	ApplicationContext applicationContext;
	
	@Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception{
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(springDataSource());
        factoryBean.setConfigLocation(applicationContext.getResource("classpath:mybatis-config.xml"));
        factoryBean.setMapperLocations(applicationContext.getResources("classpath:/com/itwill3/dao/UserMapper.xml"));
        return factoryBean.getObject();
    }
	@Bean
	public SqlSessionTemplate sqlSession() throws Exception {
	  return new SqlSessionTemplate(sqlSessionFactory());
	}
	
	@Bean
	public UserDao userDao() throws Exception{
		UserDaoImplMyBatis userDao=new UserDaoImplMyBatis();
		userDao.setSqlSession(sqlSession());
		return userDao;
	}
	
}
