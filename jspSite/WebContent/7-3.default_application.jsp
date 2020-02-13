<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>기본객체 application(ServletContext)</h1>
<hr/>
<ol>
<li>서버정보<%=application.getServerInfo()%></li>
<li>major version : <%=application.getMajorVersion()%></li>
<li>minor version : <%=application.getMinorVersion()%></li>
<li>context real path : <%=application.getRealPath("")%></li>
<li>log : <% application.log(">>>>>>>> 현재날짜:"+new Date().toString()); %></li>
<xmp>
    1.web.xml설정한 파라메타
		<context-param>
			<param-name>contextPath</param-name>
			<param-value>/jspSite</param-value>
		</context-param>
	2. application.getInitParameter("contextPath")
</xmp>
<li>context path(parameter):<%=application.getInitParameter("contextPath")%>
</ol>
</body>
</html>
