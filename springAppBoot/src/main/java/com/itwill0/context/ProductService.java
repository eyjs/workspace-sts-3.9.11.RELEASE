package com.itwill0.context;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	@Autowired
	private ProductDao productDao = null;

	public ProductService() {
		System.out.println("1.### ProductService()생성자");
	}

	public void setProductDao(ProductDao productDao) {
		System.out.println("2.### ProductService.setProductDao(" + productDao + ")");
		this.productDao = productDao;
	}

	public List<Product> productList() {
		return productDao.productList();
	}

}
