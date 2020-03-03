package com.itwill.controller.annotation;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloAnnotationController2 {
	public HelloAnnotationController2() {
		System.out.println("### HelloAnnotationController2() 생성자");
	}
	@RequestMapping("/hello2.do")
	public String hello2(HttpServletRequest request) {
		System.out.println("### HelloAnnotationController2.hello2()메쏘드 호출");
		request.setAttribute("msg", "안녕HelloAnnotationController2");
		return "forward:/WEB-INF/views/hello2.jsp";
	}
	
	
}
