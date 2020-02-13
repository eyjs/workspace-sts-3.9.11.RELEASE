<%@page import="com.itwill.address.Address"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.itwill.address.AddressService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	AddressService addressService=new AddressService();
	ArrayList<Address> addressList = addressService.findAll();
%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<a href='address_insert_form.jsp'>주소록쓰기</a>
	</div>
	<div>
		<table border="1">
			<tr>
				<td>이름</td>
				<td>주소</td>
			</tr>
			<%for(Address address: addressList){ %>
			<tr>
				<td>
					<a href='address_detail.jsp?no=<%=address.getNo()%>'>
						<%=address.getName()%>
					</a>
				</td>
				<td><%=address.getAddress() %></td>
			</tr>
			<% }%>
			

		</table>
	</div>
</body>