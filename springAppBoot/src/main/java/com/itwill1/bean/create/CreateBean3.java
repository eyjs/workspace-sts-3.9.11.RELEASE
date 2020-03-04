package com.itwill1.bean.create;

import org.springframework.stereotype.Component;

@Component
public class CreateBean3 {
	public CreateBean3() {
		System.out.println("### CreateBean3()디폴트생성자");
	}
	public void method1() {
		System.out.println("### CreateBean3.method1()호출");
	}
}
