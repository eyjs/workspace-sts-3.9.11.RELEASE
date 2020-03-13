<%@page import="com.itwill.user.exception.ExistedUserException"%>
<%@page import="com.itwill.user.User"%>
<%@page import="com.itwill.user.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>	
<%@ include file="user_login_check.jspf"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>사용자 관리</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=stylesheet href="css/styles.css" type="text/css">
<link rel=stylesheet href="css/user.css" type="text/css">
<script type="text/javascript">
	function userList() {
		f.action = "user_list.do";
		f.submit();
	}
	function userModify() {
		<c:if test="${sUserId eq user.userId}">
			document.f.action = "user_modify_form.do";
			document.f.submit();
		</c:if>
		<c:if test="${!(sUserId eq user.userId)}">
			alert("본인외에는 수정할수없어요!!");
		</c:if>
	}

	function userRemove() {
		<c:if test="${sUserId eq user.userId}">
		if (confirm("정말 삭제하시겠습니까?")) {
			document.f.action = "user_remove_action.do";
			document.f.method='POST';
			document.f.submit();
		}
		</c:if>
		<c:if test="${!(sUserId eq user.userId)}">
		 alert("본인외에는 삭제할수없어요!!");
		</c:if>
	}
	
</script>
</head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0
	marginwidth=0 marginheight=0>
	<!-- container start-->
	<div id="container">
		<!-- header start -->
		<div id="header">
			<!-- include_common_top.jsp start-->
			<jsp:include page="include_common_top.jsp" />
			<!-- include_common_top.jsp end-->
		</div>
		<!-- header end -->
		<!-- navigation start-->
		<div id="navigation">
			<!-- include_common_left.jsp start-->
			<jsp:include page="include_common_left.jsp" />
			<!-- include_common_left.jsp end-->
		</div>
		<!-- navigation end-->
		<!-- wrapper start -->
		<div id="wrapper">
			<!-- content start -->

			<!-- include_content.jsp start-->
			<div id="content">
				<table border=0 cellpadding=0 cellspacing=0>
					<tr>
						<td>
							<!--contents--> <br />
							<table style="padding-left: 10px" border=0 cellpadding=0
								cellspacing=0>
								<tr>
									<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>사용자 관리
											- 사용자 정보보기</b></td>
								</tr>
							</table>
							<!-- view Form  -->
							<form name="f" method="post">
								<input type="hidden" name="userId" value="${user.userId}" />
							<table border="0" cellpadding="0" cellspacing="1" width="590"
								bgcolor="BBBBBB">
								<tr>
									<td width=100 align=center bgcolor="E6ECDE" height="22">사용자
										아이디</td>
									<td width=490 bgcolor="ffffff" style="padding-left: 10">${user.userId}
									</td>
								</tr>
								<tr>
									<td width=100 align=center bgcolor="E6ECDE" height="22">이름</td>
									<td width=490 bgcolor="ffffff" style="padding-left: 10">${user.name}
									</td>
								</tr>
								<tr>
									<td width=100 align=center bgcolor="E6ECDE" height="22">이메일
										주소</td>
									<td width=490 bgcolor="ffffff" style="padding-left: 10">${user.email}
									</td>
								</tr>
							</table> 
							</form><br />
							<table border="0" cellpadding="0" cellspacing="1">
								<tr>
									<td align=center>
									<%--if(sUserId.equals(user.getUserId())){ --%>
										<input type="button" value="수정" onClick="userModify()"> &nbsp; 
										<input type="button" value="삭제" onClick="userRemove()"> &nbsp;
									<%--} --%> 
									<input type="button" value="목록" onClick="userList()"></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</div>

			<!-- include_content.jsp end-->
			<!-- content end -->
		</div>
		<!--wrapper end-->
		<div id="footer">
			<!-- include_common_bottom.jsp start-->
			<jsp:include page="include_common_bottom.jsp" />
			<!-- include_common_bottom.jsp end-->
		</div>
	</div>
	<!--container end-->
	
	
</body>
</html>