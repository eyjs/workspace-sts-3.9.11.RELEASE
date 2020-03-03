package com.itwill3.dao;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.itwill.user.UserDao;
import com.itwill.user.UserDaoImplMyBatis;
import com.itwill.user.UserDaoImplMyBatisMapperInterface;
import com.itwill.user.annotation.UserDaoImplJDBC2Annotation;
import com.itwill.user.annotation.UserDaoImplJdbcTemplateAnnotation;
import com.itwill.user.annotation.UserDaoImplMyBatisAnnotation;
import com.itwill.user.annotation.UserDaoImplMyBatisMapperInterfaceAnnotation;
import com.itwill.user.annotation.UserDaoImplMyBatisMapperInterfaceAnnotation2;
import com.itwill.user.mapper.UserMapper;
import com.itwill.user.mapper2.MyMapper;
@Configuration
@ComponentScan(	basePackages = {"com.itwill.user.annotation"},
				excludeFilters = @Filter(type = FilterType.ASSIGNABLE_TYPE,
										 classes = {	
											UserDaoImplJDBC2Annotation.class,
											UserDaoImplJdbcTemplateAnnotation.class,
											UserDaoImplMyBatisAnnotation.class,
											UserDaoImplMyBatisMapperInterfaceAnnotation.class
										  }
										)
			  )
@MapperScan(basePackages = "com.itwill.user.mapper2",annotationClass = MyMapper.class)
public class UserDaoImplMyBatisMapperInterfaceAnnotation2Config {
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
	
	
}
