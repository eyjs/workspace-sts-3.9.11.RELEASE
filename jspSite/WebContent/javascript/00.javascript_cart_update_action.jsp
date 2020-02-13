<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String cart_item_no=request.getParameter("cart_item_no");
	String cart_item_product_no=request.getParameter("cart_item_product_no");
	String cart_item_qty=request.getParameter("cart_item_qty");
	response.sendRedirect("00.javascript_cart_view_form.jsp");
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>cart update action</h1>
cart_item_no:<%= cart_item_no%><br>
cart_item_product_no:<%=cart_item_product_no %><br>
cart_item_qty:<%=cart_item_qty %><br>

</body>
</html>