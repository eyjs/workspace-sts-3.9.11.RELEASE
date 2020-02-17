<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String sUserId=(String)session.getAttribute("sUserId");
	boolean isLogin=false;
	if(sUserId!=null){
		isLogin=true;
	}
%>

<p>
	<strong>메 뉴</strong>
</p>
<ul>
		<%if(isLogin){ %>
			<li><a href="user_view.do?userId=<%=sUserId%>"><%=sUserId%>님</a>&nbsp;
			<a href="user_logout_action.do">로그아웃</a></li>
			<li><a href='user_list.do'>회원리스트</a></li>
		<%}else{ %>
			<li><a href="user_write_form.do">회원가입</a></li>
			<li><a href="user_login_form.do">로그인</a></li>
		<%} %>

</ul>

