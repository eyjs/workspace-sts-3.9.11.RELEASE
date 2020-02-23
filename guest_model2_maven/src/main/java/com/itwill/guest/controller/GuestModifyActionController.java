package com.itwill.guest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;
import com.itwill.summer.Controller;
public class GuestModifyActionController implements Controller {
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath="";
		if(request.getMethod().equalsIgnoreCase("GET")) {
			forwardPath = "redirect:guest_main.do";
		}else {
			try {
				String guest_noStr = request.getParameter("guest_no");
				String guest_name = request.getParameter("guest_name");
				String guest_email = request.getParameter("guest_email");
				String guest_homepage = request.getParameter("guest_homepage");
				String guest_title = request.getParameter("guest_title");
				String guest_content = request.getParameter("guest_content");
				GuestService guestService = new GuestService();
				Guest updateGuest = new Guest(Integer.parseInt(guest_noStr), guest_name, "", guest_email, guest_homepage,
						guest_title, guest_content);
				boolean updateOK = guestService.updateGuest(updateGuest);
				if (updateOK) {
					//response.sendRedirect("guest_view.jsp?guest_no=" + guest_noStr);
					forwardPath="redirect:guest_view.do?guest_no="+guest_noStr;
					//forwardPath="forward:guest_view.do";
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
