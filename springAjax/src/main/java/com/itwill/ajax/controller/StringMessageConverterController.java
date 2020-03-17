package com.itwill.ajax.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StringMessageConverterController {
	@ResponseBody
	@RequestMapping(value = "/response_string1",
					produces = "text/plain;charset=UTF-8")
	public String responseString1() {
		return "hello string ajax[한글]";
	}
	@ResponseBody
	@RequestMapping(value = "/response_string2",
					produces = "text/html;charset=UTF-8")
	public String responseString2() {
		return "<h1>hello spring ajax[한글]</h1>";
	}
	
	
}
