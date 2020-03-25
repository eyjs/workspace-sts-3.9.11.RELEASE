
<%@page import="com.itwill.guest.Guest"%>
<%@page import="com.itwill.guest.GuestDao"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/xml; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%--@include file="loginCheck.jspf" --%>

<%
	String guest_no = request.getParameter("guest_no");
if(guest_no==null||guest_no.equals(""))guest_no="207";
	String method = request.getMethod();
	System.out.println("*********jQuery Ajax요청정보*********");
	System.out.println("1.jQuery Ajax요청방식    :" + method);
	System.out.println("2.jQuery Ajax요청파라메타:" + guest_no);
	System.out.println("*************************************");

	GuestDao dao = new GuestDao();
	Guest guest = dao.selectByNo(Integer.parseInt(guest_no.trim()));
%>
<guest_list> 
	<guest> 
		<guest_no><%=guest.getGuest_no()%></guest_no>
		<guest_name><%=guest.getGuest_name()%></guest_name>
		<guest_date><%=guest.getGuest_date()%></guest_date>
		<guest_email><%=guest.getGuest_email()%></guest_email>
		<guest_homepage><%=guest.getGuest_homepage()%></guest_homepage>
		<guest_title><%=guest.getGuest_title()%></guest_title>
		<guest_content><%=guest.getGuest_content()%></guest_content>
	</guest>
</guest_list> 
