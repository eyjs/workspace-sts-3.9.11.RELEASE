package com.itwill.controller.annotation;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.dto.Guest;

@Controller
public class SpringCustomTagSPELController {
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
