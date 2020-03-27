package com.itwill;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.itwill.service.HelloService;

@SpringBootApplication
@ComponentScan(basePackages = "com.itwill")
public class SpringBootMavenAppApplication {

	public static void main(String[] args) throws Exception{
		ApplicationContext applicationContext=
				SpringApplication.run(SpringBootMavenAppApplication.class, args);
		System.out.println("1."+applicationContext);
		HelloService helloService = applicationContext.getBean(HelloService.class);
		System.out.println("2."+helloService);
		System.out.println("3."+helloService.helloService());
		
	}

}
