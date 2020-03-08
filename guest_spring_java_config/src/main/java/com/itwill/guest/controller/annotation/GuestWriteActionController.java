package com.itwill.guest.controller.annotation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestDao;
import com.itwill.guest.GuestService;

//@Controller
public class GuestWriteActionController {
	@Autowired
	private GuestService guestService;
	@RequestMapping(value="/guest_write_action.do",method=RequestMethod.GET)
	public String guest_write_action_get() {
		String forwardPath = "redirect:guest_main.do";
		return forwardPath;
	}
	
	@RequestMapping(value="/guest_write_action.do",method=RequestMethod.POST)
	public String guest_write_action(@ModelAttribute Guest guest ,Model model) {
		String forwardPath = "";
		try {
			//GuestDao guestDao = new GuestDao();
			boolean insertOK = guestService.insertGuest(guest);
			if (insertOK) {
				forwardPath = "redirect:guest_list.do";
			} else {
				model.addAttribute("MSG", "쓰기실패!!!");
				forwardPath = "guest_error";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("MSG", "잘모르는실패!!!");
			forwardPath = "forward:/WEB-INF/views/guest_error.jsp";
		}
		return forwardPath;
	}

}
