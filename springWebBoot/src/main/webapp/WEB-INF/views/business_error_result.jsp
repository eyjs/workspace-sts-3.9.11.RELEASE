<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>business_error_result.jsp</h1><hr/>
model-->error_msg: ${error_msg}<br>
<pre>
    -------------------------BusinessException1--------------------
	@ExceptionHandler(BusinessException1.class)
	public String handle_business1_exception(BusinessException1 e) {
		return "forward:/WEB-INF/view/business_error_result.jsp";
	}
	-------------------------BusinessException2--------------------
	@ExceptionHandler(BusinessException2.class)
	public ModelAndView handle_business2_exception(BusinessException2 e) {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("forward:/WEB-INF/view/business_error_result.jsp");
		mv.addObject("error_msg",e.getMessage());
		return mv;
	}
</pre>
</body>
</html>