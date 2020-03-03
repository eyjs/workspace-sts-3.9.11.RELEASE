<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>hello2.jsp</h1><hr/>
<ol>
	<li>/hello2.do 요청</li>
	<li>
		DispatcherServlet 이 HadlerMapping객체로부터 
	    요청url[/hello2.do]에 해당하는 HelloAnnotationController2객체얻기
	</li>
	<li>
		DispatcherServlet 이 HelloAnnotationController2객체의 
		hello2()메쏘드호출
	</li>
	<li>
		DispatcherServlet 이 HelloAnnotationController2객체의 
		hello2()메쏘드호출후반환된 
		String path[forward:/WEB-INF/views/hello2.jsp] 로 forwading..
	</li>
	<li>
		/WEB-INF/views/hello2.jsp 응답
	</li>
	<li>request.setAttribute("msg", "안녕HelloAnnotationController2");
	: ${msg}</li>
	
</ol>

</body>






</html>