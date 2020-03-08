package com.itwill.guest.controller.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestDao;
import com.itwill.guest.GuestService;
//@Controller
public class GuestModifyActionController {
	@Autowired
	private GuestService guestService;
	@RequestMapping(value="/guest_modify_action.do",method=RequestMethod.GET)
	public String guest_modify_action_get() {
		String forwardPath="redirect:guest_main.do";
		return forwardPath;
	}
	@RequestMapping(value="/guest_modify_action.do",method=RequestMethod.POST)
	public String guest_modify_action(Guest guest,Model model) {
		String forwardPath="";
		
			try{
				//GuestDao guestDao=new GuestDao();
				boolean updateOK=guestService.updateGuest(guest);
				if(updateOK){
					forwardPath="redirect:guest_view.do?guest_no="+guest.guest_no;
					
				}else{
					model.addAttribute("MSG", guest.guest_no+" 수정실패!!");
					forwardPath="forward:/WEB-INF/views/guest_error.jsp";
				}
			}catch(Exception e){
				e.printStackTrace();
				model.addAttribute("MSG",e.getMessage());
				forwardPath="forward:/WEB-INF/views/guest_error.jsp";
			}
		
		
		return forwardPath;
	}

}
