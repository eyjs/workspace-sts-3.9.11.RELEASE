<%@ page language="java" contentType="text/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String isLogin="fail";
	String user_id=(String)session.getAttribute("user_id");
	if(user_id != null){
		isLogin="success";
	}
%>
{
	"status":"<%=isLogin%>",
	"login_id":"<%=user_id%>"
}