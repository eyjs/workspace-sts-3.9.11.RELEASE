<html>
    <head>
        <title>Spring 4 Security Example</title>
    </head>
    <body>
       <h3>Spring 4 Security Example</h3>
        <font color="red">
		   ${SPRING_SECURITY_LAST_EXCEPTION.message}
        </font>
		<form action="<%=request.getContextPath()%>/appLogin" method="POST">
			Enter UserName:	<input type="text" name="app_username"/><br/><br/>
			Enter Password: <input type="password" name="app_password"/> <br/><br/>			
			<input type="submit" value="Login"/>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>			
		</form>
    <body>
</html>  