package com.itwill3.dao;
import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.logging.log4j.core.Filter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
@SpringBootApplication
@ComponentScan(basePackages ="com.itwill3.dao" ,excludeFilters = Filter.ELEMENT_TYPE)
public class SpringBootDataSourceMain {

	public static void main(String[] args) throws Exception{
		/*
		 * ApplicationContext[BeanFactory]객체생성
		 *  - Spring Container객체생성
		 */
		System.out.println("------------Spring Container 초기화시작---------");
		ApplicationContext applicationContext=
				SpringApplication.run(SpringBootDataSourceMain.class);
		System.out.println("------------Spring Container 초기화끝---------");
		DataSource apacheDataSource=
				(DataSource)applicationContext.getBean("apacheDataSource");
		Connection con1 = apacheDataSource.getConnection();
		System.out.println("### apacheDataSource:"+apacheDataSource);
		System.out.println("### apacheDataSource Connection:"+con1);
		DataSource springDataSource=
				(DataSource)applicationContext.getBean("springDataSource");
		Connection con2 = apacheDataSource.getConnection();
		System.out.println("### springDataSource:"+springDataSource);
		System.out.println("### springDataSource Connection:"+con2);
		con1.close();
		con2.close();
		
	}
}









