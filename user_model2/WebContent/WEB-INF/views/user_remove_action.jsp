<%@page import="com.itwill.user.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(request.getMethod().equalsIgnoreCase("GET")){
		response.sendRedirect("user_main.jsp");
		return;
	}
	String userId = request.getParameter("userId");
	UserService userService=new UserService();
	try{
		userService.remove(userId);
		if(((String)session.getAttribute("sUserId")).equals(userId)){
	response.sendRedirect("user_logout_action.jsp");
		}else{
	response.sendRedirect("user_list.jsp");
		}
	}catch(Exception e){
		response.sendRedirect("user_error.jsp");
	}
%>