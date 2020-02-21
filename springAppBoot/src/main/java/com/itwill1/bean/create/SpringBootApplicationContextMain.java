package com.itwill1.bean.create;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
@SpringBootApplication
public class SpringBootApplicationContextMain {
	public static void main(String[] args) {
		System.out.println("------------Spring Container 초기화시작---------");
		ApplicationContext applicationContext=SpringApplication.run(SpringBootApplicationContextMain.class);
		System.out.println("------------Spring Container 초기화끝---------");
		CreateBean1 cb1=
				(CreateBean1)applicationContext.getBean("createBean1");
		cb1.method1();
		

	}

}
