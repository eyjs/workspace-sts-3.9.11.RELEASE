<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Hello Boot Gradle!!!</h1><hr/>
<ol>
<c:forEach var="hello"  items="${helloList}">
	<ul>${hello.no} : ${hello.name}</ul>
</c:forEach>
</ol>
</body>
</html>