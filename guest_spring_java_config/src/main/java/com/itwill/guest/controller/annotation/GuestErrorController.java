package com.itwill.guest.controller.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


//@Controller
public class GuestErrorController {

	@RequestMapping("/guest_error.do")
	public String guest_error() {
		String forwardPath="forward:/WEB-INF/views/guest_error.jsp";
		return forwardPath;
	}

}
