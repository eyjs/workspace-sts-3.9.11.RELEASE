package com.itwill1.bean.attr;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
@DependsOn(value = "dependsOnA")
public class DependsOnB {
	public DependsOnB() {
		System.out.println("### DependsOnB()생성자");
	}
}
