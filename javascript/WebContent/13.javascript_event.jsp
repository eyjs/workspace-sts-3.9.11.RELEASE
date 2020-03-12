<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function displayMessage(msg){
		document.getElementById('result').innerHTML +=msg+"<br>";
	}
	function inlineEventHandler(e){
		var msg= 'inlineEventHandler:'+e.target+','+
										e.type+','+
										this+','+
										this.value;
		displayMessage(msg);
	}
	function button2EventHandler(e){
		var msg= 'button2EventHandler:'+e.target+','+
											e.type+','+
											this+','+
											this.value;
		displayMessage(msg);
	}
	function button3EventHandler1(e){
		var msg= 'button3EventHandler1:'+e.target+','+
											e.type+','+
											this+','+
											this.value;
		displayMessage(msg);
	}
	function button3EventHandler2(e){
		var msg= 'button3EventHandler2:'+e.target+','+
											e.type+','+
											this+','+
											this.value;
		displayMessage(msg);
	}
	function event_regist(){
		/***DOM LEVEL-0****/
		//var button2 = document.f.button2;
		//var button2E = document.getElementById('button2'); 	
		var button2E = document.getElementsByName('button2').item(0); 	
		button2E.onclick = button2EventHandler;
		/***DOM LEVEL-2****/
		var button3E = document.f.button3;
		button3E.addEventListener('click',button3EventHandler1,false);
		button3E.addEventListener('click',button3EventHandler2,false);
		button3E.addEventListener('mouseover',function(e){
			var msg= 'button3익명EventHandler1:'+e.target+','+
											e.type+','+
											this+','+
											this.value;
			displayMessage(msg);
		},false);
		button3E.addEventListener('mouseout',function(e){
			var msg= 'button3익명EventHandler2:'+e.target+','+
											e.type+','+
											this+','+
											this.value;
			displayMessage(msg);
		},false);
	
		document.f.button4.addEventListener('click', function(e) {
			/*
			이벤트핸들러제거
			*/
			//1.DOM LEVEL-0
			document.f.button1.onclick=null;
			document.f.button2.onclick=null;
			//2.DOM LEVEL-2
			document.f.button3
				.removeEventListener('click',button3EventHandler1,false);
			document.f.button3
				.removeEventListener('click',button3EventHandler2,false);
			
		}, false);
		var olistE = document.getElementById("movie_rank");
		var liNodeList = olistE.getElementsByTagName("li");
		for (var i = 0; i < liNodeList.length; i++) {
			liNodeList.item(i).addEventListener('click', function(e) {
				var movieNameStr=
					e.target.firstChild.nodeValue;
				displayMessage("click한 영화:"+movieNameStr);
			}, false);
		}
		
	}
	/*
	 window.onload 이벤트발생시점
	  - DOM트리로딩직후 랜더링(image)전에호출
	*/
	window.onload = event_regist;
	/*
	window.onload =function(){
		event_regist();
	};
	*/
	
</script>
</head>
<body>
<h1>javascript event</h1><hr/>
<form name="f">
	<input onclick="inlineEventHandler(event)" 
			name="button1" 
			type="button" 
			value="event model[inline]"/>
	<input id="button2" name="button2" type="button" value="event model[DOM level0]"/>
	<input name="button3" type="button" value="event model[DOM level2]"/>
	<input name="button4" type="button" value="event remove"/>
</form>
<ol id='movie_rank'>
	<li>조커</li>
	<li>람보</li>
	<li>AI</li>
	<li>알라딘</li>
	<li>체르노빌</li>
</ol>
<div id="result">
	
</div>
<script type="text/javascript">
	//event_regist();
</script>
</body>
</html>














