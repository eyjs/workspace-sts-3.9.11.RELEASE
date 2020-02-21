package com.itwill1.bean.attr;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class InitDestroyBean {
	public InitDestroyBean() {
		System.out.println("### InitDestroyBean()생성자");
	}
	@PostConstruct
	public void myInit() {
		System.out.println("### InitDestroyBean.myInit()메쏘드호출");
	}
	@PreDestroy
	public void myDestroy() {
		System.out.println("### InitDestroyBean.myDestroy()메쏘드호출");
	}
}
