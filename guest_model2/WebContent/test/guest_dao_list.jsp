<%@page import="com.itwill.guest.GuestDaoImplJDBC"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	GuestDaoImplJDBC guestDao=new GuestDaoImplJDBC();
%>
<%=guestDao.selectAll()%>
