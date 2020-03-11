<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="jQuery.js"></script>
<script type="text/javascript" src="kQuery.js"></script>
<script type="text/javascript" src="05.javascript_function2_lib.js"></script>
<script type="text/javascript" >
	/*
	1. function객체를 변수에대입(일급함수)
	2. function객체를 파라메타데이타로사용
	3. function객체를 반환
	*/
   /*************파라메타로사용func**************/	
	function func1(){
		document.write("### func1()실행<br>");
	}
	function func2(){
		document.write("### func2()실행<br>");
	}
	/****************************************/
	/*
	function func3(f1){
		document.write("func3(f1)실행 start()<br>")
		f1();
		document.write("func3(f1)실행 end()<br>")
	}
	function func4(f1,f2){
		document.write("func4(f1,f2)실행 start()<br>")
		f1();
		f2();
		document.write("func4(f1,f2)실행 end()<br>")
	}
	*/
	/*************파라메타로사용func**************/	
	function func5(arg1){
		document.write("### func5("+arg1+")실행<br>");
	}
	function func6(arg1,arg2){
		document.write("### func6("+arg1+","+arg2+")실행<br>");
	}
	/****************************************/
	/*
	function func7(f5){
		document.write("func7(f5)실행 start()<br>")
		f5("func7에세입력한인자");
		document.write("func7(f5)실행 end()<br>")
	}
	function func8(f5,f6){
		document.write("func8(f5,f6)실행 start()<br>")
		f5("func8에세입력한인자1");
		f6("func8에세입력한인자1","func8에세입력한인자2");
		document.write("func8(f5,f6)실행 end()<br>")
	}
	*/
</script>
</head>
<body>
<h1>javascript function2</h1><hr>
<script type="text/javascript">
	func3(func1);
	func4(func1,func2);
	func7(func5);
	func8(func5,func6);
	func9(function(){
		document.write("### func9(funcArg)실행시에인자로 대입한익명함수실행<br>");
	});
	func10(function(){
		document.write("### func10(funcArg1,funcArg2)실행시에첫번째인자로 대입한익명함수실행<br>");
	},function(){
		document.write("### func10(funcArg1,funcArg2)실행시에두번째인자로 대입한익명함수실행<br>");
	});
	document.write("***********kQuey******************<br>");
	hello(function(recvMsg){
		/*
		 hello function에서 내가 인자로전달한 익명함수를 
		 인자를 넣어서호출
		*/
		document.write(recvMsg+"<br/>");
	}, "김태희");
	hello(function(recvMsg){
		document.write(recvMsg+"<br/>");
	}, "이소라");
	var nameArray=["김경호","김은희","신명숙","정봉화","최경녀"]
	
	forEach(nameArray, function(index,e){
		document.write(index+":"+e+"<br>");
	});
	
	document.write("**********jQuey*******************<br>");	
	
	jQuery.each(nameArray,function(index,e){
		document.write(index+":"+e+"<br>");	
	});
	
</script>
</body>
</html>







