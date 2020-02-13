<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	String[] cars = request.getParameterValues("cars[]");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%=cars[0]%>
<%=cars[1]%>
<%=cars[2]%>
</body>
</html>