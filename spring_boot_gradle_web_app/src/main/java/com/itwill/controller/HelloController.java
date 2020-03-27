package com.itwill.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.domain.Hello;
import com.itwill.service.HelloService;

@Controller
public class HelloController {
	@Autowired
	private HelloService helloService;
	
	public HelloController() {
		System.out.println("### HelloController()생성자");
	}
	@RequestMapping("/hello")
	public String hello(Model model) throws Exception{
		List<Hello> helloList=helloService.helloService();
		model.addAttribute("helloList", helloList);
		return "hello";
	}
	
}











