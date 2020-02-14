<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page import="com.itwill.bean.Car"%>
<%@page import="com.itwill.bean.Student"%>
<%@page import="com.itwill.bean.Guest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("int1", 10);
	pageContext.setAttribute("int2", 20);
	pageContext.setAttribute("double1", 0.5);
	pageContext.setAttribute("double2", 3.14159);
	pageContext.setAttribute("string1", "KIM");
	pageContext.setAttribute("string2", "KYUNG HO");
	pageContext.setAttribute("married", true);
	pageContext.setAttribute("age", 30);
	pageContext.setAttribute("weight", 78.236);
	
	Guest guest=null;
	String nullStr="";
	ArrayList emptyList=new ArrayList();
	HashMap emptyMap=new HashMap();
	pageContext.setAttribute("nullGuest", guest);
	pageContext.setAttribute("nullStr", nullStr);
	pageContext.setAttribute("emptyList", emptyList);
	pageContext.setAttribute("emptyMap", emptyMap);
	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>
	EL literal 연산자
</h1><hr/>
<ol>
	<li>-----EL리터럴----</li>
	<li>${2147483}</li>
	<li>${3.14159}</li>
	<li>${'문자'}</li>
	<li>${"문자"}</li>
	<li>${x}</li>
	<li>${y}</li>
	<li>-----EL연산----</li>
	<li>${int1 + int2 + 10}</li>
	<li>${int1 - int2 }</li>
	<li>${int1/int2}</li>
	<li>${(int1*int2)/3}</li>
	<li>${1/2}</li>
	<li>${double1+double2}</li>
	<li>${age>=30}</li>
	<li>${age<30}</li>
	<li>${age>=30 && age<40}</li>
	<li>${age ge 30 and age lt 40}</li>
	<li>${(age>=30 && age<40)||(weight>=70 && weight < 80)}</li>
	<li>-------empty------</li>
	<li>${empty(nullGuest)}</li>
	<li>${empty nullStr}</li>
	<li>${empty emptyList}</li>
	<li>${empty emptyMap}</li>
	<li>${empty(null)}</li>
	<li>${empty("")}</li>
	<li>${empty ''}</li>
</ol>


</body>
</html>










