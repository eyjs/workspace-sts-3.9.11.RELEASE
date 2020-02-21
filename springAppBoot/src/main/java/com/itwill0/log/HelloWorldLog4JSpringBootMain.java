package com.itwill0.log;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
@SpringBootApplication
public class HelloWorldLog4JSpringBootMain {
	public static void main(String[] args) {
		ApplicationContext applicationContext=
				SpringApplication.run(HelloWorldLog4JSpringBootMain.class, args);
		HelloWorldLog4J helloWorldLog4J=(HelloWorldLog4J)applicationContext.getBean(HelloWorldLog4J.class);
		String msg1=helloWorldLog4J.hello("KIM");
		String msg2=helloWorldLog4J.hello("LEE");
		System.out.println("###"+msg1);
		System.out.println("###"+msg2);
	}

}
