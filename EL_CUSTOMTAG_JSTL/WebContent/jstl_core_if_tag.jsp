<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
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
<c:if test="${true}">
	1.항상실행<br>
</c:if>
<c:if test="${false}">
	2.항상안실행<br>
</c:if>
<c:if test="true">
	1.항상실행<br>
</c:if>
<c:if test="false">
	2.항상안실행<br>
</c:if>
<c:if test="${sUserId==null}">
	<a href='login_form.jsp'>로그인</a><br>
</c:if>
<c:if test="${sUserId!=null}">
	<a href='logout.jsp'>로그아웃</a><br>
</c:if>
<c:if test="${!empty(level) && level >=3 }">
	고수님 레벨이 ${level} 이상이시군요<br>
</c:if>
<c:if test="${!(!empty(level) && level >=3) }">
	하수님 레벨이 3 이하이시군요[ ${level} ]혹은 null<br>
</c:if>

</body>
</html>













