package com.itwill0.context;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootApplicationContextMain {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(SpringBootApplicationContextMain.class, args);
		System.out.println(ctx);
	}

}
