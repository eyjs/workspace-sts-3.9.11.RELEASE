<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.Collections"%>

<%@page import="com.itwill.shop.cart.CartItem"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<CartItem> cartItemList=Arrays.asList(new CartItem("c001","p001",1,34000),
												new CartItem("c002","p005",1,34000),
												new CartItem("c006","p003",1,34000),
												new CartItem("c008","p002",1,34000),
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
		var ff=document.getElementById('cart_form_'+cartItemNo);
		ff.cart_item_qty.value = ff.cart_item_qty_ui.value;
		var jumin_cart_item_no_qty_element=document.getElementById('cart_item_no_qty_'+cartItemNo);
		jumin_cart_item_no_qty_element.value=cartItemProductNo+'-'+ff.cart_item_qty_ui.value;
	}
	function cart_update(cartItemNo,cartItemProductNo){
		//alert("cart_update: "+cartItemNo+","+cartItemProductNo);
		
		var ff=document.getElementById('cart_form_'+cartItemNo);
		ff.method='GET';
		ff.action='0.multiparamter_cart_update_action.jsp'
		ff.submit();
	}
	function cart_delete(cartItemNo){
		//alert("cart_delete: "+cartItemNo);
		var ff=document.getElementById('cart_form_'+cartItemNo);
		ff.method='GET';
		ff.action='0.multiparamter_cart_delete_action.jsp'
		ff.submit();
	}
	
	function cart_jumun(){
		document.cart_jumun_form.action='0.multiparamter_cart_jumun_create_action.jsp';
		document.cart_jumun_form.method='GET';
		document.cart_jumun_form.submit();
	}
</script>
</head>
<body>
<%
for(int i=0;i<cartItemList.size();i++){
	CartItem cartItem = cartItemList.get(i);
%>
	<form id="cart_form_<%=cartItem.getCartItemNo()%>" name="f<%=cartItem.getCartItemNo()%>">
		<span>제품_<%=cartItem.getProductNo()%></span>
	    <input type="hidden"  name="cart_item_no" value="<%=cartItem.getCartItemNo() %>" >
	    <input type="hidden"  name="cart_item_product_no" value="<%=cartItem.getProductNo()%>">
	    <input type="hidden"  name="cart_item_qty" value="<%=cartItem.getQty()%>">
	    <input type="number"  name="cart_item_qty_ui" 
	    	onkeyup="cart_ui_update('<%=cartItem.getCartItemNo()%>','<%=cartItem.getProductNo()%>')"  
	    	onmouseup="cart_ui_update('<%=cartItem.getCartItemNo()%>','<%=cartItem.getProductNo()%>')" value="<%=cartItem.getQty()%>"  min="1" max="99" required="required">
	  
	    <input type="button"  value="수정" onclick="cart_update('<%=cartItem.getCartItemNo()%>','<%=cartItem.getProductNo()%>')">
	    
	    <input type="button"  value="삭제" onclick="cart_delete('<%=cartItem.getCartItemNo()%>')">
	    <!-- 
	    <input type="date"    name="cart_date" value="2020-01-06" placeholder="2020-01-01"><br/>
	    <input type="search"  name="query"><br/>
	    <input type="range"   name="points" min="0" max="10" value="5"  placeholder="5"><br/>
	     -->
	</form>
<%} %>

<form id="cart_jumun_form" name="cart_jumun_form"  action="0.multiparamter_cart_jumun_create_action.jsp" >
	<%
	for(int i=0;i<cartItemList.size();i++){
		CartItem cartItem = cartItemList.get(i);
	%>
	 <input type="hidden" id="cart_item_no_qty_<%=cartItem.getCartItemNo()%>" name="cart_item_no_qty"  value="<%=cartItem.getProductNo()%>-<%=cartItem.getQty()%>">
	 
	<%
	}
	%>
	 <input type="button" onclick="cart_jumun();"  value="전체주문">
</form>

</body>
</html>