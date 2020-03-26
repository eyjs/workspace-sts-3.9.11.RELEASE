package com.itwill.guest.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

/*
  AutoScan이 되어야 하는 컴포넌트 클래스들 -
  대표적으로 @Controller, @Service, @Repository, @Component등-의 위치가
  메인클래스가 위치한 패키지보다 상위 패키지에 있거나,
  하위가 아닌 다른 패키지에 있는 경우, 스캔이 되지 않는다. 
  이 설정도 임의의 패키지로 스캔이 되도록 따로 지정할 수 있다.
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.itwill.guest")
@MapperScan(basePackages = "com.itwill.guest.mapper")
public class GuestBootApplication {
	public static void main(String[] args) {
		SpringApplication.run(GuestBootApplication.class, args);
	}

}
