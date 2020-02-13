<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.Collections"%>

<%@page import="com.itwill.shop.cart.CartItem"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<CartItem> cartItemList=Arrays.asList(new CartItem("c001","p001",1,34000),
												new CartItem("c002","p005",2,34000),
												new CartItem("c006","p003",4,34000),
												new CartItem("c008","p002",3,34000),
												new CartItem("c003","p004",1,34000),
												new CartItem("c009","p008",1,34000)
												);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	
	function cart_ui_update(cartItemNo,cartItemProductNo){
		//alert("cart_ui_update: "+cartItemNo+","+cartItemProductNo);
		var cart_form=document.getElementById('cart_form_'+cartItemNo);
		cart_form.cart_item_qty.value = cart_form.cart_item_qty_ui.value;
		
		var cart_jumun_item_no_qty_element=document.getElementById('cart_jumun_item_no_qty_'+cartItemNo);
		cart_jumun_item_no_qty_element.value=cartItemProductNo+'-'+cart_form.cart_item_qty_ui.value;
		
		cart_update(cartItemNo, cartItemProductNo);
	}
	function cart_update(cartItemNo,cartItemProductNo){
		//alert("cart_update: "+cartItemNo+","+cartItemProductNo);
		
		var cart_form=document.getElementById('cart_form_'+cartItemNo);
		cart_form.method='GET';
		cart_form.action='00.javascript_cart_update_action.jsp'
		cart_form.submit();
		
		
	}
	function cart_delete(cartItemNo){
		//alert("cart_delete: "+cartItemNo);
		var cart_form=document.getElementById('cart_form_'+cartItemNo);
		cart_form.method='GET';
		cart_form.action='00.javascript_cart_delete_action.jsp'
		cart_form.submit();
	}
	
	function cart_jumun(){
		var cart_jumun_form=document.getElementById('cart_jumun_form');
		cart_jumun_form.action='00.javascript_cart_jumun_create_action.jsp';
		cart_jumun_form.method='GET';
		cart_jumun_form.submit();
	}
	function member_data_display(){
		document.getElementById("vmid").innerHTML = document.getElementById("imid").value;
		document.getElementById("vmname").innerHTML = document.getElementById("imname").value;
		document.getElementById("vmpostcode").innerHTML = document.getElementById("sample6_postcode").value;
		document.getElementById("vmaddress").innerHTML = document.getElementById("sample6_address").value;
		document.getElementById("vmdetailAddress").innerHTML = document.getElementById("sample6_detailAddress").value;
		document.getElementById("vmextraAddress").innerHTML = document.getElementById("sample6_extraAddress").value;
		
	}
	function member_data_remove(){
		document.getElementById("vmid").innerHTML = "";
		document.getElementById("vmname").innerHTML = "";
		document.getElementById("vmpostcode").innerHTML ="";
		document.getElementById("vmaddress").innerHTML = "";
		document.getElementById("vmdetailAddress").innerHTML = "";
		document.getElementById("vmextraAddress").innerHTML = "";
		
	}
	function jumun_address_input(event){
		if(event.target.checked){
			document.getElementById("jmid").innerHTML = document.getElementById("vmid").innerHTML;
			document.getElementById("jhmid").value = document.getElementById("vmid").innerHTML;
			document.getElementById("jmname").innerHTML=document.getElementById("vmname").innerHTML;
		    document.getElementById("jhmname").value=document.getElementById("vmname").innerHTML;
		    document.getElementById("jpostcode").value=document.getElementById("vmpostcode").innerHTML;
			document.getElementById("jaddress").value=document.getElementById("vmaddress").innerHTML;
			document.getElementById("jdetailAddress").value=document.getElementById("vmdetailAddress").innerHTML;
			document.getElementById("jextraAddress").value=document.getElementById("vmextraAddress").innerHTML;
		}else{
			document.getElementById("jmid").innerHTML = "";
			document.getElementById("jhmid").value = "";
			document.getElementById("jmname").innerHTML="";
		    document.getElementById("jhmname").value="";
		    document.getElementById("jpostcode").value="";
			document.getElementById("jaddress").value="";
			document.getElementById("jdetailAddress").value="";
			document.getElementById("jextraAddress").value="";
			
		}
	}
	
</script>
</head>
<body>
<%
for(int i=0;i<cartItemList.size();i++){
	CartItem cartItem = cartItemList.get(i);
%>
	<form id="cart_form_<%=cartItem.getCartItemNo()%>" name="cart_form_<%=cartItem.getCartItemNo()%>">
		<span>제품_<%=cartItem.getProductNo()%></span>
	    <input type="hidden"  name="cart_item_no" value="<%=cartItem.getCartItemNo() %>" >
	    <input type="hidden"  name="cart_item_product_no" value="<%=cartItem.getProductNo()%>">
	    <input type="hidden"  name="cart_item_qty" value="<%=cartItem.getQty()%>">
	    <input type="number"  name="cart_item_qty_ui" 
	    	onkeyup="cart_ui_update('<%=cartItem.getCartItemNo()%>','<%=cartItem.getProductNo()%>')"  
	    	onmouseup="cart_ui_update('<%=cartItem.getCartItemNo()%>','<%=cartItem.getProductNo()%>')" value="<%=cartItem.getQty()%>"  min="1" max="99" required="required">
	    <!-- 
	    <input type="button"  value="수정" onclick="cart_update('<%=cartItem.getCartItemNo()%>','<%=cartItem.getProductNo()%>')">
	     -->
	    <input type="button"  value="삭제" onclick="cart_delete('<%=cartItem.getCartItemNo()%>')">
	   <!-- 
	    <input type="date"    name="cart_date" value="2020-01-06" placeholder="2020-01-01"><br/>
	    <input type="search"  name="query"><br/>
	    <input type="range"   name="points" min="0" max="10" value="5"  placeholder="5"><br/>
	     -->
	</form>
<%} %>

<form id="cart_jumun_form" name="cart_jumun_form"  action="00.javascript_cart_jumun_create_action.jsp" >
	<%
	for(int i=0;i<cartItemList.size();i++){
		CartItem cartItem = cartItemList.get(i);
	%>
	 <input type="hidden" id="cart_jumun_item_no_qty_<%=cartItem.getCartItemNo()%>" name="cart_item_no_qty"  value="<%=cartItem.getProductNo()%>-<%=cartItem.getQty()%>">
	 
	<%
	}
	%>
	 <input type="button" onclick="cart_jumun();"  value="전체주문">
	 <br/>
	 <br/>
	 <br/>
	
	 
</form>

<h3>회원가입폼</h3><hr>
<form id="member_insert_form" name="member_insert_form">
	아이디:<input type="text" name="mid" id="imid"><br>
	이름:<input type="text" name="mname" id="imname"><br>
	주소:
	<!-- ------------------------daum 주소 api 시작----------------------------------------- -->
	<input type="text" id="sample6_postcode" placeholder="우편번호">
	<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
	<input type="text" id="sample6_address" placeholder="주소"><br>
	<input type="text" id="sample6_detailAddress" placeholder="상세주소"><br>
	<input type="text" id="sample6_extraAddress" placeholder="참고항목"><br>

	<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script>
	    function sample6_execDaumPostcode() {
	        new daum.Postcode({
	            oncomplete: function(data) {
	                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
	
	                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
	                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
	                var addr = ''; // 주소 변수
	                var extraAddr = ''; // 참고항목 변수
	
	                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
	                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
	                    addr = data.roadAddress;
	                } else { // 사용자가 지번 주소를 선택했을 경우(J)
	                    addr = data.jibunAddress;
	                }
	
	                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
	                if(data.userSelectedType === 'R'){
	                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
	                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
	                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
	                        extraAddr += data.bname;
	                    }
	                    // 건물명이 있고, 공동주택일 경우 추가한다.
	                    if(data.buildingName !== '' && data.apartment === 'Y'){
	                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	                    }
	                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
	                    if(extraAddr !== ''){
	                        extraAddr = ' (' + extraAddr + ')';
	                    }
	                    // 조합된 참고항목을 해당 필드에 넣는다.
	                    document.getElementById("sample6_extraAddress").value = extraAddr;
	                
	                } else {
	                    document.getElementById("sample6_extraAddress").value = '';
	                }
	
	                // 우편번호와 주소 정보를 해당 필드에 넣는다.
	                document.getElementById('sample6_postcode').value = data.zonecode;
	                document.getElementById("sample6_address").value = addr;
	                // 커서를 상세주소 필드로 이동한다.
	                document.getElementById("sample6_detailAddress").focus();
	            }
	        }).open();
	    }
	</script>
	<!-- ----------------------daum 주소 api 끝------------------------------- -->
	<input type="button" value="멤버보이기" onclick="member_data_display();"  >
	<input type="button" value="멤버지우기" onclick="member_data_remove();"  >
</form>
<br/>
<h3>회원정보보기</h3><hr>
<div>
	아이디:<span id="vmid"></span><br>
	이름:<span id="vmname"></span><br>
	고객주소<br>
	우편번호:<span id="vmpostcode"></span><br>
	주소:<span id="vmaddress"></span><br>
	상세주소:<span id="vmdetailAddress"></span><br>
	참고항목:<span id="vmextraAddress"></span><br>
	
</div>
<br>
<input type="checkbox" id="address_check" onchange="jumun_address_input(event);">고객정보를 배송주소로
<br>
<h3>회원주문정보</h3><hr>
<form id="member_jumun_form" name="member_jumun_form">
    <input type="hidden" id="jhmid"  name="mid">
    <input type="hidden" id="jhmname" name="mname">
    아이디:<span id="jmid"></span><br>
	이름:<span id="jmname"></span><br>
	고객주소<br>
	<input type="text" id="jpostcode" placeholder="우편번호">
	<input type="text" id="jaddress" placeholder="주소"><br>
	<input type="text" id="jdetailAddress" placeholder="상세주소"><br>
	<input type="text" id="jextraAddress" placeholder="참고항목"><br>
</form>
</body>
</html>











