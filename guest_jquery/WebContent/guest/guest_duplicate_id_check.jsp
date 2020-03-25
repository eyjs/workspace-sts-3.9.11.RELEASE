<%@ page language="java" contentType="text/plain; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String guest_id=request.getParameter("guest_id");
	
	if(guest_id==null){
		guest_id="";
	}
	String result="";
	if(!guest_id.startsWith("guard")){
		result="true";
	}else{
		result="false";
	}
	System.out.println("guest_email_check.jsp-->"+guest_id+":"+result);
%>
<%=result%>