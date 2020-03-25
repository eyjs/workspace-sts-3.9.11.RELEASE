<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");
	System.out.println(id);
	if(id==null)id="";
	String msg="";
	if(id.startsWith("guard")){
		msg="유효한아이디";
	}else if(!id.equals("")){
		msg="유효하지않은아이디";
	}else{
		msg="";
	}
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function idCheck(){
		var idStr = document.getElementById("id").value;
		console.log(idStr);
		if(idStr.length!=0 && idStr.trim()==""){
			return;
		}
		document.f.submit();
	}
	window.onload=function(){
		document.f.id.focus();
		document.f.id.setSelectionRange(
				f.id.value.length,f.id.value.length);
	}
</script>
</head>
<body>
<h1>페이지기반요청</h1><hr/>
<form action="01.pageRequest.jsp" name="f">
아이디:<input type="text"  id="id" name="id" value="<%=id %>" onkeyup="idCheck();">
<span id="msg"><%=msg%></span>
</form>
</body>
</html>