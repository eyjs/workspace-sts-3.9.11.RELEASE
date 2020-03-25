<%@ page language="java" contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id=request.getParameter("id");
	if(id==null)id="";
	String msg="";
	if(id.startsWith("guard")){
		msg="Y";
	}else{
		msg="N";
	}
	Thread.sleep(1000);
%>
<%=msg%>