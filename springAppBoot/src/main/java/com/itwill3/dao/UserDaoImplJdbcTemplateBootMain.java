package com.itwill3.dao;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.user.UserDao;
import com.itwill.user.annotation.UserDaoImplJDBC2Annotation;
import com.itwill.user.annotation.UserDaoImplJdbcTemplateAnnotation;
import com.itwill.user.annotation.UserDaoImplMyBatisAnnotation;
import com.itwill.user.annotation.UserDaoImplMyBatisMapperInterfaceAnnotation;
import com.itwill.user.annotation.UserDaoImplMyBatisMapperInterfaceAnnotation2;
@SpringBootApplication
@ComponentScan(	basePackages = {"com.itwill.user.annotation"},
excludeFilters = @Filter(type = FilterType.ASSIGNABLE_TYPE,
						 classes = {
								 /*
								 UserDaoImplAnnotation.class,
								 UserDaoImplJDBCAnnotation.class,
								 UserDaoImplJdbcTemplateAnnotation.class,
								 */
								 UserDaoImplJDBC2Annotation.class,
								 UserDaoImplMyBatisAnnotation.class,
								 UserDaoImplMyBatisMapperInterfaceAnnotation.class,
								 UserDaoImplMyBatisMapperInterfaceAnnotation2.class
						  }
						)
)
public class UserDaoImplJdbcTemplateBootMain {

	public static void main(String[] args) throws Exception{
		System.out.println("------------Spring Container 초기화시작---------");
		ApplicationContext applicationContext=
				SpringApplication.run(UserDaoImplJdbcTemplateBootMain.class);
		System.out.println("------------Spring Container 초기화끝---------");
		UserDao userDao=
				(UserDao)applicationContext.getBean("userDaoJdbcTemplate");
		System.out.println("### "+userDao.findUser("a"));
		System.out.println("### "+userDao.findUserList());
		
	}
}









