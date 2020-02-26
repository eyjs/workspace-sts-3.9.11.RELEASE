<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>spring_model.jsp</h1><hr/>
<h2>Controller에서 전달한 request scope의 속성데이타출력</h2>
<ol>
	<li>request[HttpServletRequest]:${req}</li>
	<li>Model[BindingAwareModelMap]:${model}</li>
	<li>Map[BindingAwareModelMap]:${map}</li>
	<li>ModelAndView:${modelAndView}</li>
	<li>ModelMap:${modelmap}</li>
</ol>

</body>
</html>