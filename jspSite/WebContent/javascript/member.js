function load_focus() {
	document.getElementById("id").focus();
}
function join_form_submit_button() {
	
	var id = document.getElementById("id").value;
	if (is_null(id)) {
		alert('아이디를 입력하세요');
		document.getElementById("id").focus();
		return false;
	}
	var password = document.getElementById("password").value;
	if (is_null(password)) {
		alert('패쓰워드를 입력하세요');
		document.getElementById("password").focus();
		return false;
	}
	var repassword = document.getElementById("repassword").value;
	if (is_null(repassword)) {
		alert('패쓰워드확인을 입력하세요');
		document.getElementById("repassword").focus();
		return false;
	}
	// password,repassword
	if (!isSame(password, repassword)) {
		alert('패쓰워드와 패쓰워드확인은 일치하여야합니다');
		document.getElementById("repassword").select();
		return false;
	}
	return true;

}
function join_form_button() {

	var id = document.getElementById("id").value;
	if (id == null || id == '') {
		alert('아이디를 입력하세요');
		document.getElementById("id").focus();
		return;
	}
	var password = document.getElementById("password").value;
	if (password == null || password == '') {
		alert('패쓰워드를 입력하세요');
		document.getElementById("password").focus();
		return;
	}
	var repassword = document.getElementById("repassword").value;
	if (repassword == null || repassword == '') {
		alert('패쓰워드확인을 입력하세요');
		document.getElementById("repassword").focus();
		return;
	}
	// password,repassword
	if (!isSame(password, repassword)) {
		alert('패쓰워드와 패쓰워드확인은 일치하여야합니다');
		document.getElementById("repassword").select();
		return;
	}
	var joinFrm = document.getElementById("joinFrm");
	joinFrm.action = 'gaip.jsp';
	joinFrm.method = 'POST';
	joinFrm.submit();
	return;

}




