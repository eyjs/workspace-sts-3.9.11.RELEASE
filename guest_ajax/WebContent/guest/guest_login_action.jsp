<%@ page language="java" contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String result="fail";
	request.setCharacterEncoding("utf-8");
	String guest_id=request.getParameter("guest_id");
	String guest_pass=request.getParameter("guest_pass");
	/*************************************/
	System.out.println("*********jQuery Ajax요청정보*********");
	System.out.println("0.jQuery Ajax요청URL    :" + request.getRequestURI());
	System.out.println("1.jQuery Ajax요청방식    :");
	System.out.println("2.jQuery Ajax요청파라메타:"+guest_id+","+guest_pass);
	System.out.println("*************************************");	
	/**************************************/
	
	if(guest_id==null)guest_id="";
	if(guest_pass==null)guest_pass="";
	/*  -----|------
		 id  | pass 
		-----|------	 
		user1|user2
		user1|user2
	*/
	if((guest_id.equals("user1") && guest_pass.equals("user1") )
		||(guest_id.equals("user2") && guest_pass.equals("user2"))){
		session.setAttribute("user_id", guest_id);
		result="success";
	}else{
		result="fail";
	}
%>
<%=result%>