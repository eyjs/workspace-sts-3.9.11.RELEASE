<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="7-2.login_check.jspf" %>
    
<%
	/*
	세션의무효화
	*/
	session.invalidate();
%>    
<h1>로그아웃</h1><hr>
<div>
	<%=loginId %>님 안녕히가세요
</div>
<div>
	<a href='7-2.default_session_login_form.jsp'>로그인</a>
	<a href='7-2.default_session_use1.jsp'>회원전용페이지1</a>
	<a href='7-2.default_session_use2.jsp'>회원전용페이지2</a>
</div>









