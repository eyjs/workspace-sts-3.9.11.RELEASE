package com.itwill.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwill.summer.Controller;

public class UserLogoutActionController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse arg1) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		session.invalidate();
		String forwardPath="redirect:user_main.do";
		return forwardPath;
	}

}
