package com.itwill0.log;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.log4j.Log4j;


@Configuration
public class RootConfig {
	@Bean
	public HelloWorldLog4J helloWorldLog4J() {
		return new HelloWorldLog4J();
	}
}
