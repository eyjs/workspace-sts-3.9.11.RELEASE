package com.itwill.controller.annotation;

import java.io.Writer;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RequestMappingServletAPIParameterController {
	@RequestMapping("controller_servletapi.do")
	public String request(
							HttpServletRequest request,
							HttpServletResponse response,
							HttpSession session,
							Writer out,
							@CookieValue("JSESSIONID") String sessionId,
							Locale requestLocale
							) {
		System.out.println("############### 웹객체 ############");
		System.out.println("### "+request);
		System.out.println("### "+response);
		System.out.println("### "+session);
		System.out.println("### "+out);
		System.out.println("### "+sessionId);
		System.out.println("### "+requestLocale);
		System.out.println("####################################");
		return "/WEB-INF/views/controller_servletapi.jsp";
	}
}
