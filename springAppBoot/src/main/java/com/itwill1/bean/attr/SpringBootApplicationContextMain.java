package com.itwill1.bean.attr;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
@SpringBootApplication
public class SpringBootApplicationContextMain {

	public static void main(String[] args) throws Exception{
		System.out.println("------------Spring Container 초기화시작---------");
		ApplicationContext applicationContext=SpringApplication.run(SpringBootApplicationContextMain.class, args);
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
				(SingletonScopeBean)applicationContext.getBean("singletonScopeBean");
		SingletonScopeBean singletonBean2=
				(SingletonScopeBean)applicationContext.getBean("singletonScopeBean");
		SingletonScopeBean singletonBean3=
				(SingletonScopeBean)applicationContext.getBean("singletonScopeBean");
		System.out.println("### "+singletonBean1);
		System.out.println("### "+singletonBean2);
		System.out.println("### "+singletonBean3);
		System.out.println("--------- 3.scope(prototype) ------------");
		PrototypeScopeBean prototypeBean1=
				(PrototypeScopeBean)applicationContext.getBean("prototypeScopeBean");
		PrototypeScopeBean prototypeBean2=
				(PrototypeScopeBean)applicationContext.getBean("prototypeScopeBean");
		PrototypeScopeBean prototypeBean3=
				(PrototypeScopeBean)applicationContext.getBean("prototypeScopeBean");
		System.out.println("### "+prototypeBean1);
		System.out.println("### "+prototypeBean2);
		System.out.println("### "+prototypeBean3);
		DisposableBean context=(DisposableBean)applicationContext;
		context.destroy();

	}

}
