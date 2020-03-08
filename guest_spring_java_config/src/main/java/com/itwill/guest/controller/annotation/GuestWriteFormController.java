package com.itwill.guest.controller.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 클라이언트의 요청에따른업무실행클래스
 */
//@Controller
public class GuestWriteFormController{
	@RequestMapping(value="/guest_write_form.do")
	public String guest_write(){
		String forwardPath="forward:/WEB-INF/views/guest_write_form.jsp";
		return forwardPath;
		
	}
}
