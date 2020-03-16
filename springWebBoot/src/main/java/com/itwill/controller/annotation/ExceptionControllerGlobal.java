package com.itwill.controller.annotation;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice
public class ExceptionControllerGlobal {
	
	@ExceptionHandler(RuntimeException.class)
	public String handle_runtime_exception(RuntimeException e) {
		return "forward:/WEB-INF/views/global_error_result.jsp";
	}
	@ExceptionHandler(Exception.class)
	public String handle_exception(Exception e) {
		return "forward:/WEB-INF/views/global_error_result.jsp";
	}
	
}
