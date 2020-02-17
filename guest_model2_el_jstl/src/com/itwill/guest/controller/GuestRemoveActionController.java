package com.itwill.guest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.guest.GuestService;
import com.itwill.summer.Controller;

public class GuestRemoveActionController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath="";
		
		if(request.getMethod().equalsIgnoreCase("GET")) {
			forwardPath = "redirect:guest_main.do";
		}else {
			try {
				String guest_noStr2 = request.getParameter("guest_no");
				GuestService guestService = new GuestService();
				boolean insertOK = guestService.deleteGuest(Integer.parseInt(guest_noStr2));
				if (insertOK) {
					//response.sendRedirect("guest_list.jsp");
					forwardPath="redirect:guest_list.do";
				} else {
					//response.sendRedirect("guest_error.jsp");
					forwardPath="forward:/WEB-INF/views/guest_error.jsp";
				}
			}catch (Exception e) {
				e.printStackTrace();
				forwardPath="forward:/WEB-INF/views/guest_error.jsp";
			}
		}
		return forwardPath;
	}

}
