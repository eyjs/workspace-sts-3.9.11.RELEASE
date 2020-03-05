package com.itwill.config;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
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
@EnableWebMvc
@Configuration
@ComponentScan
public class ServletConfig implements WebMvcConfigurer {
	
	/*
	@Bean
	public SimpleUrlHandlerMapping sampleServletMapping() {
		SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
		Properties urlProperties = new Properties();
		urlProperties.put("/hello.do", "helloController");
		mapping.setMappings(urlProperties);
		return mapping;
	}
	@Bean
	public HelloController helloController() {
		return new HelloController();
	}
	*/
	/*
    jsp를 view로 사용할 때 사용
    Controller에서 리턴하는 뷰 이름에 접두, 접미어를 붙여서 jsp 경로를 찾는다.
    */
	
	/*
    @Override
    public void configureViewResolvers(ViewResolverRegistry viewResolverRegistry) {
    	BeanNameViewResolver bean1=new BeanNameViewResolver();
    	bean1.setOrder(0);
    	InternalResourceViewResolver bean2 = new InternalResourceViewResolver();
        bean2.setViewClass(JstlView.class);
        bean2.setOrder(1);
        viewResolverRegistry.viewResolver(bean1);
        viewResolverRegistry.viewResolver(bean2);
    }
    */
	
	 @Override
	  public void configureViewResolvers(ViewResolverRegistry viewResolverRegistry) {
	    	BeanNameViewResolver bean1=new BeanNameViewResolver();
	    	bean1.setOrder(0);
	    	
	    	InternalResourceViewResolver bean2 = new InternalResourceViewResolver();
	        bean2.setViewClass(JstlView.class);
	        bean2.setPrefix("/WEB-INF/views/");
	        bean2.setSuffix(".jsp");
	        bean2.setOrder(1);
	        
	        viewResolverRegistry.viewResolver(bean1);
	        viewResolverRegistry.viewResolver(bean2);
	       
	    }

   
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry resourceHandlerRegistry) {
        resourceHandlerRegistry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer pathMatchConfigurer) {
    	
    }
    @Override
	public void  configureContentNegotiation(ContentNegotiationConfigurer contentNegotiationConfigurer) {
    	contentNegotiationConfigurer.defaultContentType(MediaType.APPLICATION_JSON);
    	contentNegotiationConfigurer.favorPathExtension(true);
    	contentNegotiationConfigurer.ignoreAcceptHeader(false);
    	contentNegotiationConfigurer.mediaType("json", MediaType.APPLICATION_JSON);
    	contentNegotiationConfigurer.mediaType("xml", MediaType.APPLICATION_XML);
    	contentNegotiationConfigurer.mediaType("jsonp", new MediaType("application", "x-javascript"));
	}
   

    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer asyncSupportConfigurer) {

    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer defaultServletHandlerConfigurer) {
    	//defaultServletHandlerConfigurer.enable();
    }

    @Override
    public void addFormatters(FormatterRegistry formatterRegistry) {

    }

    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry) {

    }

    @Override
    public void addCorsMappings(CorsRegistry corsRegistry) {

    }
    // '/'로 모든 요청을 받아들이는데 이 요청들을 처리할 url 설정에 대한 코드
    @Override
    public void addViewControllers(ViewControllerRegistry viewControllerRegistry) {
    	
    	viewControllerRegistry.addViewController("/").setViewName("redirect:index.jsp");
    	/*
    	viewControllerRegistry.addViewController("/hello").setViewName("helloworld");
    	viewControllerRegistry.addRedirectViewController("/home", "/hello");
    	viewControllerRegistry.addStatusController("/detail", HttpStatus.BAD_REQUEST);    
    	*/  
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> list) {

    }

    @Override
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> list) {

    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> list) {

    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> list) {

    }

    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> list) {

    }

    @Override
    public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> list) {

    }

    @Override
    public Validator getValidator() {
        return null;
    }

    @Override
    public MessageCodesResolver getMessageCodesResolver() {
        return null;
    }
}
