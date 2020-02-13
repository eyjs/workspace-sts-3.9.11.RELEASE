<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>address쓰기폼</h1><hr>
<div>
	<a href='address_list.do'>주소록리스트</a>
</div>
<form method="post" action="address_insert_action.do">
	아이디--<input type="text" name="id"><br>
	이름----<input type="text" name="name"><br>
	전화번호<input type="text" name="phone"><br>
	주소----<input type="text" name="address"><br>
	<input type="submit" value="쓰기">
	<input type="image"  src='image/0.png'>
	<input type="reset" value="폼지우기">
</form>
</body>

