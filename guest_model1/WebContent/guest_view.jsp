<%@page import="com.itwill.guest.Guest"%>
<%@page import="com.itwill.guest.GuestService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
/*
요청URL-->
  http://182.237.126.19/guest_model1/guest_view.jsp?guest_no=2
	1 . 파라메타받기
	2 . Service객체 메쏘드호출(업무처리)
	3 . 요청클라이언트로 응답 
*/
	String guest_noStr = request.getParameter("guest_no");
	if(guest_noStr==null||guest_noStr.equals("")){
		response.sendRedirect("guest_main.jsp");
		return;
	}
	GuestService guestService=new GuestService();
	Guest guest = guestService.selectByNo(Integer.parseInt(guest_noStr));
	if(guest==null){
%>
	<script>
		alert('존재하지않는 게시물입니다.');
		location.href='guest_list.jsp';
	</script>	
<%		
		return;
	}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>방명록 관리</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="css/styles.css">
<link rel="stylesheet"
	href="css/guest.css">
<script	src="js/guest.js"></script>
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
	<table border=0 cellpadding=0 cellspacing=0>
		<tr>
			<td>
				<!--contents--> <br />
				<table style="padding-left: 10px" border=0 cellpadding=0
					cellspacing=0>
					<tr>
						<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>방명록 관리 -
								방명록 상세보기</b></td>
					</tr>
				</table> <!-- view Form  -->
				<form name="f" method="post">
					<input type="hidden" name="guest_no" value="<%=guest_noStr%>" />
					<table border="0" cellpadding="0" cellspacing="1" width="590"
						bgcolor="BBBBBB">
						<tr>
							<td width=100 align=center bgcolor="E6ECDE" height="22">번호</td>
							<td width=490 bgcolor="ffffff" align="left"
								style="padding-left: 10px"><%=guest_noStr%></td>
						</tr>
						<tr>
							<td width=100 align=center bgcolor="E6ECDE" height="22">이름</td>
							<td width=490 bgcolor="ffffff" align="left"
								style="padding-left: 10px"><%=guest.guest_name%></td>
						</tr>
						<tr>
							<td width=100 align=center bgcolor="E6ECDE" height="22">날짜</td>
							<td width=490 bgcolor="ffffff" align="left"
								style="padding-left: 10px"><%=guest.guest_date.substring(0,10)%></td>
						<tr>
							<td width=100 align=center bgcolor="E6ECDE" height="22">홈페이지</td>
							<td width=490 bgcolor="ffffff" align="left"
								style="padding-left: 10px"><%=guest.guest_homepage %></td>
						</tr>
						<tr>
							<td width=100 align=center bgcolor="E6ECDE" height="22">제목</td>
							<td width=490 bgcolor="ffffff" align="left"
								style="padding-left: 10px"><%=guest.guest_title%></td>
						</tr>
						<tr>
							<td width=100 align=center bgcolor="E6ECDE" height="110">내용</td>
							<td width=490 bgcolor="ffffff" align="left"
								style="padding-left: 10px"><%=guest.guest_content%></td>
						</tr>
					</table>
				</form> <br />
				<table width=590 border=0 cellpadding=0 cellspacing=0>
					<tr>
						<td align=center>
						<input type="button" value="수정" onclick="guestModify();"> &nbsp; 
						<input type="button" value="삭제" onclick="guestRemove();"> &nbsp; 
						<input type="button" value="목록" onclick="guestList()"></td>
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
		<!-- footer end -->
	</div>
	<!--container end-->
</body>
</html>
