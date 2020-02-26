package com.itwill1.bean.attr;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class RootConfig {
	
	@Bean(initMethod = "myInit",destroyMethod = "myDestroy")
	public InitDestroyBean initDestroyBean() {
		return new InitDestroyBean();
	}
	@Bean
	@Lazy
	public LazyInitBean lazyInitBean() {
		return new LazyInitBean();
	}
}
