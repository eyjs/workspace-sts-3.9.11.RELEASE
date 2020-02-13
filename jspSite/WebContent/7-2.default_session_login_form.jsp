<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>세션로그인폼</h1><hr/>
<form action="7-2.default_session_login_action.jsp" method="post">
	<label>아이디&nbsp;&nbsp;&nbsp;</label><input type="text" name="id"><br/>
	<label>패쓰워드</label><input type="password" name="password"><br/>
	<input type="submit" value="로그인">
	<input type="reset" value="취소">
</form>
</body>
</html>