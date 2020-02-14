<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="simple" uri="http://www.itwill.co.kr/jsp/simpleTag"%>    
 
<%
	session.setAttribute("sUserId", "guard");
	session.setAttribute("level", 5);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>JSTL core if tag</h1><hr>
<c:if test="true">
	1.항상실행<br>
</c:if>
<simple:If test="false">
	2.항상안실행<br>
</simple:If>
<c:if test="${sUserId==null}">
	<a href='user_login_form.jsp'>로그인</a><br>
</c:if>
<c:if test="${sUserId!=null}">
	<a href='user_logout.jsp'>${sUserId}님로그아웃</a><br>
</c:if>
<c:if test="${!empty(level)}">
	<c:if test="${level>=5 }">
		고수이군요[${level}]<br>
	</c:if>
</c:if>
</body>
</html>
























