package com.itwill.guest.boot;



import java.util.List;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
/*
mvc-config.xml을 대신할 java 클래스
 - @EnableWebMvc: web mvc을 이용하는데 있어서 spring container가 가져야할 기본적인 bean component 등록. 
    빠르고 편하게 mvc을 구축할수 있는 configuration 환경 제공
 - WebMvcConfigurationSupport 클래스가 자동으로 Bean 등록된다. Mvc Java Config 설정에서 설정을 제공하는 주요 클래스
 - Web에 필요한 Bean들을 대부분 자동으로 설정해준다.
 - WebMvcConfigurer 인터페이스: 기본 설정 이외의 설정이 필요할 경우 해당 클래스 상속 받은 후 오버라이딩하여 구현.
 - @ComponentScan: Controller, Service, Repository, Component 어노테이션이 붙을 클래스를 찾아 스프링 컨테이너가 관리
*/
//@EnableWebMvc
@Configuration
public class ServletConfig implements  WebMvcConfigurer, WebMvcRegistrations {
	
    public void addViewControllers(ViewControllerRegistry viewControllerRegistry) {
    	viewControllerRegistry.addViewController("/").setViewName("redirect:guest_main.do");
    	//viewControllerRegistry.addViewController("/").setViewName("forward:index.jsp");
    	//viewControllerRegistry.addRedirectViewController("/", "/index.jsp");
    	//viewControllerRegistry.addStatusController("/user_remove", HttpStatus.BAD_REQUEST);    
    }
	
	
	

}
