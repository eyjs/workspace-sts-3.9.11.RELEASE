package com.itwill.shop.cart;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import com.itwill.shop.product.Product;

public class CartService {
	HashMap<Integer, CartItemDto> cartItemsMap = null;
	int numberOfItems = 0;

	public CartService() {
		cartItemsMap = new HashMap<Integer, CartItemDto>();
	}
	
	public synchronized int add(String sUserId,int p_no,Product product, int cart_qty) {
		if (cartItemsMap.containsKey(p_no)) {
			CartItemDto cartItem = (CartItemDto) cartItemsMap.get(p_no);
			cartItem.setCart_qty(cartItem.getCart_qty()+cart_qty);
			cartItem.setCart_tot_price(cartItem.getCart_qty()*product.getP_price());
		} else {
			CartItemDto newItem = new CartItemDto(cartItemsMap.size(),sUserId,p_no,product.getP_name(),cart_qty,cart_qty*product.getP_price());
			cartItemsMap.put(p_no, newItem);
		}
		return cartItemsMap.size();
	}
	public int update(String sUserId,int p_no,Product product,int cart_qty) {
		if (cartItemsMap.containsKey(p_no)) {
			CartItemDto cartItem = (CartItemDto) cartItemsMap.get(p_no);
			cartItem.setCart_qty(cartItem.getCart_qty()+cart_qty);
			cartItem.setCart_tot_price(cartItem.getCart_qty()*product.getP_price());
			if (cartItem.getCart_qty() <= 0){
				cartItemsMap.remove(p_no);
			}
		}
		return cartItemsMap.size();
	}
	public synchronized Collection<CartItemDto> getCartItemList(String sUserId) throws Exception{
		return cartItemsMap.values();
	}
	public  int deleteCartItem(int p_no)  throws Exception{
		if(cartItemsMap.containsKey(p_no)) {
			cartItemsMap.remove(p_no);
		}
		return cartItemsMap.size();
	}

	public synchronized int deleteCart(String sUserId)  throws Exception{
		cartItemsMap.clear();
		return cartItemsMap.size();
	}
	public synchronized double getTotal() {
		double amount = 0.0;
		for (Iterator cartItemKeyIter = cartItemsMap.keySet().iterator(); cartItemKeyIter.hasNext();) {
			Integer cartItemKey = (Integer) cartItemKeyIter.next();
			CartItemDto cartItemDto = cartItemsMap.get(cartItemKey);
			amount+= cartItemDto.getCart_tot_price();
		}
		return roundOff(amount);
	}

	private double roundOff(double x) {
		long val = Math.round(x * 100);
		return val / 100.0;
	}

	public synchronized void clear() {
		cartItemsMap.clear();
		numberOfItems = 0;
	}
}
