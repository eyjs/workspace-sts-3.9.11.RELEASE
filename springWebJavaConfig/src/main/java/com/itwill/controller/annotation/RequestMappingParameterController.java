package com.itwill.controller.annotation;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.dto.Guest;

@Controller
public class RequestMappingParameterController {
	
	@RequestMapping(value = "/parameter_guest_write_form.do")
	public String parameter_guest_write_form() {
		return "forward:/WEB-INF/views/guest_write_form.jsp";
	}
	@RequestMapping(value = "/parameter_guest_write_action.do",
			method = RequestMethod.GET)
	public String parameter_guest_write_action_get() {
		//return "/WEB-INF/views/guest_write_form.jsp";
		//return "redirect:parameter_guest_write_form.do";
		return "forward:parameter_guest_write_form.do";
	}
	@RequestMapping(value="/model_attribute_guest_write_action.do",
					method=RequestMethod.POST)
	public String model_attribute_guest_write_action(
			@ModelAttribute(name = "guest") Guest guest) {
		System.out.println("### "+guest);
		/*
		 * 1. 파라메타의모든객체 받기
		 * 2. 선언된DTO객체[Guest]생성(기본생성자)
		 * 3. 받은파라메타 데이타를 파라메타이름과 일치하는
		 *    Guest객체의 속성메쏘드(setter method)호출해서대입
		 * 4. Guest클래스이름 첫글자를 소문자로변경한이름(guest)으로
		 *    request객체에 속성(attribute)등록
		 *    request.setAttribute("guest",guest);
		 */
		/*
		 * GuestService메쏘드호출
		 */
		this.guestList();
		return "forward:/WEB-INF/views/guest_write_result.jsp";
	}
	
	private @ModelAttribute(name="guestList") ArrayList<Guest> guestList(){
		ArrayList<Guest> guestList=new ArrayList<Guest>();
		guestList.add(new Guest());
		guestList.add(new Guest());
		guestList.add(new Guest());
		guestList.add(new Guest());
		return guestList;
	}
	
	
	@RequestMapping(value = "/parameter_guest_write_action.do",
					method = RequestMethod.POST)
	public String parameter_guest_write_action(
			@RequestParam("guest_name") String name,
			@RequestParam("guest_title") String guest_title,
			@RequestParam("guest_email") String guest_email,
			@RequestParam String guest_homepage,
			@RequestParam String guest_content,
			Model model
			) {
		    System.out.println("###########파라메타################");
			System.out.println("### guest_name:"+name);
			System.out.println("### guest_title:"+guest_title);
			System.out.println("### guest_email:"+guest_email);
			System.out.println("### guest_homepage:"+guest_homepage);
			System.out.println("### guest_content:"+guest_content);
			System.out.println("###################################");
			
			
			/*
			 * GuestService메쏘드호출
			 */
			Guest guest=new Guest(0, name,
								  null, guest_email, guest_homepage,
								  guest_title, guest_content);
			model.addAttribute("guest", guest);
			/*
			 * request.setAttribute("guest",guest);
			 */
			
		return "forward:/WEB-INF/views/guest_write_result.jsp";
	}
}













