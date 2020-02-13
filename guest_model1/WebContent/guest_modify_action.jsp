<%@page import="com.itwill.guest.Guest"%>
<%@page import="com.itwill.guest.GuestService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	/*
	1.파라메타바끼
	2.GuestService.updateGuest()메쏘드호출
	3.true -->guest_view.jsp redirection
	  false-->guest_error.jsp redirection
	*/
%>
<%
	if (request.getMethod().equalsIgnoreCase("GET")) {
		response.sendRedirect("guest_main.jsp");
		return;
	}
	request.setCharacterEncoding("UTF-8");
	String guest_noStr = request.getParameter("guest_no");
	String guest_name = request.getParameter("guest_name");
	String guest_email = request.getParameter("guest_email");
	String guest_homepage = request.getParameter("guest_homepage");
	String guest_title = request.getParameter("guest_title");
	String guest_content = request.getParameter("guest_content");
	GuestService guestService = new GuestService();
	Guest updateGuest = new Guest(Integer.parseInt(guest_noStr), guest_name, "", guest_email, guest_homepage,
			guest_title, guest_content);
	boolean updateOK = guestService.updateGuest(updateGuest);
	if (updateOK) {
		response.sendRedirect("guest_view.jsp?guest_no=" + guest_noStr);
	} else {
		response.sendRedirect("guest_error.jsp");
	}
%>