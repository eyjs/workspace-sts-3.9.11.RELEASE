<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="0.multiparamter_form_action.jsp"> 
	<input type="hidden" name="cars[]" value="Volvo">
	<input type="hidden" name="cars[]" value="Saab">
	<input type="hidden" name="cars[]" value="Mercedes">
    <select multiple="multiple" name="cars[]"> 
        <option>Volvo</option> 
        <option>Saab</option> 
        <option>Mercedes</option> 
    </select>
    <input type="submit" value="submit">
</form>
</body>
</html>