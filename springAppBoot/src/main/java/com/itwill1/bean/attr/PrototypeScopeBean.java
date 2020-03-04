package com.itwill1.bean.attr;

import org.springframework.stereotype.Component;

@Component("prototypeScopeBean")
public class PrototypeScopeBean {
	public PrototypeScopeBean() {
		System.out.println("### PrototypeScopeBean()생성자");
	}
}
