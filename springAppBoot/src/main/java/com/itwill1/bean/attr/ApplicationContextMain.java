package com.itwill1.bean.attr;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextMain {

	public static void main(String[] args) throws Exception{
		System.out.println("------------Spring Container 초기화시작---------");
		ApplicationContext applicationContext=
				new ClassPathXmlApplicationContext(
		"com/itwill1/bean/attr/1.bean_attr.xml");
		System.out.println("------------Spring Container 초기화끝---------");
		System.out.println("--------- 1.lazyInit --------------");
		LazyInitBean lazyInitBean1=
				(LazyInitBean)applicationContext.getBean("lazyInitBean");
		LazyInitBean lazyInitBean2=
				(LazyInitBean)applicationContext.getBean("lazyInitBean");
		System.out.println("### "+lazyInitBean1);
		System.out.println("### "+lazyInitBean2);
		System.out.println("--------- 2.scope(singleton) ------------");
		SingletonScopeBean singletonBean1=
				(SingletonScopeBean)applicationContext.getBean("singletonBean");
		SingletonScopeBean singletonBean2=
				(SingletonScopeBean)applicationContext.getBean("singletonBean");
		SingletonScopeBean singletonBean3=
				(SingletonScopeBean)applicationContext.getBean("singletonBean");
		System.out.println("### "+singletonBean1);
		System.out.println("### "+singletonBean2);
		System.out.println("### "+singletonBean3);
		System.out.println("--------- 3.scope(prototype) ------------");
		PrototypeScopeBean prototypeBean1=
				(PrototypeScopeBean)applicationContext.getBean("prototypeBean");
		PrototypeScopeBean prototypeBean2=
				(PrototypeScopeBean)applicationContext.getBean("prototypeBean");
		PrototypeScopeBean prototypeBean3=
				(PrototypeScopeBean)applicationContext.getBean("prototypeBean");
		System.out.println("### "+prototypeBean1);
		System.out.println("### "+prototypeBean2);
		System.out.println("### "+prototypeBean3);
		DisposableBean context=(DisposableBean)applicationContext;
		context.destroy();

	}

}
