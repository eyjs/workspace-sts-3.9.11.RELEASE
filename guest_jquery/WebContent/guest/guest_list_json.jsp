<%@page import="com.itwill.guest.Guest"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.itwill.guest.GuestDao"%>
<%@ page language="java" contentType="text/plain; charset=utf-8"
    pageEncoding="utf-8"%>
<%--@include file="loginCheck.jspf" --%>    
<%
String v1 = request.getParameter("v1");
String v2 = request.getParameter("v2");
if ((v1 == null|| v1.equals(""))||(v2 == null|| v2.equals(""))){
	v1 = "";
	v2 = "";
}
String method = request.getMethod();
System.out.println("*********jQuery Ajax요청정보*********");
System.out.println("0.jQuery Ajax요청URL    :" + request.getRequestURI());
System.out.println("1.jQuery Ajax요청방식    :" + method);
System.out.println("2.jQuery Ajax요청파라메타:" + v1+','+v2);
System.out.println("*************************************");

GuestDao dao=new GuestDao();
ArrayList<Guest> guestList =dao.guestList();
%>
[
<%
for(int i=0;i<guestList.size();i++){
	Guest guest=guestList.get(i);	
%>

{
"guest_no":"<%=guest.getGuest_no()%>",
"guest_name":"<%=guest.getGuest_name()%>",
"guest_date":"<%=guest.getGuest_date().substring(0,10)%>",
"guest_email":"<%=guest.getGuest_email()%>",
"guest_title":"<%=guest.getGuest_title()%>",
"guest_content":"<%=guest.getGuest_content()%>"
}
<%
if((i+1)!=guestList.size())
	out.print(",");
}
%>
]






