package com.itwill.controller.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class HelloAnnotationMultiRequestMappaingController {
	@RequestMapping("/hello3.do")
	public String hello3() {
		return "forward:/WEB-INF/views/hello3.jsp";
	}
	@RequestMapping("/hello4.do")
	public String hello4() {
		return "forward:/WEB-INF/views/hello4.jsp";
	}
	@RequestMapping("/hello5.do")
	public String hello5() {
		return "forward:/WEB-INF/views/hello5.jsp";
	}
	@RequestMapping("hello_redirect_jsp.do")
	public String hello_redirect_jsp() {
		return "redirect:hello_redirected.jsp";
	}
	/*
	 * servlet ---forward--> servlet
	 */
	@RequestMapping("/hello_servlet_forward.do")
	public String hello_servlet_forward() {
		return "forward:hello_servlet_forwarded.do";
	}
	@RequestMapping("/hello_servlet_forwarded.do")
	public String hello_servlet_forwarded() {
		return "forward:/WEB-INF/views/hello_servlet_forwarded.jsp";
	}
	/*
	 * servlet --redirect-->servlet
	 */
	@RequestMapping("/hello_redirect_servlet.do")
	public String hello_redirect_servlet() {
		return "redirect:hello_redirected_servlet.do";
	}
	@RequestMapping("/hello_redirected_servlet.do")
	public String hello_redirected_servlet() {
		return "forward:/WEB-INF/views/hello_redirected_servlet.jsp";
	}
	
	
}












