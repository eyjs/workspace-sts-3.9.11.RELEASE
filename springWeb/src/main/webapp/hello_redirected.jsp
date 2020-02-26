<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>hello_redirected.jsp</h1><hr/>
<ol>
	<li>/hello_redirect_jsp.do</li>
	<li>
		HelloAnnotationMultiRequestMappingController 객체의
		hello_redirect_jsp() 메쏘드 실행 
	</li>
	<li>
		HelloAnnotationMultiRequestMappingController 객체의
		hello_redirect_jsp() 메쏘드 실행결과
		[redirect:hello_redirected.jsp]를 DispatcherServlet에 반환
	</li>
	<li>
		DispatcherServlet hello_redireced.jsp 로 redirect
	</li>
</ol>
</body>
</html>




