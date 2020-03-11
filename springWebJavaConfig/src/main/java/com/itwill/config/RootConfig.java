package com.itwill.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/*
application-config.xml을 대신할 java 클래스
 */
import org.springframework.context.support.ResourceBundleMessageSource;

import com.itwill.service.UserService;
@Configuration
public class RootConfig {
	@Bean
    public UserService userService() {
    	UserService userService = new UserService();
    	userService.setMessageSource(messageSource());
    	return userService;
    }
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource=new ResourceBundleMessageSource();
		messageSource.setBasenames("messages/guest","messages/messages","messages/user");
		return messageSource;
	}
	
}
