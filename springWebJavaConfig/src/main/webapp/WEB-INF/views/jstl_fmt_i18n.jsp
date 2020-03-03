<%@page import="java.util.Locale"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%> 
<%
	Locale locale=request.getLocale();
	String language=locale.getLanguage();
	String country=locale.getCountry();
	
	request.setAttribute("id", "guard");
	
%>  
<c:set var="language" value="${pageContext.request.locale.language}"/>
<c:set var="country" value="${pageContext.request.locale.country}"/>
<%-- 
<fmt:setLocale value="en_US"/>
<fmt:setLocale value="ja_JP"/>
<fmt:setLocale value="${language}_${country}"/>
--%>
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="messages/guest"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>JSTL fmt i18n[${language}_${country}]</h1><hr/>
<fmt:message var="main"  key="title.main" scope="page"/>
<fmt:message var="list"  key="title.list"/>
<fmt:message var="view"  key="title.view"/>
<fmt:message var="write" key="title.write"/>


<ol>
	<li><fmt:message key="title.main"/></li>
	<li><fmt:message key="title.list"/></li>
	<li><fmt:message key="title.view"/></li>
	<li><fmt:message key="title.write"/></li>
	<li>${main}</li>
	<li>${list}</li>
	<li>${view}</li>
	<li>${write}</li>
	<li>
		<fmt:message key="error.msg">
			<fmt:param value="${id}"/>
		</fmt:message>
	</li>
	<li>
		<fmt:message key="error.msg">
			<fmt:param value="xxx"/>
		</fmt:message>
	</li>
	<li>
		<fmt:message key="error.msg">
			<fmt:param value="${'yyy'}"/>
		</fmt:message>
	</li>
	<li>
		<fmt:message key="nv.bc">
			<fmt:param value="${main}"/>
			<fmt:param value="${list}"/>
		</fmt:message>
	</li>
</ol>

</body>
</html>







