package com.itwill.guest.controller.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/*
 클라이언트의 요청에따른업무실행클래스
 */
//@Controller
public class GuestMainController  {
	
	public GuestMainController() {
		System.out.println("### GuestMainController 기본생성자!!!");
	}
	@RequestMapping("/guest_main.do")
	public String guest_main(){
		return "forward:/WEB-INF/views/guest_main.jsp";
		
	}
}
