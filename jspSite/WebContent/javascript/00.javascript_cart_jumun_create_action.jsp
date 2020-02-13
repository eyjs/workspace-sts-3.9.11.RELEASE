<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String[] cart_item_no_qty_array=request.getParameterValues("cart_item_no_qty");
	
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>주문생성</h1>
<%for(String cart_item_no_qty:cart_item_no_qty_array) {%>
	cart_item_no_qty:<%=cart_item_no_qty%><br/>
<%} %>
</body>
</html>