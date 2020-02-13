<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(request.getMethod().equalsIgnoreCase("GET")){
		//response.sendRedirect("4.form.jsp");
		out.println("<script>");
		out.println("alert('GET방식으로요청하셨군요. 가입폼으로 이동합니다');");
		out.println("location.href='4.form.jsp';");
		out.println("</script>");
		return;
	}

	request.setCharacterEncoding("UTF-8");
	String id=request.getParameter("id");
	String pass=request.getParameter("pass");
	String addr=request.getParameter("addr");
	String[] hobbies = request.getParameterValues("hobby");
	if(hobbies==null){
		hobbies=new String[0];
	}
	String job = request.getParameter("job");
	String gender = request.getParameter("gender");
	
	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>가입결과</h1><hr/>
<ol>
	<li><%=id %></li>
	<li><%=pass %></li>
	<li><%=addr %></li>
	<%for(String hobby:hobbies){ %>
		<li><%=hobby %></li>
	<%}%>
	<li><%=gender %></li>
	<li><%=job %></li>
</ol>
</body>
</html>











