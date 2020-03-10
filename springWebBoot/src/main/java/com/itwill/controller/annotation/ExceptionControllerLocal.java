package com.itwill.controller.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExceptionControllerLocal {
	@RequestMapping("/business1.do")
	public String business_method1() throws BusinessException1{
		boolean b=true;
		if(b) {
			throw new BusinessException1("업무에러1발생");
		}
		return "forward:/WEB-INF/views/business_result1.jsp";
	}
	@RequestMapping("/business2.do")
	public String business_method2() throws BusinessException2{
		boolean b=true;
		if(b) {
			throw new BusinessException2("업무에러2발생");
		}
		return "forward:/WEB-INF/views/business_result2.jsp";
	}
	@RequestMapping("/business3.do")
	public String business_method3() {
		String name=null;
		int size = name.length();
		return "forward:/WEB-INF/views/business_result3.jsp";
	}
	/********************************************************/
	@ExceptionHandler(BusinessException1.class)
	public String handle_business_exception1(BusinessException1 e) {
		
		return "forward:/WEB-INF/views/business_error_result.jsp";
	}
	/*
	@ExceptionHandler(BusinessException2.class)
	public String handle_business_exception2() {
		
		return "forward:/WEB-INF/views/business_error_result.jsp";
	}
	*/
	@ExceptionHandler(BusinessException2.class)
	public ModelAndView handle_business_exception2(BusinessException2 e) {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName(
				"forward:/WEB-INF/views/business_error_result.jsp");
		modelAndView.addObject("error_msg", e.getMessage());
		return modelAndView;
	}
	/*
	@ExceptionHandler(RuntimeException.class)
	public String handle_business_exception3(RuntimeException e) {
		
		return "forward:/WEB-INF/views/business_error_result.jsp";
	}
	*/
	
	
}











