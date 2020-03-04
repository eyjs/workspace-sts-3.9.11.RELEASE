package com.itwill1.bean.attr;

import org.springframework.stereotype.Component;

@Component
public class LazyInitBean {
	public LazyInitBean() {
		System.out.println("### LazyInitBean()생성자");
	}
}
