<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>방명록 관리</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript">
	function guest_write(actionUrl){
		/*
		왼쪽버튼   actionUrl--> 'parameter_guest_write_action.do'
		오른쪽버튼 actionUrl--> 'model_attribute_guest_write_action.do'
		*/
		window.document.f.action=actionUrl;
		window.document.f.method='POST';
		window.document.f.submit();
	}

</script>
</head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0
	marginwidth=0 marginheight=0>
	<!-- container start-->
	<div id="container">
		
		<div id="header">
		
		</div>
		
		<div id="navigation">
		
		</div>
	
		<div id="wrapper">

			<div id="content">
				<table width=0 border=0 cellpadding=0 cellspacing=0>
					<tr>
						<td>
							<!--contents--> <br />
							<table style="padding-left: 10px" border=0 cellpadding=0
								cellspacing=0>
								<tr>
									<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>방명록 관리
											- 방명록 쓰기</b></td>
								</tr>
							</table> <!-- guest write Form  -->
							<form name="f" method="post">
								<table border="0" cellpadding="0" cellspacing="1" width="590"
									bgcolor="BBBBBB">
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">이름</td>
										<td width=490 align="left" bgcolor="ffffff"
											style="padding-left: 10px"><input type="text"
											style="width: 150" name="guest_name"></td>
									</tr>
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">이메일</td>
										<td width=490 align="left" bgcolor="ffffff"
											style="padding-left: 10px"><input type="text"
											style="width: 150" name="guest_email"></td>
									</tr>
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">홈페이지</td>
										<td width=490 align="left" bgcolor="ffffff"
											style="padding-left: 10px"><input type="text"
											style="width: 150" name="guest_homepage"></td>
									</tr>
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">타이틀</td>
										<td width=490 align="left" bgcolor="ffffff"
											style="padding-left: 10px"><input type="text"
											style="width: 240" name="guest_title"></td>
									</tr>
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">내용</td>
										<td width=490 align="left" bgcolor="ffffff"
											style="padding-left: 10px"><textarea wrap="soft"
												style="width: 240px" rows="10" name="guest_content"></textarea>
										</td>
									</tr>
								</table>
								
							</form> <br />
							<table width=590 border=0 cellpadding=0 cellspacing=0>
								<tr>
									<td align=center>
									<input type="button" 
									onclick="guest_write('parameter_guest_write_action.do')" 
									value="방명록쓰기[parameter]"> &nbsp; 
								    <input type="button" 
								    onclick="guest_write('model_attribute_guest_write_action.do')" 
								    value="방명록쓰기[model attribute]"></td>
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
		
		</div>
	</div>
	<!--container end-->
</body>
</html>