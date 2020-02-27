package com.itwill.controller.annotation;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class ResponseController {
	/*
	 * Controller-->MessageConverter-->클라이언트로 출력
	 */
	
	/********************redirect view*******************/
	@RequestMapping("/response_redirect_view_object.do")
	public View response_redirect_view_object(Model model) {
		
		RedirectView redirectView=
				new RedirectView("response_redirect_view_object.jsp");
		/*
		 * response_redirect_view_object.jsp?id=xxx&name=kim
		 */
		model.addAttribute("id", "xxx");
		model.addAttribute("name", "kim");
		return redirectView; 
	}
	@RequestMapping("/response_redirect_view_name.do")
	public String response_redirect_view_name(Model model) {
		
		/*
		 * response_redirect_view_object.jsp?id=xxx&name=kim
		 */
		model.addAttribute("id", "xxx");
		model.addAttribute("name", "kim");
		return "redirect:response_redirect_view_name.jsp";
	}
	
	/********************xml출력 View[XMLView]*******************/
	@RequestMapping("response_xml_view_object.do")
	public View response_xml_view_object(Model model) {
		ArrayList<String> friendList=new ArrayList<String>();
		friendList.add("김수미");
		friendList.add("김우미");
		friendList.add("김미미");
		friendList.add("김양미");
		friendList.add("김가미");
		model.addAttribute("friendList", friendList);
		XMLView xmlView=new XMLView();
		return xmlView;
	}
	@RequestMapping("response_xml_view_name.do")
	public String response_xml_view_name(Model model) {
		ArrayList<String> friendList=new ArrayList<String>();
		friendList.add("김수미");
		friendList.add("김우미");
		friendList.add("김미미");
		friendList.add("김양미");
		friendList.add("김가미");
		model.addAttribute("friendList", friendList);
		return "xmlView";
	}
	/********************forward view*******************/
	@RequestMapping("/response_view_name.do")
	public String response_view_name() {
		/* 
		  0 . view name(String)
		  1 . InternalResourceViewResolver 객체
		  2 . InternalResourceView 객체(URL:/WEB-INF/views/response_view_name.jsp)
		  3 . URL--> /WEB-INF/views/response_view_name.jsp forward	
		*/
		/*
		mcv-config-view-resolver.xml
		<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
			<property name="prefix" value="/WEB-INF/views/"/>
			<property name="suffix" value=".jsp"/>
		</bean>
		 */
		
		return "response_view_name";
	}
	@RequestMapping("/response_view_object.do")
	public View response_view_object() {
		
		InternalResourceView internalResourceView=
				new InternalResourceView("/WEB-INF/views/response_view_object.jsp");
		/*
		 * 1.InternalResourceView 객체(URL:/WEB-INF/views/response_view_object.jsp)반환
		 * 2.URL--> /WEB-INF/views/response_view_object.jsp forward
		 */
		return internalResourceView;
	}
	
}
