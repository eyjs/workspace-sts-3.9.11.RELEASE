package com.itwill.guest.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;
import com.itwill.guest.GuestServiceImpl;

public class GuestViewController implements Controller{
	private GuestService guestService;
	public GuestViewController() {
		System.out.println("### GuestViewController()생성자 호출");
	}
	public void setGuestService(GuestService guestService) {
		System.out.println("### GuestViewController : setGuestService("+guestService+") 메쏘드 호출");
		this.guestService = guestService;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath="";
		ModelAndView mv=new ModelAndView();
		String guest_noStr1 = request.getParameter("guest_no");
		if(guest_noStr1==null||guest_noStr1.equals("")){
			//response.sendRedirect("guest_main.jsp");
			forwardPath="redirect:guest_main.do";
		}else {
			try {
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
		mv.setViewName(forwardPath);
		return mv;
	}

}
