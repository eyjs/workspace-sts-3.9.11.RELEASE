package com.itwill0.context;

import java.util.ArrayList;
import java.util.List;

public class ProductDao {
	
	public ProductDao() {
		System.out.println("0.### ProductDao()생성자");
	}

	public List<Product> productList() {
		ArrayList<Product> products=new ArrayList<Product>();
		products.add(new Product());
		products.add(new Product());
		products.add(new Product());
		products.add(new Product());
		return products;
	}
}
