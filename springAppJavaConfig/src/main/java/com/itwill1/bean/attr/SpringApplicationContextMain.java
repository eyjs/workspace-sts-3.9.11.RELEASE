package com.itwill1.bean.attr;


import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApplicationContextMain {

	public static void main(String[] args) throws Exception{
		/*
		 * ApplicationContext[BeanFactory]객체생성
		 *  - Spring Container객체생성
		 */
		System.out.println("-------------Spring Container초기화시작--------");
		ApplicationContext applicationContext=
				new ClassPathXmlApplicationContext(
						"com/itwill1/bean/attr/1.bean_attr.xml");
		System.out.println("-------------Spring Container초기화끝----------");
		LazyInitBean lazyInitBean=
				(LazyInitBean)applicationContext.getBean("lazyInitBean");
		System.out.println("### "+lazyInitBean);
		
		
		DisposableBean context =(DisposableBean)applicationContext;
		context.destroy();
		
		
	}

}
