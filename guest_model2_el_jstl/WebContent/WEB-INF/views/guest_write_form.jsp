<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="com/itwill/guest/guest" scope="session"/>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title><fmt:message key="title.main"/></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="css/styles.css">
<link rel="stylesheet"
	href="css/guest.css">
<script type="text/javascript">
function guestList(){
	document.f.action='guest_list.do';
	document.f.method='POST';
	document.f.submit();
}
function guestWrite(){
	
	if (document.f.guest_name.value == "") {
		alert("이름을 입력하십시요.");
		document.f.guest_name.focus();
		return false;
	}
	if (document.f.guest_email.value == "") {
		alert("이메일을 입력하십시요.");
		document.f.guest_email.focus();
		return false;
	}
	if (document.f.guest_homepage.value == "") {
		alert("홈페이지를 입력하십시요.");
		document.f.guest_homepage.focus();
		return false;
	}

	if (document.f.guest_title.value == "") {
		alert("제목을 입력하십시요.");
		document.f.guest_title.focus();
		return false;
	}
	if (document.f.guest_content.value == "") {
		alert("내용을 입력하십시요.");
		document.f.guest_content.focus();
		return false;
	}
	document.f.action='guest_write_action.do';
	document.f.method='POST';
	document.f.submit();
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
		<!-- wrapper content start -->
		<div id="wrapper">
			
<div id="content">
	<table width=0 border=0 cellpadding=0 cellspacing=0>
		<tr>
			<td>
				<!--contents--> <br />
				<table style="padding-left: 10px" border=0 cellpadding=0
					cellspacing=0>
					<tr>
						<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b><fmt:message key="title.write"/></b></td>
					</tr>
				</table> <!-- guest write Form  -->
				<form name="f" method="post">
					<table border="0" cellpadding="0" cellspacing="1" width="590"
						bgcolor="BBBBBB">
						<tr>
							<td width=100 align=center bgcolor="E6ECDE" height="22"><fmt:message key="write.label.name"/></td>
							<td width=490 align="left" bgcolor="ffffff"
								style="padding-left: 10px"><input type="text"
								style="width: 150" name="guest_name"></td>
						</tr>
						<tr>
							<td width=100 align=center bgcolor="E6ECDE" height="22"><fmt:message key="write.label.email"/></td>
							<td width=490 align="left" bgcolor="ffffff"
								style="padding-left: 10px"><input type="text"
								style="width: 150" name="guest_email"></td>
						</tr>
						<tr>
							<td width=100 align=center bgcolor="E6ECDE" height="22"><fmt:message key="write.label.homepage"/></td>
							<td width=490 align="left" bgcolor="ffffff"
								style="padding-left: 10px"><input type="text"
								style="width: 150" name="guest_homepage"></td>
						</tr>
						<tr>
							<td width=100 align=center bgcolor="E6ECDE" height="22"><fmt:message key="write.label.title"/></td>
							<td width=490 align="left" bgcolor="ffffff"
								style="padding-left: 10px"><input type="text"
								style="width: 240" name="guest_title"></td>
						</tr>
						<tr>
							<td width=100 align=center bgcolor="E6ECDE" height="22"><fmt:message key="write.label.content"/></td>
							<td width=490 align="left" bgcolor="ffffff"
								style="padding-left: 10px">
								<textarea wrap="soft" style="width:240px" rows="10" name="guest_content"></textarea>
							</td>
						</tr>
					</table>
				</form> <br />
				<table width=590 border=0 cellpadding=0 cellspacing=0>
					<tr>
						<td align=center>
						<input type="button" value="<fmt:message key="write.button.write"/>" onClick="guestWrite();"> &nbsp; 
						<input type="button" value="<fmt:message key="write.button.list"/>" onClick="guestList()"></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</div>

		</div>
		<!-- wrapper content end-->
		<!-- footer start-->
		<div id="footer">
			<!-- include_common_bottom.jsp start-->
			<jsp:include page="include_common_bottom.jsp"/>
			<!-- include_common_bottom.jsp end-->
		</div>
	</div>
	<!--container end-->
</body>
</html>