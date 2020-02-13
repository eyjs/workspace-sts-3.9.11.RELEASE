<%@page import="com.itwill.guest.GuestService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/*
	1.파라메타바끼
	2.GuestService.deleteGuest()메쏘드호출
	3.true -->guest_list.jsp redirection
      false-->guest_error.jsp redirection
	*/
%>
<%
	if(request.getMethod().equalsIgnoreCase("GET")){
		response.sendRedirect("guest_main.jsp");
		return;
	}

	/*
	    1 . 파라메타받기
		2 . Service객체 메쏘드호출(업무처리)
		3 . 요청클라이언트로 응답 
	*/
	String guest_noStr=request.getParameter("guest_no");
	GuestService guestService=new GuestService();
	boolean insertOK=
	guestService.deleteGuest(Integer.parseInt(guest_noStr));
	if(insertOK){
		response.sendRedirect("guest_list.jsp");
	}else{
		response.sendRedirect("guest_error.jsp");
	}
%>    