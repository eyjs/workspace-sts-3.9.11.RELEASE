package com.itwill3.dao;
import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
@SpringBootApplication

@ComponentScan(basePackages ="com.itwill3.dao" ,
			   excludeFilters   = {
					   			   @Filter(type = FilterType.ASPECTJ,pattern = "*..*BootMain"),
					   			   @Filter(type = FilterType.ANNOTATION, classes = {SpringBootApplication.class,Configuration.class} )
			   					  }
			  )
			  
public class SpringDataSourceBootMain {

	public static void main(String[] args) throws Exception{
		/*
		 * ApplicationContext[BeanFactory]객체생성
		 *  - Spring Container객체생성
		 */
		System.out.println("------------Spring Container 초기화시작---------");
		ApplicationContext applicationContext=
				SpringApplication.run(SpringDataSourceBootMain.class);
		System.out.println("------------Spring Container 초기화끝---------");
		DataSource dataSource=
				(DataSource)applicationContext.getBean(DataSource.class);
		Connection con = dataSource.getConnection();
		System.out.println("### dataSource:"+dataSource);
		System.out.println("### dataSource Connection:"+con);
		/*
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
		*/
		
	}
}









