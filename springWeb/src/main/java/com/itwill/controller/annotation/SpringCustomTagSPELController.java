package com.itwill.controller.annotation;

import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.dto.Guest;
import com.itwill.service.UserExistedException;
import com.itwill.service.UserService;

@Controller
public class SpringCustomTagSPELController {
	@Autowired
	private MessageSource messageSource;
	@Autowired
	private UserService userService;
	/**********Service 생성[i18n]************/
	@RequestMapping("/spring_service_i18n.do")
	public String spring_service_i18n(Locale locale,Model model) {
		try {
			userService.create(/*locale*/);
		} catch (UserExistedException e) {
			e.printStackTrace();
			String message=messageSource.getMessage(e.getMessage(),
							new Object[] {"xxx"}, locale);
			model.addAttribute("exception_userexisted_msg",message);
		}
		return "spring_customtag_spel_i18n";
		
	}
	/**********Controller 생성[i18n]************/
	@RequestMapping("spring_controller_i18n.do")
	public String spring_controller_i18n(Locale locale,Model model) {
		
		String message=messageSource.getMessage("user.existed.exception",
								 new Object[] {"guard"}, locale);
		model.addAttribute("user_existed_exception_msg", message);
		return "spring_customtag_spel_i18n";
	}
	/**********jsp 출력[i18n]************/
	@RequestMapping("/spring_customtag_spel_i18n.do")
	public String spring_customtag_spel_i18n() {
		return "spring_customtag_spel_i18n";
	}
	
	
	@RequestMapping("/jstl_fmt_i18n.do")
	public String jstl_fmt_i18n() {
		return "jstl_fmt_i18n";
	}
	
	@RequestMapping("/spring_customtag_spel.do")
	public String spring_customtag_spel(HttpServletRequest request) {
		request.setAttribute("price0", 4342346);
		request.setAttribute("name0", "kim eun hi");
		
		request.setAttribute("price1", 1232151);
		request.setAttribute("name1", "LEE HYO LEE");
		request.setAttribute("married1", true);
		
		request.setAttribute("price2", 343434);
		request.setAttribute("name2", "김태희");
		request.setAttribute("married2", true);
		
		request.setAttribute("guest", 
				new Guest(1, "김수미", 
						new Date().toLocaleString(), "guard@naver.com",
						"http://www.itwill.co.kr", "오늘은 월요일",
						"Sping EL에대해 공부합니다"));
		return "spring_customtag_spel";
	}
	
	

}
