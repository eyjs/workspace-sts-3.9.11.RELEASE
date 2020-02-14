<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%
	session.setAttribute("sUserId", "user");
	request.setAttribute("level","5");
%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${sUserId=='admin'}">
			관리자<br>
		</c:when>
		<c:otherwise>
			일반유저<br>
		</c:otherwise>
	</c:choose>
	<hr/>
	<c:choose>
		<c:when test="${sUserId!=null}">
			<c:if test="${sUserId=='admin'}">
				<a href='admin_logout.jsp'>${sUserId}님로그아웃</a><br>
				<a href='product_delete.jsp'>상품삭제</a><br>
			</c:if>
			<c:if test="${sUserId!='admin'}">
				<a href='user_logout.jsp'>${sUserId}님로그아웃</a><br>
			</c:if>
		</c:when>
		<c:otherwise>
			<a href="user_login_form.jsp">로그인</a><br>
		</c:otherwise>	
	</c:choose>
	
	<c:choose>
		<c:when test="${level == 1}">
			초보시군요[${level}]<br>
		</c:when>
		<c:when test="${level==2}">
			좀하시는군요[${level}]<br>
		</c:when>
		<c:when test="${level==3 }">
			잘하시는군요[${level}]<br>
		</c:when>
		<c:when test="${level>3 && level<=5}">
			싸부님!!![${level}]<br>
		</c:when>
		<c:otherwise>
			 레벨은 1~5사이의 정수입니다.<br>
		</c:otherwise>
	</c:choose>
	
	
</body>
</html>


















