<%@page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 

<< docBase >>
C:\JAVA_SPRING\program\sts-bundle\pivotal-tc-server\instances\base-instance\work\Catalina\localhost\jspSite

 -->
 	<%
 	for(int i=0;i<10;i++){
    	out.print("<h1>Hello JSP(안녕JSP) "+(i+1)+"</h1><hr>");
	}
	%>
	<hr/>
	<%@ include file="5-6.directive_included_file.jspf" %>
</body>
</html>
