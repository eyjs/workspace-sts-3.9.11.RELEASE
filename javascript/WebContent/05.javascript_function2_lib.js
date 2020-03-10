

function func3(f1) {
	document.write("func3(f1)실행 start()<br>")
	f1();
	document.write("func3(f1)실행 end()<br>")
}
function func4(f1, f2) {
	document.write("func4(f1,f2)실행 start()<br>")
	f1();
	f2();
	document.write("func4(f1,f2)실행 end()<br>")
}
function func7(f5) {
	document.write("func7(f5)실행 start()<br>")
	f5("func7에세입력한인자");
	document.write("func7(f5)실행 end()<br>")
}
function func8(f5, f6) {
	document.write("func8(f5,f6)실행 start()<br>")
	f5("func8에세입력한인자1");
	f6("func8에세입력한인자1", "func8에세입력한인자2");
	document.write("func8(f5,f6)실행 end()<br>")
}

function func9(funcArg){
	document.write("func9(funcArg)실행 start()<br>")
	funcArg();
	document.write("func9(funcArg)실행 end()<br>")
}

function func10(funcArg1,funcArg2){
	document.write("func10(funcArg1,funcArg2)실행 start()<br>")
	funcArg1();
	funcArg2();
	document.write("func10(funcArg1,funcArg2)실행 end()<br>")
}















