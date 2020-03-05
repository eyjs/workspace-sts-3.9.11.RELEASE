<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
	<head>
		<meta charset="utf-8">
		<title>Welcome</title>
	</head> 
	<body>
		<h1>Welcome Spring MVC</h1><hr/>
		<a href='./'>메인메뉴</a>
		<ol>
			<li><a href='hello.do'>hello.do</a></li>
			<li><a href='hello1.do'>hello1.do[annotation]</a></li>
			<li><a href='hello2.do'>hello2.do[annotation]</a></li>
			<li>HelloAnnotationMultiRequestMappaingController 객체의 메쏘드여러개매핑</li>
			<li><a href='hello3.do'>hello3.do[annotation]</a></li>
			<li><a href='hello4.do'>hello4.do[annotation]</a></li>
			<li><a href='hello5.do'>hello5.do[annotation]</a></li>
			<li><a href='hello_redirect_jsp.do'>hello_redirect_jsp.do[jsp redirect]</a></li>
			<li><a href='hello_redirect_servlet.do'>
			            hello_redirect_servlet.do[servlet redirect]
			    </a>
			</li>
			<li><a href='hello_servlet_forward.do'>
			            hello_servlet_forward.do[servlet forward]
			    </a>
			</li>
		</ol>
	</body>
</html>