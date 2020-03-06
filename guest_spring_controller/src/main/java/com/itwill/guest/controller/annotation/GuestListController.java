package com.itwill.guest.controller.annotation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestDao;
import com.itwill.guest.GuestService;
//@Controller
public class GuestListController {
	@Autowired
	private GuestService guestService;
	public GuestListController() {
		System.out.println("### GuestListController() 기본생성자");
	}
	@RequestMapping("/guest_list.do")
	public String guest_list(Model model) {
		String forwardPath = "";
		try {
			List<Guest> guestList = guestService.selectAll();
			model.addAttribute("guestList", guestList);
			forwardPath = "forward:/WEB-INF/views/guest_list.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("MSG", e.getMessage());
			forwardPath = "forward:/WEB-INF/views/guest_eror.jsp";
		}
		return forwardPath;
	}

}
