package com.itwill.guest.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;
import com.itwill.guest.GuestServiceImpl;

@Controller
public class GuestController {
	@Autowired
	private GuestService guestService;

	@RequestMapping("/guest_main.do")
	public String guest_main() {
		return "/WEB-INF/view/guest_main.jsp";
	}

	@RequestMapping("/guest_list.do")
	public String guest_list(Model model, HttpServletRequest request) {
		String forwardPath = "";
		try {
			List<Guest> guestList = guestService.selectAll();
			model.addAttribute("guestList", guestList);
			// request.setAttribute("guestList",guestList);
			forwardPath = "forward:/WEB-INF/view/guest_list.jsp";
		} catch (Exception e) {
			forwardPath = "forward:/WEB-INF/view/guest_error.jsp";
			e.printStackTrace();
		}
		return "/WEB-INF/view/guest_list.jsp";
	}

	@RequestMapping("/guest_view.do")
	public String guest_view(
			@RequestParam(value = "guest_no", required = false, defaultValue = "-999") String guest_noStr, Map map) {
		String forwardPath = "";
		try {
			Guest guest = guestService.selectByNo(Integer.parseInt(guest_noStr));
			if (guest == null) {
				forwardPath = "redirect:guest_main.do";
			} else {
				// request.setAttribute("guest", guest);
				map.put("guest", guest);
				forwardPath = "forward:/WEB-INF/view/guest_view.jsp";
			}
		} catch (Exception e) {
			e.printStackTrace();
			forwardPath = "forward:/WEB-INF/view/guest_error.jsp";
		}

		return forwardPath;
	}

	@RequestMapping(value = "/guest_write_form.do")
	public String guest_write_form() {
		String forwardPath = "";
		forwardPath = "forward:/WEB-INF/view/guest_write_form.jsp";
		return forwardPath;
	}

	@RequestMapping(value = "/guest_write_action.do", method = RequestMethod.GET)
	public String guest_write_action_get() {
		return "redirect:guest_main.do";
	}

	@RequestMapping(value = "/guest_write_action.do", method = RequestMethod.POST)
	public String guest_write_action_post(@ModelAttribute Guest guest) {
		String forwardPath = "";
		try {
			boolean insertOK = guestService.insertGuest(guest);
			if (insertOK) {
				forwardPath = "redirect:guest_list.do";
			} else {
				forwardPath = "forward:/WEB-INF/view/guest_error.jsp";
			}
		} catch (Exception e) {
			e.printStackTrace();
			forwardPath = "forward:/WEB-INF/view/guest_error.jsp";
		}
		return forwardPath;
	}

	@RequestMapping(value = "/guest_modify_form.do", method = RequestMethod.GET)
	public String guest_modify_form_get() {
		String forwardPath = "";
		forwardPath = "redirect:guest_main.do";
		return forwardPath;
	}

	@RequestMapping(value = "/guest_modify_form.do", method = RequestMethod.POST)
	public String guest_modify_form_post(@RequestParam("guest_no") String guest_noStr, ModelMap modelMap) {
		String forwardPath = "";
		try {
			Guest guest = guestService.selectByNo(Integer.parseInt(guest_noStr));
			// request.setAttribute("guest",guest);
			modelMap.addAttribute("guest", guest);
			forwardPath = "forward:/WEB-INF/view/guest_modify_form.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			forwardPath = "forward:/WEB-INF/view/guest_error.jsp";
		}
		return forwardPath;
	}

	@RequestMapping(value = "/guest_modify_action.do",method=RequestMethod.POST)
	public String guest_modify_action(@ModelAttribute Guest updateGuest) {
		String forwardPath="";
		try {
			boolean updateOK = guestService.updateGuest(updateGuest);
			if (updateOK) {
				//forwardPath = "redirect:guest_view.do?guest_no=" + guest_noStr;
				forwardPath="forward:guest_view.do";
			} else {
				forwardPath = "redirect:guest_error.do";
			}
		} catch (Exception e) {
			e.printStackTrace();
			forwardPath = "forward:/WEB-INF/view/guest_error.jsp";
		}
		return forwardPath;
	}
	@RequestMapping(value = "/guest_delete_action.do",method=RequestMethod.POST)
	public String guest_delete_action(
			@RequestParam("guest_no") String guest_noStr) {
		String forwardPath="";
		try {
			boolean deleteOK=
			guestService.deleteGuest(Integer.parseInt(guest_noStr));
			if(deleteOK){
				forwardPath="redirect:guest_list.do";
			}else{
				forwardPath="forward:/WEB-INF/view/guest_error.do";
			}
		}catch (Exception e) {
			e.printStackTrace();
			forwardPath="forward:/WEB-INF/view/guest_error.jsp";
		}
		return forwardPath;
	}

	@RequestMapping(value = "/guest_error.do")
	public String guest_error() {
		String forwardPath="/WEB-INF/view/guest_error.jsp";
		return forwardPath;
	}

}
