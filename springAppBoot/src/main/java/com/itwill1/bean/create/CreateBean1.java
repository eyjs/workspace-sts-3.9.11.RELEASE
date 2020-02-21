package com.itwill1.bean.create;

import org.springframework.stereotype.Component;

@Component("createBean1")
public class CreateBean1 {
	public CreateBean1() {
		System.out.println("### CreateBean1() 디폴트생성자");
	}
	public void method1() {
		System.out.println("### CreateBean1.method1()호출");
	}
}
