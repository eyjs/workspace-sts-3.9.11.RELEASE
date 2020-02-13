<%@page import="java.sql.Connection"%>
<%@page import="org.apache.commons.dbcp2.BasicDataSource"%>
<%@page import="org.apache.commons.dbcp2.BasicDataSourceFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String driverClass = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@182.237.126.19:1521:XE";
	String user = "javaspring31";
	String password = "javaspring31";
	BasicDataSource basicDataSource = new BasicDataSource();
	basicDataSource.setDriverClassName(driverClass);
	basicDataSource.setUrl(url);
	basicDataSource.setUsername(user);
	basicDataSource.setPassword(password);
	Connection con=basicDataSource.getConnection();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%=con %>
</body>
</html>