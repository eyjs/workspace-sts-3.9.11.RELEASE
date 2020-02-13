
<%@page import="com.itwill.shop.product.Product"%>
<%@page import="com.itwill.shop.product.ProductService"%>
<%@page import="com.itwill.shop.cart.CartService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	if (request.getMethod().equalsIgnoreCase("GET")) {
		response.sendRedirect("shop_product_list.jsp");
		return;
	}
	//장바구니에 개를담고 view_cart.jsp 로 redirection...
	String p_no = request.getParameter("p_no");
	String cart_qty = request.getParameter("cart_qty");
	if (p_no == null || cart_qty == null) {
		response.sendRedirect("shop_product_list.jsp");
		return;
	}
	
	ProductService productService = new ProductService();
	Product product = productService.getProduct(Integer.parseInt(p_no));
	
	CartService cartService = 
			(CartService) session.getAttribute("cartService");
	if (cartService == null) {
		cartService = new CartService();
		session.setAttribute("cartService", cartService);
	}
	cartService.add(session.getId(),Integer.parseInt(p_no), product, Integer.parseInt(cart_qty));
	response.sendRedirect("shop_view_cart.jsp");
%>
