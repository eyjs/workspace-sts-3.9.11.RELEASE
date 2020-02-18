<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setAttribute("userId", "guard");
%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%-- 
<fmt:setLocale value="${pageContext.request.locale.language}" scope="session" />
--%>
<fmt:setLocale value="ko" scope="session" />
<%-- 
<fmt:setLocale value="ja" />
 --%>
<fmt:setBundle basename="com/itwill/i18n/guest" scope="session"/>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>I18N[internationalization]</h1><hr>
<ol>
	<li><fmt:message key="title.main"/></li>
	<li><fmt:message key="title.list"/></li>
	<li><fmt:message key="title.view"/></li>
	<li><fmt:message key="title.write"/></li>
	
	<li><fmt:message key="title.main" var="TITLE" scope="request"/></li>
	<li><fmt:message key="title.list" var="LIST" scope="request"/></li>
	<li><fmt:message key="title.view" var="VIEW" scope="request"/></li>
	<li><fmt:message key="title.write" var="WRITE" scope="request"/></li>
	<li>${TITLE}이다</li>
	<li>${LIST}이다</li>
	<li>${VIEW}이다</li>
	<li>${WRITE}이다</li>
	<li>
		<fmt:message key="error.msg">
			<fmt:param value="${userId}"/>
		</fmt:message>
	</li>
	<li>
		<fmt:message key="error.msg">
			<fmt:param value="xxxx"/>
		</fmt:message>
	</li>
	<li>
		<fmt:message key="nv.bc">
			<fmt:param value="메인"/>
			<fmt:param value="리스트"/>
		</fmt:message>
	</li>
	<li>
		<fmt:message key="nv.bc">
			<fmt:param value="메인"/>
			<fmt:param value="로그인"/>
		</fmt:message>
	</li>
</ol>
</body>
</html>










