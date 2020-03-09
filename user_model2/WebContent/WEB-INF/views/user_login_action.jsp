<%@page import="com.itwill.user.User"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="com.itwill.user.exception.PasswordMismatchException"%>
<%@page import="com.itwill.user.exception.UserNotFoundException"%>
<%@page import="com.itwill.user.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(request.getMethod().equalsIgnoreCase("GET")){
		response.sendRedirect("user_login_form.jsp");
		return;
	}
	try{
		//request.setCharacterEncoding("UTF-8");
		String userId=request.getParameter("userId");
		String password=request.getParameter("password");
		UserService userService=new UserService();
		User loginUser=userService.login(userId,password);
		session.setAttribute("sUserId", userId);
		session.setAttribute("sUser", loginUser);
		response.sendRedirect("user_main.jsp");
	
	}catch(UserNotFoundException e){
		/*****************case1[redirect]********************
		String msg1 = URLEncoder.encode(e.getMessage(),"UTF-8");
		response.sendRedirect("user_login_form.jsp?msg1="+msg1);
		********************************************/
		/*****************case2[forward]********************/
		request.setAttribute("msg1",e.getMessage());
		
		RequestDispatcher rd=
	request.getRequestDispatcher("user_login_form.jsp");
		rd.forward(request, response);
		
		/**************************************************/
	}catch(PasswordMismatchException e){
		/****************case1[redirect]***********************
		String msg2 = URLEncoder.encode(e.getMessage(),"UTF-8");
		response.sendRedirect("user_login_form.jsp?msg2="+msg2);
		*************************************************/
		/*****************case2[forward]********************/
		request.setAttribute("msg2", e.getMessage());
		RequestDispatcher rd=
		request.getRequestDispatcher("user_login_form.jsp");
		rd.forward(request, response);
		/***************************************************/
	}catch(Exception e){
		e.printStackTrace();
		//response.sendRedirect("user_error.jsp");
		RequestDispatcher rd=
		request.getRequestDispatcher("user_error.jsp");
	rd.forward(request, response);
	}
%>
