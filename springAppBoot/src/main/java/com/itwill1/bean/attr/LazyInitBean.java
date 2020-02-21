package com.itwill1.bean.attr;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class LazyInitBean {
	public LazyInitBean() {
		System.out.println("### LazyInitBean()생성자");
	}
	
}
