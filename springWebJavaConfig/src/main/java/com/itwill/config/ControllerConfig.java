package com.itwill.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;

import com.itwill.controller.HelloController;
import com.itwill.controller.annotation.XMLView;

@Configuration
public class ControllerConfig {
	
	@Bean("xmlView") 
	public XMLView xmlView() {
		return new XMLView();
	}
	
	@Bean
	public SimpleUrlHandlerMapping sampleServletMapping() {
		SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
		Properties urlProperties = new Properties();
		urlProperties.put("/hello.do", "helloController");
		mapping.setMappings(urlProperties);
		return mapping;
	}
	@Bean
	public HelloController helloController() {
		return new HelloController();
	}
}
