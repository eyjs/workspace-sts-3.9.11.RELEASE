<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
<title>Template Test</title>
</head>
<body>
<table width="960" border="1" color="gray" align="center">
	<tr>
		<td height="43" colspan=3 align=left>
			<!-- top-->
		</td>
	</tr>
	<tr>
		<td width="15%" align=right valign=top><br>
			<!--left-->
		</td>
		<td colspan=2 align=center>
			<!--content-->
		</td>
	</tr>
	<tr>
		<td width="100%" height="40" colspan="3">
			<jsp:include page="bottom.jsp"/>
		</td>
	</tr>
</table>
</body>
</html>
