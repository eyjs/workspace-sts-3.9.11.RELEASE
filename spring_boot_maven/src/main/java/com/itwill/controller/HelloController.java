package com.itwill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	public HelloController() {
		System.out.println("###HelloController()생성자");
	}
	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}
}
