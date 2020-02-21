package com.itwill1.bean.create;

import org.springframework.stereotype.Component;

@Component("createBean2")
public class CreateBean2 {
	public CreateBean2() {
		System.out.println("### CreateBean2() 디폴트생성자");
	}
	public void method1() {
		System.out.println("### CreateBean2.method1()호출");
	}
}
