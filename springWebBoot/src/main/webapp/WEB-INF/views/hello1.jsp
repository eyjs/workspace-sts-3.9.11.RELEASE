<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>hello1.jsp</h1><hr/>
<ol>
	<li>/hello1.do 요청</li>
	<li>
		DispatcherServlet 이 HadlerMapping객체로부터 
	    요청url[/hello1.do]에 해당하는 HelloController1객체얻기
	</li>
	<li>
		DispatcherServlet 이 HelloController1객체의 
		hello1()메쏘드호출
	</li>
	<li>
		DispatcherServlet 이 HelloController1객체의 
		hello1()메쏘드호출후반환된 
		String path[forward:/WEB-INF/views/hello1.jsp] 로 forwading..
	</li>
	<li>
		/WEB-INF/views/hello1.jsp 응답
	</li>
	<li>request.setAttribute("msg", "안녕HelloAnnotationController1");
	: ${msg}</li>
	
</ol>

</body>






</html>