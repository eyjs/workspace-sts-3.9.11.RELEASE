package com.itwill;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.itwill")
public class SpringWebBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebBootApplication.class, args);
	}
	
}
