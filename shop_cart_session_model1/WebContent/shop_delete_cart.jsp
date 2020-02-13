<%@page import="com.itwill.shop.cart.CartService"%>

<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%
	//장바구니에 있는 모든개를지우고  view_cart.jsp 로 redirection...
	CartService cartService = (CartService) session.getAttribute("cartService");
	if (cartService == null) {
		cartService = new CartService();
		session.setAttribute("cartService", cartService);
	}
	cartService.deleteCart(session.getId());
	response.sendRedirect("shop_view_cart.jsp");
%>