<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setBundle basename="classapth:/com/itwill/guest/guest" scope="session"/>        
<ul>
	<li>
	<a href="index.jsp?language=ko"><fmt:message key="menu.language.ko"/></a>|<a href="index.jsp?language=en"><fmt:message key="menu.language.en"/></a>
	</li>
</ul>
<p>
	<strong><fmt:message key="menu.title"/></strong>
</p>
<ul>
	<li><a href="guest_list.do"><fmt:message key="menu.list"/></a></li>
	<li><a href="guest_write_form.do"><fmt:message key="menu.write"/></a></li>
</ul>
