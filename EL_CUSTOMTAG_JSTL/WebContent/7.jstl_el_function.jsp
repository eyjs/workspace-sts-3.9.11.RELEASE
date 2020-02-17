<%@page import="com.itwill.util.Board"%>
<%@page import="javafx.scene.layout.Border"%>
<%@page import="java.sql.Date"%>
<%@page import="com.itwill.util.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.lang.Integer" %>    
<%@ page import="com.itwill.util.BoardUtils" %>
<%@page import="com.itwill.util.StaticFunction" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%
	String title="오늘은 월요일 한주의 시작입니다.";
	request.setAttribute("title", title);
	request.setAttribute("name", "JAMES");
	request.setAttribute("price", 12345678);
	request.setAttribute("weight", 74.56321);
	
	Board board=new Board();
	board.setTitle("타이틀타이틀타이틀타이틀타이틀타이틀");
	board.setDepth(2);
	
	request.setAttribute("board",board);
%>	   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>JSTL EL function</h1><hr/>
<%--
${fn:toLowerCase('ABC') }<br/>
${fn:toUpperCase('abc') }<br/>
${'ABC'.toLowerCase()}<br/>
${fn:substring(title,4,7) }<br/>
 --%>
${title.substring(4,7) }<br/>
${"1"+"2"}<br/>
{"1"+"a"}[X]<br/>
{"a"+"b"}[X]<br/>
${"a"}b<br/>
${"a"+="b"}<br/>
${Integer.parseInt('45')+56}<br/>
${StaticFunction.number(price,'###,###,###')}<br>
${StaticFunction.number(weight,'###,###.##')}<br>
${StaticFunction.number(weight,'###,###.##')}<br>
보드타이틀--> ${BoardUtils.getTitleString(board)}<br/>
</body>
</html>











