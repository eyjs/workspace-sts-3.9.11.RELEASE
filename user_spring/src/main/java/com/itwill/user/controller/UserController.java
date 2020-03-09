package com.itwill.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwill.user.User;
import com.itwill.user.UserService;
import com.itwill.user.exception.ExistedUserException;

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
	 @RequestMapping(value = "/user_write_action",method = RequestMethod.GET)
	 public String user_write_action_get() {
		 return "user_write_form";
	 }
	 @RequestMapping(value = "user_login_form")
	 public String user_login_form() {
		 return "user_login_form";
	 }
	 
	 @RequestMapping(value = "/user_write_action",method = RequestMethod.POST)
	 public String user_write_action_post(@ModelAttribute(name = "fuser") User user,Model model) {
		 String forwardPath="";
		 try {
			userService.create(user);
			forwardPath="redirect:user_login_form";
		} catch (ExistedUserException e) {
			e.printStackTrace();
			
			forwardPath="user_write_form";
			//model.addAttribute("fuser", user);
			model.addAttribute("msg", e.getMessage());
		} catch (Exception e) {
			forwardPath="user_error";
			e.printStackTrace();
		}
		return forwardPath;
	 }
	
}
