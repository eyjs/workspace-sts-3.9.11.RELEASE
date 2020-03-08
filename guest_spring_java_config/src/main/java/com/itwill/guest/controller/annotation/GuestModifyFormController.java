package com.itwill.guest.controller.annotation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestDao;
import com.itwill.guest.GuestService;

//@Controller
public class GuestModifyFormController {
	@Autowired
	private GuestService guestService;
	
	@RequestMapping(value="/guest_modify_form.do",method=RequestMethod.GET)
	public String guest_modify_get() {
		String forwardPath="redirect:guest_main.do";
		return forwardPath;
	}
	@RequestMapping(value="/guest_modify_form.do",method=RequestMethod.POST)
	public String guest_modify(
				@RequestParam(value="guest_no",required=false,defaultValue="") String guest_noStr,
				Model model
				) {
		String forwardPath="";
			if (guest_noStr == null || guest_noStr.equals("")) {
				forwardPath="redirect:guest_list.do";
				
			}else{
				try {
					Guest guest = guestService.selectByNo(Integer.parseInt(guest_noStr));
					model.addAttribute("guest", guest);
					forwardPath="forward:/WEB-INF/views/guest_modify_form.jsp";
					
				} catch (Exception e) {
					e.printStackTrace();
					model.addAttribute("MSG", e.getMessage());
					forwardPath="forward:/WEB-INF/views/guest_error.jsp";
					
				}
				
			}
		
		return forwardPath;
	}

}
