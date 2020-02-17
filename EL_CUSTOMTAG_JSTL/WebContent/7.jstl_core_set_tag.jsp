<%@page import="com.itwill.bean.Car"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%
	pageContext.setAttribute("a", "에이");
	pageContext.setAttribute("b", "비이");
	pageContext.setAttribute("c", "씨이");
	pageContext.setAttribute("d", "디이");
	pageContext.setAttribute("car", new Car(1111,"SM7","RED"));
%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>JSTL core set tag</h1><hr/>
<c:set var="id" value="guardp" scope="page"/>   
<c:set var="id" value="guardr" scope="request"/>   
<c:set var="id" value="guards" scope="session"/>   
<c:set var="id" value="guarda" scope="application"/>  
<%--
	pageContext.setAttribute("id", "guardp");
	request.setAttribute("id", "guardr");
	session.setAttribute("id", "guards");
	application.setAttribute("id", "guarda");
--%> 
<c:set var="sa" value="${a}" scope="request"/>
<c:set var="sb" value="${b}" scope="request"/>
<c:set var="sc" value="${c}" scope="request"/>
<c:set var="sd" value="${d}" scope="request"/>
<c:set var="scar" value="${car}" scope="request"/>
<%-- 
<c:set var="scar2" value="<%=new Car(2222,\"SM8\",\"BLACK\") %>" scope="request"/>
--%>
<ol>
	<li>${id}</li>
	<li>${pageScope.id}</li>
	<li>${requestScope.id}</li>
	<li>${sessionScope.id}</li>
	<li>${applicationScope.id}</li>
	<li>${sa}</li>
	<li>${sb}</li>
	<li>${sc}</li>
	<li>${sd}</li>
	<li>${car}:${car.no},${car.model},${car.color}</li>
	<li>${scar}:${scar.no},${scar.model},${scar.color}</li>
	<li>${scar}:${scar.no},${scar.model},${scar.color}</li>
	<li>${scar2}:${scar2.no},${scar2.model},${scar2.color}</li>
	<c:set target="${car}" property="no" value="9999"/>
	<c:set target="${car}" property="model" value="쉐보레"/>
	<c:set target="${car}" property="color" value="ORANGE"/>
	<li>${car}:${car.no},${car.model},${car.color}</li>
</ol>

</body>
</html>













