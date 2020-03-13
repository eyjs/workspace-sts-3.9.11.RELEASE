<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<p>
	<strong>메 뉴</strong>
</p>
<ul>
		<c:if test="${!empty(sUserId)}">
			<li><a href="user_view?userId=${sUserId}">${sUserId}님</a>&nbsp;
			<a href="user_logout_action">로그아웃</a></li>
			<li><a href='user_list'>회원리스트</a></li>
		</c:if>
		<c:if test="${empty(sUserId)}">
			<li><a href="user_write_form">회원가입</a></li>
			<li><a href="user_login_form">로그인</a></li>
		</c:if>

</ul>
<script type="text/javascript">
	function userLogin(){
		alert('로그인 하세요!!')
		location.href='user_login.jsp';
	}
</script>    

