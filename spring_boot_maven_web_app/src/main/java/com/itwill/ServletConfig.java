package com.itwill;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
/*
mvc-config.xml을 대신할 java 클래스
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:mvc="http://www.springframework.org/schema/mvc"
	xmlns:context="http://www.springframework.org/schema/context"
	xmlns:aop="http://www.springframework.org/schema/aop"
	xsi:schemaLocation="http://www.springframework.org/schema/mvc https://www.springframework.org/schema/mvc/spring-mvc.xsd
		http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-4.3.xsd
		http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context.xsd
		http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop-4.3.xsd">
	<context:annotation-config/>
	<context:component-scan 
		base-package="com.itwill.controller.annotation"/>
	<mvc:annotation-driven/>
	<!-- Controller객체를 Spring Container에등록 -->
	<bean 	id="helloController" 
			class="com.itwill.controller.HelloController"/>
	
	<!-- Controller객체를 Mapping해줄객체를 SpringContainer에등록 -->
	<bean id="handlerMapping" 
	class="org.springframework.web.servlet.handler.SimpleUrlHandlerMapping">
		<property name="mappings">
			<props>
				<prop key="/hello.do">helloController</prop>
			</props>
		</property>
	</bean>
	<!-- View객체등록[XMLView] -->
	<bean id="xmlView" class="com.itwill.controller.annotation.XMLView"/>
	
	<!-- ViewResolver1 -->
	<bean 
		class="org.springframework.web.servlet.view.BeanNameViewResolver">
		<property name="order" value="0"/>
	</bean>
	
	<!-- ViewResolver2 -->
	<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		<property name="order" value="1"/>
		
		<property name="prefix" value="/WEB-INF/views/"/>
		<property name="suffix" value=".jsp"/>
		
	</bean>
</beans>
*/
@Configuration
public class ServletConfig implements WebMvcConfigurer {
	
    @Override
    public void configureViewResolvers(ViewResolverRegistry viewResolverRegistry) {
    	BeanNameViewResolver bean1=new BeanNameViewResolver();
    	bean1.setOrder(0);
    	
    	InternalResourceViewResolver bean2 = new InternalResourceViewResolver();
    	bean2.setPrefix("/WEB-INF/view/");
    	bean2.setSuffix(".jsp");
    	bean2.setViewClass(JstlView.class);
        bean2.setOrder(1);
        
        viewResolverRegistry.viewResolver(bean1);
        viewResolverRegistry.viewResolver(bean2);
    }
    
	
}
