package com.itwill.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.itwill")
public class UserSpringBootMavenApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserSpringBootMavenApplication.class, args);
	}

}
