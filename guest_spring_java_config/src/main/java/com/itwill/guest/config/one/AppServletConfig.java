package com.itwill.guest.config.one;

import org.springframework.context.annotation.Configuration;
/**
 * Spring 관련 컴포넌트가 아닌 서비스에서 소비하는 컴포넌트에 대한 설정
 */
//@Configuration
public class AppServletConfig {
    // Controller Logging Aspect
	/*
    @Bean
    public ControllerLoggingAspect controllerLoggingAspect() {
        return new ControllerLoggingAspect();
    }
    */
    /** MappingJackson ObjectMapper override */
	/*
	@Bean(name="objectMapper")
    public ObjectMapper objectMapper() {
        return null;
    }
    */
	
    /** MappingJackson XmlMapper override */
    /*
	@Bean(name="xmlMapper")
    public ObjectMapper xmlMapper() {
        return null;
    }
    */
    // - Cache 설정 가능 (ehCache)
    // - JsonMaker 설정 가능(Gson등)
    // - TCP Connection beans, factory 설정 가능 
	//    (커넥션 풀 사이즈 설정, 연결풀 팩토리 설정, 기본 연결 정보 설정, 연결풀 객체 생성 등)   
}
