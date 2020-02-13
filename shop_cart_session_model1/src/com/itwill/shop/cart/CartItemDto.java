package com.itwill.shop.cart;

public class CartItemDto {
	private int cart_item_no;
	private String userId;
	private int p_no;
	private String p_name;
	private int cart_qty;
	private int cart_tot_price;

	public CartItemDto() {

	}

	public CartItemDto(int cart_item_no, String userId, int p_no, String p_name, int cart_qty, int cart_tot_price) {
		super();
		this.cart_item_no = cart_item_no;
		this.userId = userId;
		this.p_no = p_no;
		this.p_name = p_name;
		this.cart_qty = cart_qty;
		this.cart_tot_price = cart_tot_price;
	}

	public int getCart_item_no() {
		return cart_item_no;
	}

	public void setCart_item_no(int cart_item_no) {
		this.cart_item_no = cart_item_no;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getP_no() {
		return p_no;
	}

	public void setP_no(int p_no) {
		this.p_no = p_no;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public int getCart_qty() {
		return cart_qty;
	}

	public void setCart_qty(int cart_qty) {
		this.cart_qty = cart_qty;
	}

	public int getCart_tot_price() {
		return cart_tot_price;
	}

	public void setCart_tot_price(int cart_tot_price) {
		this.cart_tot_price = cart_tot_price;
	}

	

	
}
