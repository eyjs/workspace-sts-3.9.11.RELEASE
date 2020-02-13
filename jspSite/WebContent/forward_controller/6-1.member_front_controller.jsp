<%@page import="java.util.ArrayList"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String cmd=request.getParameter("cmd");
	if(cmd==null){
		response.sendRedirect("6-1.member_menu.jsp");
		return;
	}	
	String forwardPath="";
	if(cmd.equals("member_list")){
		//MemberDao객체를 사용해서 ArrayList객체를 얻는다.
		ArrayList<String> memberList=new ArrayList<String>();
		memberList.add("이효리");
		memberList.add("신명숙");
		memberList.add("최경녀");
		memberList.add("김은희");
		
		request.setAttribute("memberList", memberList);
		forwardPath="6-1.member_list.jsp";
		
	}else if(cmd.equals("member_login")){
		
		forwardPath="6-1.member_login.jsp";
		
	}else if(cmd.equals("member_detail")){
		//MemberDao객체를 사용해서 MemberDto 객체를 얻는다.
		forwardPath="6-1.member_detail.jsp";
		request.setAttribute("member", "김은희");
	}else{
		forwardPath="error.jsp";
	}
%>
<jsp:forward page="<%=forwardPath%>"/>










 
