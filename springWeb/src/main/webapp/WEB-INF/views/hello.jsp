<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>hello.jsp</h1><hr/>
<ol>
	<li>/hello.do 요청</li>
	<li>
		DispatcherServlet 이 HadlerMapping객체로부터 
	    요청url[/hello.do]에 해당하는 HelloController객체얻기
	</li>
	<li>
		DispatcherServlet 이 HelloController객체의 
		handleRequest()메쏘드호출
	</li>
	<li>
		DispatcherServlet 이 HelloController객체의 
		handleRequest()메쏘드호출 반환된 
		path[/WEB-INF/views/hello.jsp] 로 forwading..
	</li>
	<li>
		/WEB-INF/views/hello.jsp 응답
	</li>
	<li>request.getAtttribute("msg"): ${msg}</li>
	
</ol>

</body>






</html>