package com.itwill1.bean.attr;

import org.springframework.stereotype.Component;

@Component("singletonScopeBean")
public class SingletonScopeBean {
	public SingletonScopeBean() {
		System.out.println("### SingletonScopeBean()생성자");
	}
}
