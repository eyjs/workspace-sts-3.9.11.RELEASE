<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>guest_write_result.jsp</h1><hr/>
<p>@RequestParam</p>

<ol>
	<li>${param.guest_name}</li>
	<li>${param.guest_email}</li>
	<li>${param.guest_homepage}</li>
	<li>${param.guest_content}</li>
</ol>

<p>@ModelAttribute</p>
<ol>
	<li>${guest.guest_name}</li>
	<li>${guest.guest_email}</li>
	<li>${guest.guest_homepage}</li>
	<li>${guest.guest_content}</li>
	<li>${guestList}</li>
</ol>
</body>
</html>




