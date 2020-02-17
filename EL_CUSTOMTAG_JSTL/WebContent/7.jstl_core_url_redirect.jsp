<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>JSTL core url,redirect tag</h1><hr>
<a href='./7.jstl_core_url_redirect_main.jsp'>메인0</a><br>
<a href='7.jstl_core_url_redirect_main.jsp'>메인1</a><br>
<a href='/EL_CUSTOMTAG_JSTL/7.jstl_core_url_redirect_main.jsp'>메인3</a><br>
<a href='<%=request.getContextPath()%>/7.jstl_core_url_redirect_main.jsp'>메인4</a><br>
<a href="<c:url value='7.jstl_core_url_redirect_main.jsp'/>">메인4</a><br>
<a href="<c:url value='/7.jstl_core_url_redirect_main.jsp'/>">메인5</a><br>
<c:url 
	value="/7.jstl_core_url_redirect_main.jsp" 
	var="mainUrl"  
	scope="page"/>
<a href="${mainUrl}">메인6</a><br>

<c:url 	var="mainUrlParam" 
		scope="page" 
		value="7.jstl_core_url_redirect_main.jsp">
	<c:param name="id" value="guard"/>
	<c:param name="name" value="가아드"/>
</c:url>

<a href="${mainUrlParam}">메인7[파라메타]</a><br>

<%--
<c:redirect url="${mainUrlParam}"/>
<c:redirect url="7.jstl_core_url_redirect_main.jsp">
	<c:param name="id" value="guard"/>
	<c:param name="name" value="가아드"/>
</c:redirect>
--%>
</body>
</html>






