<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>박경호님수정폼</h1><hr>
<div>
	<a href='address_list.do'>주소록리스트</a>
</div>
<form method="post" action="address_update_action.do">
	번호[readonly]<input type="text" name="no" value="12" readonly="readonly"><br>
	아이디--<input type="text" name="id" value="xxxx"><br>
	이름----<input type="text" name="name" value="박경호"><br>
	전화번호<input type="text" name="phone" value="123-9090"><br>
	주소----<input type="text" name="address" value="경기도"><br>
	<input type="submit" value="수정">
	<input type="reset" value="폼지우기">
</form>
</body>

