<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>post_login_result.jsp</h1><hr/>
<ol>
	<li>POST 방식의 login.do 의실행결과</li>
	<li>id 파라메타: ${param.id}</li>
	<li>password 파라메타: ${param.password}</li>
	<li>session sUserId: ${sUserId}</li>
</ol>
</body>
</html>