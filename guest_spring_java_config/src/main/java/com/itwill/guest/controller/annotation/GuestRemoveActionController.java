package com.itwill.guest.controller.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.guest.GuestDao;
import com.itwill.guest.GuestService;

//@Controller
public class GuestRemoveActionController {
	@Autowired
	private GuestService guestService;
	
	@RequestMapping(value="/guest_remove_action.do",method=RequestMethod.GET)
	public String guest_remove_action_get() {
		String forwardPath="redirect:guest_main.do";
		return forwardPath;
	}
	@RequestMapping(value="/guest_remove_action.do",method=RequestMethod.POST)
	public String guest_remove_action(@RequestParam("guest_no") String guest_noStr,Model model) {
			String forwardPath="";
			boolean deleteOK;
			try {
				deleteOK = guestService.deleteGuest(Integer.parseInt(guest_noStr));
			
			if(deleteOK){
				forwardPath="redirect:guest_list.do";
				
			}else{
				model.addAttribute("MSG", guest_noStr+" 삭제실패!!!");
				forwardPath="forward:/WEB-INF/views/guest_error.jsp";
			}
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				model.addAttribute("MSG", e.getMessage());
				forwardPath="forward:/WEB-INF/views/guest_error.jsp";
			}
		
		return forwardPath;
	}

}
