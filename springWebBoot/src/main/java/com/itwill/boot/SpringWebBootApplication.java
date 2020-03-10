package com.itwill.boot;

import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;

import com.itwill.controller.HelloController;

/*
  AutoScan이 되어야 하는 컴포넌트 클래스들 -
  대표적으로 @Controller, @Service, @Repository, @Component등-의 위치가
  메인클래스가 위치한 패키지보다 상위 패키지에 있거나,
  하위가 아닌 다른 패키지에 있는 경우, 스캔이 되지 않는다. 
  이 설정도 임의의 패키지로 스캔이 되도록 따로 지정할 수 있다.
 */
@SpringBootApplication
//@ServletComponentScan
@ComponentScan(basePackages = "com.itwill")
public class SpringWebBootApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringWebBootApplication.class, args);
	}

	@Bean
	public HelloController helloController() {
		return new HelloController();
	}
	
	@Bean
	public SimpleUrlHandlerMapping sampleServletMapping() {
		SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
		mapping.setOrder(Integer.MAX_VALUE - 2);
		Properties urlProperties = new Properties();
		urlProperties.put("/hello.do", "helloController");
		mapping.setMappings(urlProperties);
		return mapping;
	}
	
}
