<%@page import="com.itwill.guest.GuestDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	GuestDao guestDao=new GuestDao();
	
%>
<%=guestDao.selectAll()%>
