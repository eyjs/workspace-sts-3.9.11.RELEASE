<%@page import="com.itwill.bean.Guest"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
 <%   
    Guest g1 = new Guest(1, "KIM", "2020", "guard1@naver.com", "http://www.itwill.com", "타이틀1", "컨텐트1");
	Guest g2 = new Guest(2, "SIM", "2021", "guard2@naver.com", "http://www.itwill.com", "타이틀2", "컨텐트2");
	Guest g3 = new Guest(3, "DIM", "2019", "guard3@naver.com", "http://www.itwill.com", "타이틀3", "컨텐트3");
	
	ArrayList<Guest> guestList = new ArrayList<Guest>();
	guestList.add(g1);
	guestList.add(g2);
	guestList.add(g3);

	Guest[] guestArray = new Guest[3];
	guestArray[0] = g1;
	guestArray[1] = g2;
	guestArray[2] = g3;
	
	HashMap<String,Guest> guestMap= new HashMap<String,Guest>();
	guestMap.put("g1", g1);
	guestMap.put("g2", g2);
	guestMap.put("g3", g3);
	
	request.setAttribute("guestMap", guestMap);
	request.setAttribute("guestList", guestList);
	request.setAttribute("guestArray", guestArray);
	/*
	request.setAttribute("setGuestList", guestList);
	*/
 %>  
<c:set var="setGuestList" scope="request"  value="${guestList}"/>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>JSTL core forEach tag</h1><hr>
	<ul>
		<li>---------array List--------------</li>
		<c:forEach items="${guestArray}" var="guest"  varStatus="status">
			<li>${status.index} --> ${guest.guest_no},${guest.guest_name}</li>		
		</c:forEach>
		<c:forEach 	var="guest" 
					items="${guestList}" 
					varStatus="status" 
					begin="1" 
					end="${guestList.size()}" 
					step="1">
			<li>${status.index} --> ${guest.guest_no},${guest.guest_name}</li>		
		</c:forEach>
		<li>---------Map--------------</li>
		<c:forEach var="guestEntry" items="${guestMap}">
			<li>${guestEntry.key}:
			${guestEntry.value.guest_no},${guestEntry.value.guest_name}
			</li>
		</c:forEach>
		<c:forEach var="guestEntry" items="${guestMap}" varStatus="st">
			<c:set var="guest"  scope="page" value="${guestEntry.value}"/>
			<li>${st.index} --> ${guest.guest_no},${guest.guest_name}</li>		
		</c:forEach>
	</ul>
	<br/>
	${setGuestList}
</body>
</html>











