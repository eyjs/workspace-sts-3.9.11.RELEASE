package com.itwill3.dao;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.itwill.user.UserDao;
import com.itwill.user.UserDaoImplMyBatisMapperInterface;
import com.itwill.user.mapper.UserMapper;
@Configuration
public class UserDaoImplMyBatisMapperInterfaceAnnotationConfig {
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
	public UserMapper userMapper() throws Exception {
	  MapperFactoryBean<UserMapper> factoryBean = new MapperFactoryBean<>(UserMapper.class);
	  factoryBean.setSqlSessionFactory(sqlSessionFactory());
	  factoryBean.setMapperInterface(UserMapper.class);
	  return factoryBean.getObject();
	}
	@Bean
	public UserDao userDao() throws Exception{
		UserDaoImplMyBatisMapperInterface userDao=
				new UserDaoImplMyBatisMapperInterface();
		userDao.setUserMapper(userMapper());
		return userDao;
	}
}
