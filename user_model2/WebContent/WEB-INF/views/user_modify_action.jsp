<%@page import="java.net.URLEncoder"%>
<%@page import="com.itwill.user.User"%>
<%@page import="com.itwill.user.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(request.getMethod().equalsIgnoreCase("GET")){
		response.sendRedirect("user_main.jsp");
		return;
	}
	String userId=request.getParameter("userId");
	String password=request.getParameter("password");
	String name=request.getParameter("name");
	String email=request.getParameter("email");
	UserService userService=new UserService();
	try{
		userService.update(new User(userId,password,name,email));
		/*
		response.sendRedirect("user_view.jsp?userId="
	+URLEncoder.encode(userId,"EUC-KR"));
		*/
		RequestDispatcher rd=
	request.getRequestDispatcher("user_view.jsp");
		rd.forward(request, response);
		
	}catch(Exception e){
		response.sendRedirect("user_main.jsp");
		return;
	}
%>
