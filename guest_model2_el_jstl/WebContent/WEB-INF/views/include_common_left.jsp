<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<p>
	<strong>메 뉴</strong>
</p>
<ul>
	<li><a href="guest_list.do"><fmt:message key="menu.list"/></a></li>
	<li><a href="guest_write_form.do"><fmt:message key="menu.write"/></a></li>
	<li><a href="index.jsp?language=ko">korean</a>|<a href="index.jsp?language=en">english</a></li>

</ul>
