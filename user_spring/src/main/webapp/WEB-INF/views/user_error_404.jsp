<%@ page 
	language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="ko">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>에러페이지 | Credu</title>
    <link rel="stylesheet" href="http://ksp.credu.com/kspace/KOREAN/CKO/css/cko.css" type="text/css">
	<script type="text/javascript" src="/kspace/KOREAN/CKO/js/jquery-1.8.1.min.js"></script>
</head>
<body class="color_typeA"><!--칼라타입에 따라 color_typeA | color_typeB | color_typeC | color_typeD | color_typeE 로 변경됨  -->

<div class="error">
	<h1><strong>서비스 이용에 불편</strong>을 드려 대단히 <strong>죄송합니다.</strong></h1>	
	
	<!-- 페이지없음 -->
	<div class="error_box">
		<p>요청하신 페이지를 찾을 수 없거나 사용권한이 없습니다.</p>
		<ul>
			<li>입력하신 페이지 주소가 정확한지 다시 한번 확인해보시기 바랍니다.</li>
			<li>동일한 문제가 지속적으로 발생하실 경우에 서비스 이용 문의 부탁드립니다.</li>
		</ul>
	</div>
	<div class="wrap_admin">
		<h2>Help Desk</h2>
		<span>운영자에게 문의하시겠습니까?</span>
		<p class="tel">1544-9001</p>
		<ul class="time">
			<li>평일 08:00~ 20:00</li>
			<li>휴일 09:00~ 18:00</li>
		</ul>		
	</div>
	<div class="wrap_btns">
		<span class="btn round medium"><a href="javascript:history.back(-1);">이전 페이지로</a></span><!-- /ksp/jsp/gate/index.jsp?p_grcode=null -->
	</div>
</div>
</body>
</html>