<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>NAVER LOGIN TEST</title>
</head>
<body>
	
	<hr>
	<br>
	<center>
		<c:choose>
			<c:when test="${id != null}">
				<h2>네이버 아이디 로그인 성공하셨습니다!!</h2>
				<h3>'${id}' 님 환영합니다!<img src='${profile_image}' width="100" height="100"></h3>
				<div>
					access_token:${access_token}<br/>
					name:${name}<br/>
					nickname:${nickname}<br/>
					age:${age}<br/>
					gender:${gender}<br/>
					email:${email}<br/>
					birthday:${birthday}<br/>
					
				</div>
				<h3>
					<a href="logout">로그아웃</a>
				</h3>
			</c:when>
			<c:otherwise>
				<h2>로그인</h2>
				<form action="login.userdo" method="post" name="frm"
					style="width: 470px;">
					
					<input type="text" name="id" id="id" class="w3-input w3-border"
						placeholder="아이디" value="${id}"> <br> <input
						type="password" id="pwd" name="pwd" class="w3-input w3-border"
						placeholder="비밀번호"> <br> <input type="submit"
						value="로그인" onclick="#"> <br>
				</form>
				<br>
				<!-- 네이버 로그인 창으로 이동 -->
				<div id="naver_id_login" style="text-align: center">
					<a href="${url}"> <img width="223"
						src="https://developers.naver.com/doc/review_201802/CK_bEFnWMeEBjXpQ5o8N_20180202_7aot50.png" /></a>
				</div>
				<br>
			</c:otherwise>
		</c:choose>
	</center>
</body>
</html>

