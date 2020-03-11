package com.itwill.controller.annotation;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class RequestMappingGETPOSTController {
	@RequestMapping(value = "/login.do",method = RequestMethod.GET)
	public String login_form_get() {
		return "forward:/WEB-INF/views/get_login_form.jsp";
	}
	@RequestMapping(value = "/login.do",method = RequestMethod.POST)
	public String login_action_post(@RequestParam(value = "id",required = true,defaultValue = "") String id,
									@RequestParam String password,
									HttpSession session) {
		System.out.println("### id parameter:"+id);
		System.out.println("### password parameter:"+password);
		boolean isLogin=true;
		if(isLogin) {
			session.setAttribute("sUserId", id);
		}
		return "forward:/WEB-INF/views/post_login_result.jsp";
	}
}
