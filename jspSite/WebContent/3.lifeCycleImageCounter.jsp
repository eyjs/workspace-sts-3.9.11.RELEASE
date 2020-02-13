<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%! private int count; %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body bgcolor=#40e0d0 style="font-size: 9pt; line-height: 140%;">
	<center>
		현재까지의 접속자수
		<% 
			String countStr = ++count +"";
			for(int i=0;i<countStr.length();i++){
				out.print("<img src='image/"+countStr.charAt(i)+".png'>");
			}
		 %>
		명입니다.
	</center>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<%@ include file="5-6.directive_included_file.jspf" %>
</body>
</html>
