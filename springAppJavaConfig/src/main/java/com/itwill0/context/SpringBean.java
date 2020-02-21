package com.itwill0.context;

import org.springframework.stereotype.Component;

@Component
public class SpringBean {
	public SpringBean() {
		System.out.println("### SpringBean()생성자");
	}
}
