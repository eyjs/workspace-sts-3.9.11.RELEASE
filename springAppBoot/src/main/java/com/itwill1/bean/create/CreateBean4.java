package com.itwill1.bean.create;

import org.springframework.stereotype.Component;

@Component("createBean4")
public class CreateBean4 {
	public CreateBean4() {
		System.out.println("### CreateBean4() 디폴트생성자");
	}
	public void method1() {
		System.out.println("### CreateBean4.method1()호출");
	}
}
