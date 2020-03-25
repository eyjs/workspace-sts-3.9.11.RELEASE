package com.itwill.user.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.user.User;
import com.itwill.user.UserService;
import com.itwill.user.exception.ExistedUserException;
import com.itwill.user.exception.PasswordMismatchException;
import com.itwill.user.exception.UserNotFoundException;
@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/user_main")
	
	public String user_main() {
		return "user_main";
	}

	@RequestMapping(value = "/user_write_form")
	public String user_write_form() {
		return "user_write_form";
	}

	@RequestMapping(value = "/user_write_action", method = RequestMethod.GET)
	public String user_write_action_get() {
		return "redirect:user_write_form";
	}
	@RequestMapping(value = "/user_write_action", method = RequestMethod.POST)
	public String user_write_action_post(@ModelAttribute(name = "fuser") User user, Model model) {
		String forwardPath = "";
		try {
			userService.create(user);
			forwardPath = "redirect:user_login_form";
		} catch (ExistedUserException e) {
			e.printStackTrace();
			forwardPath = "user_write_form";
			model.addAttribute("fuser", user);
			model.addAttribute("msg", e.getMessage());
		} catch (Exception e) {
			forwardPath = "user_error";
			e.printStackTrace();
		}
		return forwardPath;
	}
	@RequestMapping(value = "user_login_form")
	public String user_login_form() {
		return "user_login_form";
	}
	@RequestMapping(value = "/user_login_action", method = RequestMethod.GET)
	public String user_login_action_get() {
		return "user_login_form";
	}
	@RequestMapping(value = "/user_login_action", method = RequestMethod.POST)
	public String user_login_action_post(@ModelAttribute(name = "fuser") User user,
			 HttpSession session, Model model) {
		String forwardPath = "";
		try {
			User loginUser = userService.login(user.getUserId(), user.getPassword());
			session.setAttribute("sUserId", user.getUserId());
			session.setAttribute("sUser", loginUser);
			forwardPath = "redirect:user_main";
		} catch (UserNotFoundException e) {
			model.addAttribute("fUser", user);
			model.addAttribute("msg1", e.getMessage());
			forwardPath = "user_login_form";
			e.printStackTrace();
		} catch (PasswordMismatchException e) {
			model.addAttribute("fUser", user);
			model.addAttribute("msg2", e.getMessage());
			forwardPath = "user_login_form";
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			forwardPath = "user_error";
		}
		return forwardPath;
	}
	@RequestMapping(value = "/user_logout_action")
	public String user_logout_action(HttpSession session ) {
		session.invalidate();
		String forwardPath="redirect:user_main";
		return forwardPath;
	}
	
	@RequestMapping(value = "/user_view")
	public String user_view(@ModelAttribute User user, Model model){
		String forwardPath = "";
		
		User findUser = null;
		try {
			findUser = userService.findUser(user.getUserId());
			model.addAttribute("user", findUser);
			forwardPath = "user_view";
		} catch (UserNotFoundException e) {
			model.addAttribute("USER_NOT_FOUND_MSG", e.getMessage());
			forwardPath = "forward:user_list";
		} catch (Exception e) {
			e.printStackTrace();
			forwardPath = "user_error";
		}
		return forwardPath;
	}
	@RequestMapping(value = "/user_list")
	public String user_list(Model model) {
		String forwardPath="";
		try {
			ArrayList<User> userList = userService.findUserList();
			model.addAttribute("userList", userList);
			forwardPath="user_list";
		} catch (Exception e) {
			forwardPath="user_error";
			e.printStackTrace();
		}
		return forwardPath;
	}
	@RequestMapping(value = "/user_modify_form",method = RequestMethod.GET)
	public String user_modify_form_get() {
		return "redirect:user_main.do";
	}
	@RequestMapping(value = "/user_modify_form",method = RequestMethod.POST)
	public String user_modify_form_post(@RequestParam String userId,Model model) {
			String forwardPath="";
			User user=null;
			try{
			    user = userService.findUser(userId);
			    model.addAttribute("user", user);
			    forwardPath="user_modify_form";
			}catch(Exception e){
				e.printStackTrace();
				forwardPath="user_error";
			}
			return forwardPath;
	}
	@RequestMapping(value = "/user_modify_action",method = RequestMethod.GET)
	public String user_modify_action_get() {
		return "redirect:user_main";
	}
	@RequestMapping(value = "/user_modify_action",method = RequestMethod.POST)
	public String user_modify_action_post(@ModelAttribute User user) {
		String forwardPath="";
		try{
			userService.update(user);
			forwardPath="forward:user_view";
		}catch(Exception e){
			e.printStackTrace();
			forwardPath="user_error";
		}
		return forwardPath;
	}
	@RequestMapping(value = "/user_remove_action",method = RequestMethod.GET)
	public String user_remove_action_get() {
		return "redirect:user_main";
	}
	@RequestMapping(value = "/user_remove_action",method = RequestMethod.POST)
	public String user_remove_action_post(@RequestParam String userId,HttpServletRequest request) {
		String forwardPath="";
		try{
			userService.remove(userId);
			if(request.getSession().getAttribute("sUserId").equals(userId)) {
				forwardPath="redirect:user_logout_action";
			}else {
				forwardPath="redirect:user_main";
			}
			
		}catch(Exception e){
			e.printStackTrace();
			forwardPath="user_error";
		}
		return forwardPath;
	}

}
