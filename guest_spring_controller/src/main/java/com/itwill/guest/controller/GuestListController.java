package com.itwill.guest.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;


public class GuestListController implements Controller{
	
	public ModelAndView handleRequest(HttpServletRequest request,HttpServletResponse response) {
		String forwardPath="";
		ModelAndView mv=new ModelAndView();
		try {
			GuestService guestService=new GuestService();
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
