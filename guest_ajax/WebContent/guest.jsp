<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko_KR">
<head>
<title>WELCOME TO AJAX</title>
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="style.css" />
<link rel="stylesheet" href="guest.css" type="text/css" media="screen" />
<style type="text/css">
input.error, textarea.error {
	border: 1px solid orange;
}

label.error {
	margin-left: 10px;
	color: orange;
}
</style>
<script src="./js/httpRequest.js" type="text/javascript"></script>

<!--
<script src="guest.js" type="text/javascript"></script>
-->
<script type="text/javascript">
	/*%%%%%%%%%%%%%%%%%%%%%%%응답도착했을시실행되는콜백함수%%%%%%%%%%%%%%%%%%%%%%%*/

	/****************guest_list[HTML]콜백함수******************/
	function displayGuestListHTML() {
		if(xhr.readyState==4){
			if(xhr.status==200){
				var htmlText = xhr.responseText;
				document.getElementById('guest_list')
					.innerHTML=htmlText;
				
				/*
				<div class="guest_item">
					<h3 class="guest_title"  guest_no="226">
						<a href=''>springTest11111[HTML]</a>
					</h3>
				</div>
				 */
				
			}
			showLoadingDialog(false);
		}
	}
	/****************guest_list[JSON]콜백함수******************/
	function displayGuestListJSON() {
		if(xhr.readyState==4){
			if(xhr.status==200){
				var jsonText = xhr.responseText;
				var jsonArray = JSON.parse(jsonText);
				
				document.getElementById('guest_list')
					.innerHTML=jsonText;
				
				
				/*
				<div class="guest_item">
					<h3 class="guest_title"  guest_no="2">
						<a href=''>springTest11111[HTML]</a>
					</h3>
				</div>
				 */
				
			}
			showLoadingDialog(false);
		}
		
	}
	/****************guest_list[XML]콜백함수******************/
	function displayGuestListXML() {
		if(xhr.readyState==4){
			if(xhr.status==200){
				//var xmlDoc = xhr.responseXML;
				var xmlStr = xhr.responseText;
				
				document.getElementById('guest_list')
					.innerHTML=xmlStr;
				
				
				/*
				<div class="guest_item">
					<h3 class="guest_title"  guest_no="2">
						<a href=''>springTest11111[HTML]</a>
					</h3>
					
				</div>
				 */
				
			}
			showLoadingDialog(false);
		}
	}
	/****************guest_insert_form[HTML]콜백함수******************/
	function displayGuestInsertForm() {
		if(xhr.readyState==4){
			if(xhr.status==200){
				var responseHtml = xhr.responseText;
				document.getElementById('guest_list')
					.innerHTML=responseHtml
			}
			showLoadingDialog(false);
		}
	}
	/****************guest_detail[JSON]콜백함수******************/
	function displayGuestDetailJSON(element) {

	}
	/****************guest_detail[XML]콜백함수******************/
	function displayGuestDetailXML(element) {

	}
	/****************guest_detail[HTML]콜백함수******************/
	function displayGuestDetailHTML(element) {
		/*
		element--> h3
		*/
		if(xhr.readyState==4){
			if(xhr.status==200){
				var htmlData=xhr.responseText;
				/*
				<div class="guest_date">
					날짜:2020-03-17 18:04:47
				</div>
				<div class="guest_name">
					이름:김경호
				</div>
						...
				*/
				var divE=document.createElement('div');
				divE.setAttribute('class','guest_detail');
				divE.style.display='block';
				/*************삭제수정UI추가***********/
				htmlData += "<div class='guest_delete' style='display: block;'>";
				var guest_no = element.getAttribute('guest_no');
				htmlData += "<input type='button' value='삭제' guest_no='"+guest_no+"'>";
				htmlData += "<input type='button' value='수정' guest_no='"+guest_no+"'>";
				htmlData += "</div>";
				/***********************************/
				divE.innerHTML=htmlData;
				
				/*
				<div class='guest_detail'>
					<div class="guest_date">
						날짜:2020-03-17 18:04:47
					</div>
					<div class="guest_name">
						이름:김경호
					</div>
					..
				</div>
				
				*/
				element.parentElement.appendChild(divE);
				/*
				<div class="guest_item">
					<h3 class="guest_title"  guest_no="2">
						<a href=''>springTest11111[HTML]</a>
					</h3>
					<div class='guest_detail'>
						<div class="guest_date">
							날짜:2020-03-17 18:04:47
						</div>
						<div class="guest_name">
							이름:김경호
						</div>
						..
					</div>
				</div>
				*/
			}
		}
		
	}

	/****************guest_insert_action[text]콜백함수******************/
	function displayGuestInertAction() {
		if(xhr.readyState==4){
			if(xhr.status==200){
				var recvText = xhr.responseText;
				if(recvText.trim()=='true'){
					sendRequest(
							'guest/guest_list_html.jsp',
							null,
							displayGuestListHTML,
							'GET',true);
					
				}else{
					alert('쓰기실패!!');
					/*
					showLoadingDialog(true);
					
					setInterval(function(){
						showLoadingDialog(false);
					},1000);
					*/
				}
			}
			
		}
	}
	/****************guest_logout_action[text]콜백함수*****************/
	function displayGuestLogoutAction(){
		if(xhr.readyState==4){
			if(xhr.status==200){
				location.href='guest.jsp';
				//로그아웃
				/*
				//login form show
				document.getElementById('guest_login_form')
					.style.display='block';
				document.getElementById('guest_login_form').reset();
				
				
				//logout form hide
				document.getElementById('guest_logout_form')
					.style.display='none';
				document.getElementById('idSpan').innerHTML='';
				*/
			}
		}
		
		
	}
	/****************guest_login_action[text]콜백함수******************/
	function displayGuestLoginAction(){
		if(xhr.readyState==4){
			if(xhr.status==200){
				var loginResultText=xhr.responseText;
				if(loginResultText.trim()=='success'){
					location.href='guest.jsp';
					//로그인성공
					/*
					//login form hide
					document.getElementById('guest_login_form')
						.style.display='none';
					document.getElementById('idSpan').innerHTML 
						= document.getElementById('guest_login_form').guest_id.value;
					//logout form show
					document.getElementById('guest_logout_form')
						.style.display='block';
					*/
					
				}else{
					//로그인실패
					document.querySelector('#guest_login_form').guest_id.select();
					document.querySelector('#msg').innerHTML
						='아이디와 패쓰워드를 확인하세요';
					document.querySelector('#msg').style.color='red';
				}
			}
		}
	}
	
	function login_check(){
		var jsonResult = null;
		sendRequest('guest/guest_session_check.jsp',null,function(){
			if(xhr.readyState==4){
				//로그인체크결과 도착
				/*
				{
					"status": "success",
					"login_id": "user1"
				}
				*/
				jsonResult=JSON.parse(xhr.responseText);
			}	
		},'POST',false);
		
		return jsonResult;
	}
	
	/*%%%%%%%%%%%%%%%%%%%%%%%메뉴 UI이벤트처리%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%*/
	window.onload = loading_ui_event;
	function loading_ui_event() {
		/*******login check후 UI보여주기**************/
		var loginResultJson = login_check();
		console.log(loginResultJson);
		if(loginResultJson.status.trim()=='success'){
			//logout form show
			document.getElementById('guest_logout_form')
				.style.display='block';
			document.getElementById('idSpan').innerHTML=loginResultJson.login_id;
			//login form hide
			document.getElementById('guest_login_form')
			.style.display='none';
		}else{
			//login form show
			document.getElementById('guest_login_form')
				.style.display='block';
			document.getElementById('guest_login_form').reset();
			//logout form hide
			document.getElementById('guest_logout_form')
			.style.display='none';
			document.getElementById('idSpan').innerHTML='';
		}
		
		
		/**************guest_list[HTML]이벤트*****************/
		document.getElementById('menu-a')
			.getElementsByTagName('a').item(0)
			.addEventListener('click',function(e){
				//ajax요청
				sendRequest('guest/guest_list_html.jsp',
							null,
							displayGuestListHTML,
							'GET',true);
				showLoadingDialog(true);
				e.preventDefault();
			});
		
		/*******************guest_list[JSON]이벤트************/
		document.getElementById('menu-b')
			.getElementsByTagName('a').item(0)
			.addEventListener('click',function(e){
				//ajax요청
				sendRequest('guest/guest_list_json.jsp',
							null,
							displayGuestListJSON,
							'GET',true);
				showLoadingDialog(true);
				e.preventDefault();
			});
		/*******************guest_list[XML]이벤트*************/
		document.getElementById('menu-c')
			.getElementsByTagName('a').item(0)
			.addEventListener('click',function(e){
				//ajax요청
				sendRequest('guest/guest_list_xml.jsp',
							null,
							displayGuestListXML,
							'GET',true);
				showLoadingDialog(true);
				e.preventDefault();
			});
		/**************guest_logout 이벤트[a]*****************/	
		document.querySelector('#guest_logout_a')
			.addEventListener('click',function(){
				//ajax로그아웃요청
				sendRequest('guest/guest_logout_action.jsp',
							null,displayGuestLogoutAction,
							'GET',true);
			});
		
		/*******************guest_insert_form[HTML]이벤트*****/
		document.getElementById('menu-d')
			.getElementsByTagName('a').item(0)
			.addEventListener('click',function(e){
				//ajax요청
				sendRequest('guest_insert_form.html',
							null,
							displayGuestInsertForm,
							'GET',true);
				showLoadingDialog(true);
				e.preventDefault();
			});
		/**************guest_login_form이벤트[submit]*********/
		document.getElementById('guest_login_form')
				.addEventListener('submit',function(e){
					var guest_login_formE = e.target;
					var guest_idStr = guest_login_formE.guest_id.value;
					var guest_passStr = guest_login_formE.guest_pass.value;
					if(guest_idStr==''|| guest_passStr==''){
						guest_login_formE.guest_id.focus();
						document.getElementById('msg').innerHTML
							='아이디와패쓰워드를 입력하세요';
						document.getElementById('msg').style.color='red';
						e.preventDefault();
						return;
					}
					//ajax login 요청
					var params='guest_id='+guest_idStr+"&guest_pass="+guest_passStr;
					sendRequest('guest/guest_login_action.jsp',
							params,displayGuestLoginAction,'POST',true);
					
					
					e.preventDefault();
					
				});
		
		
	}//onload event end
	/*%%%%%%%%%%%%%%%%%%%%%%%메뉴 UI이벤트처리 끝%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%*/
	
	/*%%%%%동적으로추가되는 Node 이벤트처리[DOMNodeInserted이벤트]시작%%%%%%*/
	
	document.addEventListener('DOMNodeInserted',function(e){
		if(e.target.id == 'guest_write_form'){
			/*****방명록쓰기폼 submit event등록******/
			var guestWriteFormE = e.target;
			guestWriteFormE.addEventListener('submit',function(e1){
				
				var url='guest/guest_insert_action.jsp';
				var params='guest_name='+ guestWriteFormE.guest_name.value+'&'+
						   'guest_title='+ guestWriteFormE.guest_title.value+'&'+
						   'guest_content='+ guestWriteFormE.guest_content.value+'&'+
						   'guest_email='+ guestWriteFormE.guest_email.value+'&'+
						   'guest_homepage='+ guestWriteFormE.guest_homepage.value;
						   
				var callback=displayGuestInertAction;
				var method='POST';
				var async=true;
				//방명록쓰기ajax요청
				sendRequest(url, params, callback, method, async);
				e1.preventDefault();
			});
		}else if(e.target.tagName=='DIV' && e.target.className=='guest_item'){
			/*
			<div class="guest_item">
				<h3 class="guest_title" guest_no="89"><a href="">b[HTML]</a></h3>
			</div>
			*/
			/*****방명록상세보기 a click event등록******/
			e.target.getElementsByTagName('a')
				.item(0)
				.addEventListener('click',function(e2){
					if(e2.target.parentNode.parentNode.childElementCount >  1){
						//방명록상세보기ajax요청안함
						if(e2.target.parentNode.parentNode.lastChild.style.display=='block'){
							e2.target.parentNode.parentNode.lastChild.style.display='none';
						}else{
							e2.target.parentNode.parentNode.lastChild.style.display='block';
						}
							
					}else{
						
						var guest_no = e2.target.parentElement.getAttribute('guest_no');
						if(e2.target.innerHTML.endsWith('[HTML]')){
							//방명록상세보기ajax요청[HTML]
							sendRequest('guest/guest_detail_html.jsp',
										'guest_no='+guest_no,function(){
											displayGuestDetailHTML(e2.target.parentElement);
										},
										'GET',true);
						}else if(e2.target.innerHTML.endsWith('[JSON]')){
							//방명록상세보기ajax요청[JSON]
							
							sendRequest('guest/guest_detail_json.jsp',
										'guest_no='+guest_no,function(){
											displayGuestDetailJSON(e2.target.parentElement);
										},
										'GET',true);
							
						}else if(e2.target.innerHTML.endsWith('[XML]')){
							//방명록상세보기ajax요청[XML]
							
							sendRequest('guest/guest_detail_xml.jsp',
										'guest_no='+guest_no,function(){
											displayGuestDetailXML(e2.target.parentElement);
										},
										'GET',true);
							
						
						}
						
						
						
					}
					
					e2.preventDefault();
				});
		}
		
	});
	/*%%%%%동적으로추가되는 Node 이벤트처리[DOMNodeInserted이벤트]끝%%%%%%*/
	/*******************DOMNodeInserted이벤트*************/
	/*******************guest_detail[HTML]이벤트**********/
	
	/*******loading dialog************/
	function showLoadingDialog(isVisible){
		if(isVisible){
			var dialogDivE = document.createElement('div');
			dialogDivE.setAttribute('id','loading');
			dialogDivE.innerHTML='loading...';
			dialogDivE.style.display='block';
			var guestListDivE = document.getElementById('guest_list');
			guestListDivE.parentElement.insertBefore(dialogDivE, guestListDivE);
			
		}else{
			var loadingDivE = document.getElementById('loading');
			if(loadingDivE!=null){
				loadingDivE.parentElement.removeChild(loadingDivE);
			}
		}
	}
	
</script>
</head>
<body>
	<div id="container">
		<div id="header">
			<h1>WELCOME TO AJAX</h1>
		</div>
		<div id="sidebar">

			<h2>회원관리메뉴</h2>
			<div class="menus">
				<div class="menu" id="menu-a">
					<h3>
						<a href="test.jsp">방명록 리스트[html]</a>
					</h3>
				</div>
				<div class="menu" id="menu-b">
					<h3>
						<a href="#">방명록 리스트[json]</a>
					</h3>
				</div>
				<div class="menu" id="menu-c">
					<h3>
						<a href="#">방명록 리스트[xml]</a>
					</h3>
				</div>
				<div class="menu" id="menu-d">
					<h3>
						<a href="#">방명록 쓰기</a>
					</h3>
				</div>
				
				<form id="guest_login_form" method="get" action="vfbfcv">
					<fieldset>
						<legend>로그인</legend>
						<p>
							<label for="guest_id">아이디:</label> <input type="text"
								id="guest_id" name="guest_id" />
						</p>
						<p>
							<label for="guest_pass">패쓰워드:</label> <input type="text"
								name="guest_pass" id="guest_pass" />
						</p>
						<p>
							<input type="submit" name="write" value="로그인" id="write" /> <input
								type="reset" name="cancle" value="취소" id="cancle" />

						</p>
						<div id="msg"></div>
					</fieldset>
				</form>
				<form id="guest_logout_form">
					<div>
						<span id="idSpan"></span>님 로그인<br /> <a id="guest_logout_a" href='#'>로그아웃</a>
					</div>
				</form>
				
			</div>
		</div>
		<div id="content">
		    <!--  
			<div id='loading'>loading..</div>
			-->
			<div id="guest_list">
			
				<!-- 
              
                 -->
			</div>
		</div>
		<div id="footer">
			<p>This page was built for jquery demonstration purposes.</p>
		</div>

	</div>

</body>
</html>
