package com.itwill.guest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;
import com.itwill.summer.Controller;

public class GuestViewController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath="";
		String guest_noStr1 = request.getParameter("guest_no");
		if(guest_noStr1==null||guest_noStr1.equals("")){
			//response.sendRedirect("guest_main.jsp");
			forwardPath="redirect:guest_main.do";
		}else {
			try {
				GuestService guestService=new GuestService();
				Guest guest = guestService.selectByNo(Integer.parseInt(guest_noStr1));
				if(guest==null){
					
					forwardPath="redirect:guest_list.do";
					//forwardPath="forward:guest_list.do";
				}else {
					request.setAttribute("guest", guest);
					forwardPath="forward:/WEB-INF/views/guest_view.jsp";
				}
			}catch (Exception e) {
				e.printStackTrace();
				forwardPath="forward:/WEB-INF/views/guest_error.jsp";
			}
		}
		return forwardPath;
	}

}
