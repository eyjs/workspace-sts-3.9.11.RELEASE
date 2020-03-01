package com.itwill1.bean.attr;


import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class SpringApplicationContextRootConfigMain {

	public static void main(String[] args) throws Exception{
		/*
		 * ApplicationContext[BeanFactory]객체생성
		 *  - Spring Container객체생성
		 */
		System.out.println("-------------Spring Container초기화시작--------");
		ApplicationContext applicationContext=
				new AnnotationConfigApplicationContext(RootConfig.class);
		
		System.out.println("-------------Spring Container초기화끝----------");
		
		System.out.println("-------------- 1.lazyInit------------------");
		LazyInitBean lazyInitBean=
				(LazyInitBean)applicationContext.getBean("lazyInitBean");
		System.out.println("### "+lazyInitBean);
		
		System.out.println("-------------- 2.scope(singleton) ------------------");
		SingletonScopeBean singletonScopeBean1= 
				(SingletonScopeBean)applicationContext.getBean("singletonBean");
		SingletonScopeBean singletonScopeBean2= 
				(SingletonScopeBean)applicationContext.getBean("singletonBean");
		System.out.println("### "+singletonScopeBean1);
		System.out.println("### "+singletonScopeBean2);
		System.out.println("-------------- 2.scope(prototype) ------------------");
		PrototypeScopeBean prototypeScopeBean1=(PrototypeScopeBean)
				applicationContext.getBean("prototypeBean");
		PrototypeScopeBean prototypeScopeBean2=(PrototypeScopeBean)
				applicationContext.getBean("prototypeBean");
		System.out.println("### "+prototypeScopeBean1);
		System.out.println("### "+prototypeScopeBean2);
		
		DisposableBean context =(DisposableBean)applicationContext;
		context.destroy();
		
		
	}

}
