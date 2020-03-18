<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Spring XML,JSON,TEXT 응답</h1><hr>
<ol>
	<li><a href='response_string1'>String response1[MessageConverter]</a></li>
	<li><a href='response_string2'>String response2[MessageConverter]</a></li>
	<li><a href='newsTitleXML'>XML response[MessageConverter]News</a></li>
	<li><a href='newsTitleListXML'>XML List response[MessageConverter]List</a></li>
	<li><a href='newsTitleListResultXML'>XML List response[MessageConverter]NewsListResult </a></li>
	<li><a href='testMapXML'>XML response[MessageConverter] Map </a></li>
	<li><a href='newsTitleJson'>JSON response[MessageConverter] News </a></li>
	<li><a href='newsTitleListJson'>JSON response[MessageConverter] List </a></li>
	<li><a href='testMapJson'>JSON response[MessageConverter] Map </a></li>
	<li><a href='newsTitleXmlView'>XML response1[View]</a></li>
	<li><a href='newsTitleListResultXmlView'>XML response2[View]</a></li>
	<li><a href='newsTitleJsonView'>JSON response1[View]</a></li>
	<li><a href='newsTitleListJsonView'>JSON response2[View]</a></li>
	<li><a href='newsTitle.json'>ContentNegotiationResolver1[View]</a></li>
	<li><a href='newsTitle.xml'>ContentNegotiationResolver2[View]</a></li>
	<li><a href='newsTitleJsonOrXML'>ContentNegotiationResolver3[View]XML or JSON</a></li>
	
</ol>
</body>
</html>