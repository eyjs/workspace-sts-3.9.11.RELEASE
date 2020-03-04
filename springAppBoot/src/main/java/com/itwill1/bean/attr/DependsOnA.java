package com.itwill1.bean.attr;

import org.springframework.stereotype.Component;

@Component
public class DependsOnA {
	public DependsOnA() {
		System.out.println("### DependsOnA()생성자");
	}
}
