package com.itwill0.log;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringApplicationContextMain {

	public static void main(String[] args) throws Exception{
		/*
		 * ApplicationContext[BeanFactory]객체생성
		 *  - Spring Container객체생성
		 */
		System.out.println("-------------Spring Container초기화시작--------");
		ApplicationContext applicationContext=
				new AnnotationConfigApplicationContext(RootConfig.class);
		System.out.println("-------------Spring Container초기화끝----------");
		HelloWorldLog4J helloWorldLog4J=
				applicationContext.getBean(HelloWorldLog4J.class);
		helloWorldLog4J.hello("KIM");
		helloWorldLog4J.hello("LEE");
	}

}
