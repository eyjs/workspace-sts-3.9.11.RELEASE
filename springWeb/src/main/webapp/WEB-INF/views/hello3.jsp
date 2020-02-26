<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>hello3.jsp</h1><hr/>
<ol>
	<li>/hello3.do요청</li>
	<li>DispatcherServlet실행</li>
	<li>
		DispatcherServlet이 
		HelloAnnotationMultiRequestMappingController객체의 
		hello3() 메쏘드실행
	</li>
	
	<li>/WEB-INF/view/hello3.jsp 응답</li>
	
</ol>
</body>
</html>