package com.itwill.guest.controller.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestDao;
import com.itwill.guest.GuestService;

//@Controller
public class GuestViewController {
	@Autowired
	private GuestService guestService;
	@RequestMapping("/guest_view.do")	
	public String guest_view(@RequestParam(value="guest_no",required=false,defaultValue="") String guest_noStr,Model model) {
		String forwardPath="";
		if(guest_noStr==null|| guest_noStr.equals("")){
			forwardPath="redirect:guest_list.do";
		}else{
			try {
				Guest guest=guestService.selectByNo(Integer.parseInt(guest_noStr));
				model.addAttribute("guest",guest);
				forwardPath="forward:/WEB-INF/views/guest_view.jsp";
			} catch (Exception e){
				e.printStackTrace();
				forwardPath="forward:/WEB-INF/views/guest_error.jsp";
			}
		}
		
		return forwardPath;
	}

}
