<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head><title>Spring 4 Security Example</title></head>
<body>
  <h3>Spring 4 Security Example </h3>
  <form:form action="result" method="POST" commandName="student">
    <form:input  path="stdId"/> <br/>
    <input type="submit" value="Submit">
  </form:form>
</body>
</html>   