<%@page import="com.itwill.user.exception.ExistedUserException"%>
<%@page import="com.itwill.user.UserService"%>
<%@page import="com.itwill.user.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	/*
	if (request.getMethod().equalsIgnoreCase("GET")) {
		response.sendRedirect("user_write_form.jsp");
		return;
	}
	*/
	//request.setCharacterEncoding("UTF-8");
	String userId = request.getParameter("userId");
	String password = request.getParameter("password");
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	User newUser = null;
	try {
		UserService userService = UserService.getInstance();
		newUser = new User(userId, password, name, email);
		int insertRowCount=userService.create(newUser);
		
		response.sendRedirect("user_login_form.jsp");
	}catch(ExistedUserException e){
		/*
		out.println("<script>");
		out.println("alert('"+e.getMessage()+"');");
		out.println("location.href='user_write_form.jsp';");
		out.println("</script>");
		*/
		
		//<jsp:forward page="user_write_form.jsp"/>
		request.setAttribute("msg", e.getMessage());
		request.setAttribute("fuser", newUser);
		
		
		RequestDispatcher rd=
		request.getRequestDispatcher("user_write_form.jsp");
		rd.forward(request,response);
		//response.sendRedirect("user_write_form.jsp");
		return;
	} catch (Exception e) {
		e.printStackTrace();
		//response.sendRedirect("user_error.jsp");
		RequestDispatcher rd=
		request.getRequestDispatcher("user_error.jsp");
		rd.forward(request,response);
		return;
	}
%>















