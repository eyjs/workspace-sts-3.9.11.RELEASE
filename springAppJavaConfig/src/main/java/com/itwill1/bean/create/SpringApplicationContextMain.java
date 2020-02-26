package com.itwill1.bean.create;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class SpringApplicationContextMain {

	public static void main(String[] args) {
		/*
		 * ApplicationContext[BeanFactory]객체생성
		 *  - Spring Container객체생성
		 */
		System.out.println("-------------Spring Container초기화시작--------");
		ApplicationContext applicationContext=
				new AnnotationConfigApplicationContext(RootConfig.class);
		System.out.println("-------------Spring Container초기화끝----------");
		CreateBean1 createBean1=
				(CreateBean1)applicationContext.getBean("createBean1");
		createBean1.method1();
		CreateBean2 createBean2=
				(CreateBean2)applicationContext.getBean(CreateBean2.class);
		createBean2.method1();
		
	}

}
