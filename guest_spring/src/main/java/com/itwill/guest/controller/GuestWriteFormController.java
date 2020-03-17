package com.itwill.guest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
public class GuestWriteFormController implements Controller {
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath="";
		forwardPath="forward:/WEB-INF/views/guest_write_form.jsp";
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName(forwardPath);
		return modelAndView;
	}

}
