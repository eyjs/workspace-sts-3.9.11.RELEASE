package com.itwill0.context;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ComponentScan
//@ImportResource({"classpath:0.applicationContext.xml"})
public class SpringBootApplicationContextMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext=SpringApplication.run(SpringBootApplicationContextMain.class, args);
		ProductService productService1=
				(ProductService)applicationContext.getBean("productService");
		System.out.println("### "+productService1.productList());
		ProductService productService2=
				(ProductService)applicationContext.getBean("productService");
		System.out.println("### "+productService2.productList());
		if(productService1==productService2) {
			System.out.println(productService1+"=="+productService2);
		}
	}

}
