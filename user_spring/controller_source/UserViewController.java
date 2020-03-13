package com.itwill.user.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.summer.Controller;
import com.itwill.user.User;
import com.itwill.user.UserService;
import com.itwill.user.exception.UserNotFoundException;

public class UserViewController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath = "";
		String userId = request.getParameter("userId");
		try {
			userId=URLDecoder.decode(userId, "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		if (userId == null || userId.equals("")) {
			forwardPath = "redirect:user_list.do";
		} else {
			User user = null;
			try {
				UserService userService = new UserService();
				user = userService.findUser(userId);
				request.setAttribute("user", user);
				forwardPath = "forward:/WEB-INF/views/user_view.jsp";
			} catch (UserNotFoundException e) {
				request.setAttribute("USER_NOT_FOUND_MSG", e.getMessage());
				forwardPath = "forward:user_list.do";
			} catch (Exception e) {
				e.printStackTrace();
				forwardPath = "forward:/WEB-INF/views/user_error.jsp";
			}
		}
		return forwardPath;
	}

}
