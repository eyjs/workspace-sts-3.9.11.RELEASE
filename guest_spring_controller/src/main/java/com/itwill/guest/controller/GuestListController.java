package com.itwill.guest.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;
import com.itwill.guest.GuestServiceImpl;


public class GuestListController implements Controller{
	private GuestService guestService;
	public GuestListController() {
		System.out.println("### GuestListController()생성자 호출");
	}
	public void setGuestService(GuestService guestService) {
		System.out.println("### GuestListController : setGuestService("+guestService+") 메쏘드 호출");
		this.guestService = guestService;
	}


	public ModelAndView handleRequest(HttpServletRequest request,HttpServletResponse response) {
		System.out.println("### GuestListController : handleRequest() 메쏘드 호출");
		String forwardPath="";
		ModelAndView mv=new ModelAndView();
		try {
			List<Guest> guestList=guestService.selectAll();
			request.setAttribute("guestList", guestList);
			forwardPath = "forward:/WEB-INF/views/guest_list.jsp";
			
		}catch (Exception e) {
			request.setAttribute("error_msg", e.getMessage());
			forwardPath = "forward:/WEB-INF/views/guest_error.jsp";
		}
		mv.setViewName(forwardPath);
		return mv;
	}
}
