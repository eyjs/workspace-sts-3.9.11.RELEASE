package com.itwill1.bean.attr;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class PrototypeScopeBean {
	public PrototypeScopeBean() {
		System.out.println("### PrototypeScopeBean()생성자");
	}
}
