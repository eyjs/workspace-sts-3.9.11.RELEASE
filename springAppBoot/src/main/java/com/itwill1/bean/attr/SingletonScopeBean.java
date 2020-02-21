package com.itwill1.bean.attr;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class SingletonScopeBean {
	public SingletonScopeBean() {
		System.out.println("### SingletonScopeBean()생성자:"+this);
	}
}
