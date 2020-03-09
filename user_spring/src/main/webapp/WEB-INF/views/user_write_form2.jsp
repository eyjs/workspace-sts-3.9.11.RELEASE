<%@page import="com.itwill.user.User"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	User fuser=(User)request.getAttribute("fuser");
	if(fuser==null){
		fuser = new User("","","","");
	}
	String MSG=(String)request.getAttribute("MSG");
	if(MSG==null){
		MSG="";
	}
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>사용자 관리</title>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<link rel=stylesheet href="css/styles.css" type="text/css">
<link rel=stylesheet href="css/user.css" type="text/css">
<style type="text/css" media="screen">
</style>
<script type="text/javascript">
	function userCreate() {
		if (document.f.userId.value == "") {
			alert("사용자 아이디를 입력하십시요.");
			f.userId.focus();
			return false;
		}
		if (document.f.password.value == "") {
			alert("비밀번호를 입력하십시요.");
			f.password.focus();
			return false;
		}
		if (document.f.password2.value == "") {
			alert("비밀번호확인을 입력하십시요.");
			f.password2.focus();
			return false;
		}
		if (document.f.name.value == "") {
			alert("이름을 입력하십시요.");
			f.name.focus();
			return false;
		}
		if (document.f.email.value == "") {
			alert("이메일 주소를 입력하십시요.");
			f.email.focus();
			return false;
		}
		if (f.password.value != f.password2.value) {
			alert("비밀번호와 비밀번호확인은 일치하여야합니다.");
			f.password.focus();
			f.password.select();
			return false;
		}
		if (document.f.idDuplication.value!='idCheck') {
			alert("아이디중복체크를 하여야합니다.");
			document.f.userId.focus();
			document.f.userId.select();
			
			return false;
		}
		document.f.action = "user_write_action.jsp";
		document.f.method='POST';
		document.f.submit();
	}

	
	function userList() {
		f.action = "user_list.jsp";
		f.submit();
	}
	
	// 아이디 중복체크 화면open
	function openIdChk(){
		/*
		if (document.f.userId.value == "") {
			alert("아이디를 입력하십시요.");
			document.f.userId.focus();
			return false;
		}
		*/
		var param="?userId="+document.f.userId.value;
		window.name = "parentForm";
		window.open("user_id_check_form.jsp"+param,
				"chkForm", "width=500,height=300,resizable = no,scrollbars = no");	
	}

	// 아이디 입력창에 값 입력시 hidden에 idUncheck를 세팅한다.
	// 이렇게 하는 이유는 중복체크 후 다시 아이디 창이 새로운 아이디를 입력했을 때
	// 다시 중복체크를 하도록 한다.
	function inputIdChk(){
		document.userInfo.idDuplication.value ="idUncheck";
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
			<jsp:include page="include_common_top.jsp"/>
			<!-- include_common_top.jsp end-->
		</div>
		<!-- header end -->
		<!-- navigation start-->
		<div id="navigation">
			<!-- include_common_left.jsp start-->
			<jsp:include page="include_common_left.jsp"/>
			<!-- include_common_left.jsp end-->
		</div>
		<!-- navigation end-->
		<!-- wrapper start -->
		<div id="wrapper">
			<!-- content start -->
			<!-- include_content.jsp start-->
			<div id="content">
				<table width=0 border=0 cellpadding=0 cellspacing=0>
					<tr>
						<td>
							<!--contents--> <br />
							<table style="padding-left: 10px" border=0 cellpadding=0
								cellspacing=0>
								<tr>
									<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>사용자 관리
											- 회원 가입</b></td>
								</tr>
							</table> <!-- write Form  -->
							<form name="f" method="post">
								<table border="0" cellpadding="0" cellspacing="1" width="590"
									bgcolor="BBBBBB">
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">사용자
											아이디</td>
										<td width=490 bgcolor="ffffff" style="padding-left: 10px" align="left">
											<input type="text" readonly="readonly" style="width: 150px" name="userId"  value="<%=fuser.getUserId()%>">&nbsp;&nbsp;
											<input type="button" value="아이디중복검사" onclick="openIdChk();">
											<input type="hidden" name="idDuplication" value="idUncheck" >
											<font color="red"><%=MSG%></font>
										</td>
									</tr>
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">비밀번호</td>
										<td width=490 bgcolor="ffffff" style="padding-left: 10px" align="left">
											<input type="password" style="width: 150px" name="password"
											value="<%=fuser.getPassword()%>">
										</td>
									</tr>
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">비밀번호
											확인</td>
										<td width=490 bgcolor="ffffff" style="padding-left: 10px" align="left">
											<input type="password" style="width: 150px" name="password2"
											value="<%=fuser.getPassword()%>">
										</td>
									</tr>
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">이름</td>
										<td width=490 bgcolor="ffffff" style="padding-left: 10px" align="left">
											<input type="text" style="width: 150px" name="name"
											value="<%=fuser.getName()%>">
										</td>
									</tr>
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">이메일
											주소</td>
										<td width=490 bgcolor="ffffff" style="padding-left: 10px" align="left">
											<input type="text" style="width: 150px" name="email"
											value="<%=fuser.getEmail()%>">
										</td>
									</tr>
								</table>
							</form> <br />

							<table border=0 cellpadding=0 cellspacing=1>
								<tr>
									<td align=center><input type="button" value="회원 가입"
										onClick="userCreate()"> &nbsp; <input type="button"
										value="목록" onClick="userList()"></td>
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
			<jsp:include page="include_common_bottom.jsp"/>	
			<!-- include_common_bottom.jsp end-->
		</div>
	</div>
	<!--container end-->
</body>
</html>