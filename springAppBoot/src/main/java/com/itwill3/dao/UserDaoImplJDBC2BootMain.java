package com.itwill3.dao;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ComponentScan.Filter;

import com.itwill.user.UserDao;
import com.itwill.user.annotation.UserDaoImplAnnotation;
import com.itwill.user.annotation.UserDaoImplJDBC2Annotation;
import com.itwill.user.annotation.UserDaoImplJDBCAnnotation;
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
								 UserDaoImplJDBC2Annotation.class
								 */
								 UserDaoImplJdbcTemplateAnnotation.class,
								 UserDaoImplMyBatisAnnotation.class,
								 UserDaoImplMyBatisMapperInterfaceAnnotation.class,
								 UserDaoImplMyBatisMapperInterfaceAnnotation2.class
						  }
						)
)
public class UserDaoImplJDBC2BootMain {
	public static void main(String[] args) throws Exception{
		System.out.println("------------Spring Container 초기화시작---------");
		ApplicationContext applicationContext=
				SpringApplication.run(UserDaoImplJDBC2BootMain.class);
		System.out.println("------------Spring Container 초기화끝---------");
		UserDao userDao=(UserDao)applicationContext.getBean("userDaoJDBC2");
		System.out.println("### "+userDao.findUser("a"));
		System.out.println("### "+userDao.findUserList());
	}
}









