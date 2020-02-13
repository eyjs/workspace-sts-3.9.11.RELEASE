<%@page import="com.itwill.shop.cart.CartService"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<%
	String p_no = request.getParameter("p_no");
	if (p_no == null || p_no.equals("")) {
		response.sendRedirect("shop_product_list.jsp");
		return;
	}
	//장바구니에서 원하는 품목을 삭제시킨 후 view_cart.jsp 로 sendRedirect 시킨다..
	CartService cartService = (CartService) session.getAttribute("cartService");
	if (cartService == null) {
		cartService = new CartService();
		session.setAttribute("cartService", cartService);
	}
	cartService.deleteCartItem(Integer.parseInt(p_no));
	response.sendRedirect("shop_view_cart.jsp");
%>
