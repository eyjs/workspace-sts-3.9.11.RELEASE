package com.itwill.guest.controller.annotation;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;

@Controller
public class GuestController {
	@Autowired
	private GuestService guestService;
	
	@RequestMapping("/guest_main.do")
	public String guest_main() {
		return "/WEB-INF/views/guest_main.jsp";
	}
	@RequestMapping("/guest_list.do")
	public String guest_list(HttpServletRequest request ) {
		String forwardPath="";
		try {
			List<Guest> guestList=guestService.selectAll();
			request.setAttribute("guestList", guestList);
			forwardPath = "forward:/WEB-INF/views/guest_list.jsp";
			
		}catch (Exception e) {
			request.setAttribute("error_msg", e.getMessage());
			forwardPath = "forward:/WEB-INF/views/guest_error.jsp";
		}
		return "/WEB-INF/views/guest_list.jsp";
	}
	
	
}
