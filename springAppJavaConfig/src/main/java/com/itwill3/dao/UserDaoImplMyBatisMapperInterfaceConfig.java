package com.itwill3.dao;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.itwill.user.UserDao;
import com.itwill.user.UserDaoImplMyBatisMapperInterface;
import com.itwill.user.mapper.UserMapper;

@Configuration
@MapperScan(value="com.itwill.user.mapper")
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
	@Bean
	public MapperFactoryBean<UserMapper> userMapper() throws Exception {
	  MapperFactoryBean<UserMapper> factoryBean = new MapperFactoryBean<>(UserMapper.class);
	  factoryBean.setSqlSessionFactory(sqlSessionFactory());
	  return factoryBean;
	}
	
	@Bean
	public UserDao userDao() throws Exception{
		UserDaoImplMyBatisMapperInterface userDao=
				new UserDaoImplMyBatisMapperInterface();
		userDao.setUserMapper(userMapper().getObject());
		return userDao;
	}
	
}
