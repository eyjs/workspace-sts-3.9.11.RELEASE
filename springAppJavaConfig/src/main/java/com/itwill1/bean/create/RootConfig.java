package com.itwill1.bean.create;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class RootConfig {
	@Bean
	public CreateBean1 createBean1() {
		return new CreateBean1();
	}
	@Bean
	public CreateBean2 createBean2() {
		return new CreateBean2();
	}
	@Bean
	public CreateBean3 createBean3() {
		return new CreateBean3();
	}
	@Bean
	public CreateBean4 createBean4() {
		return new CreateBean4();
	}
	
}
