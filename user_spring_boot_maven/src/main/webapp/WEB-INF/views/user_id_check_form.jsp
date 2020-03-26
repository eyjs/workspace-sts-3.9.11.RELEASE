<%@page import="com.itwill.user.UserServiceImpl"%>
<%@page import="com.itwill.user.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	boolean isDuplicate=false;
	String msg="";
	String userId = request.getParameter("userId");
	if(userId==null){
		userId="";
		isDuplicate=false;
		
	}else{
	  UserService userService=new UserServiceImpl();
	  isDuplicate = userService.isDuplcateUserId(userId);
	  
	  if(isDuplicate){
		  msg="사용 불가능한 아이디입니다.";
	  }else{
		  msg="사용 가능한 아이디입니다.";
	  }
	}
%>	
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>아이디 중복 체크</title>
<!-- 
<link rel=stylesheet href="css/styles.css" type="text/css">
<link rel=stylesheet href="css/user.css" type="text/css">
 -->
<style type="text/css">
#wrap {
	width: 490px;
	text-align: center;
	margin: 0 auto 0 auto;
}

#chk {
	text-align: center;
}

#cancelBtn {
	visibility: visible;
}

#useBtn {
	visibility: visible;
}
</style>

<script type="text/javascript">
		// 아이디 중복체크
		function idCheck(){
			var userId = document.getElementById("userId").value;
			if (!userId) {
				alert("검색할 아이디를 입력하시고 중복체크를 하셔요.");
				return false;
			}else if((userId < "0" || userId > "9") && (userId < "A" || userId > "Z") && (userId < "a" || userId > "z")){
				alert("한글 및 특수문자는 아이디로 사용하실 수 없습니다.");
				return false;
			}else{
				var param="userId="+userId
				var url = "user_id_check_form.jsp?"+param;
				location.href=url;
			}
		}
		
		
		
		// 사용하기 클릭 시 부모창으로 값 전달 
		function sendCheckValue(){
			// 중복체크 결과인 idCheck 값을 전달한다.
			opener.document.f.idDuplication.value ="idCheck";
			// 회원가입 화면의 ID입력란에 값을 전달
			opener.document.f.userId.value = document.getElementById("userId").value;
			if (opener != null) {
            	opener.chkForm = null;
            	self.close();
            	//window.close();
			}	
		}	
		
	</script>

</head>
<body>
	<div id="wrap">
		<br> <b><font size="4" color="gray">아이디 중복체크</font></b>
		<hr size="1" width="460">
		<br>
		<div id="chk">
			<form id="checkForm">
				<input type="text" name="userId" id="userId" value="<%=userId%>"> <input
					type="button" value="중복확인" onclick="idCheck()">
			</form>
			<div id="msg"><%=msg%></div>
			
			<br> <input id="cancelBtn" type="button" value="취소" onclick="window.close()">
				<%if(!isDuplicate){ %>
				<input id="useBtn" type="button" value="사용하기" onclick="sendCheckValue()">
				<% }%>
		</div>
	</div>
</body>
</html>