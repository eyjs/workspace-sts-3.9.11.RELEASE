package com.itwill0.context;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*
 * 0.applicationContext-annotation.xml
 */
@Configuration
/*
 <context:component-scan base-package="com.itwill0.context"/>
 */
@ComponentScan(basePackages = { "com.itwill0.context" })
public class RootConfigAnnotation {
}
