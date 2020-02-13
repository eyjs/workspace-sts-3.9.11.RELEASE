<%@page import="com.itwill.address.Address"%>
<%@page import="com.itwill.address.AddressService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String noStr = request.getParameter("no");
	if (noStr == null || noStr.equals("")) {
		response.sendRedirect("address_list.jsp");
		return;
	}
	
	AddressService addressService=new AddressService();
	Address address=addressService.findByNo(Integer.parseInt(noStr));
	if(address==null) {
		response.sendRedirect("error/error.jsp");
		return;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>김경호님 address detail</h1>
	<hr>
	<div>
		<a href='address_delete_action.do?no=1'>김경호님삭제[GET]</a>
		<form action='address_delete_action.do' method='post'>
			<input type='hidden' name='no' value='1'> <input
				type='submit' value='김경호님삭제[POST]'>
		</form>
		<a href=''>김경호님수정폼</a> <a href='address_insert_form.do'>주소록쓰기</a> <a
			href='address_list.do'>주소록리스트</a>
	</div>
	<p>
		번호:1<br>
		아이디:guard<br>
		이름:김경호<br>
		전화:123-4568<br>
		주소:경기도 성남시<br>
	</p>
</body>
</html>
