package com.itwill.controller.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class RequestMappingUserController {
	@RequestMapping("/list.do")
	public String list() {
		return "/WEB-INF/views/user/list.jsp";
	}
	@RequestMapping("/view.do")
	public String view() {
		return "/WEB-INF/views/user/view.jsp";
	}
	
	//@RequestMapping("/user/list.do")
	public String list1() {
		return "/WEB-INF/views/user/list.jsp";
	}
	//@RequestMapping("/user/view.do")
	public String view1() {
		return "/WEB-INF/views/user/view.jsp";
	}
}
