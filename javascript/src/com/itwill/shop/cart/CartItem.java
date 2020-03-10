package com.itwill.shop.cart;

public class CartItem {
	private String cartItemNo;
	private String productNo;
	private int qty;
	private int totPrice;
	public CartItem() {
		// TODO Auto-generated constructor stub
	}
	public CartItem(String cartItemNo, String productNo, int qty, int totPrice) {
		super();
		this.cartItemNo = cartItemNo;
		this.productNo = productNo;
		this.qty = qty;
		this.totPrice = totPrice;
	}

	public void increaseQty(int qty) {
		this.qty+=qty;
	}

	public void decreaseQty(int qty) {
		this.qty-=qty;
		if(this.qty<0)this.qty=0;
	}

	public void setTotPrice(int totPrice) {
		this.totPrice = totPrice;
	}
	public String getCartItemNo() {
		return cartItemNo;
	}

	public void setCartItemNo(String cartItemNo) {
		this.cartItemNo = cartItemNo;
	}

	public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getTotPrice() {
		return totPrice;
	}

}
