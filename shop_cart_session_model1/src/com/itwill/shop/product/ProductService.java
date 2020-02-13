package com.itwill.shop.product;
import java.util.List;

public class ProductService {
	private ProductDao productDao;
	public ProductService() throws Exception{
		 productDao = new ProductDao(); 
	}
	
	/*
	DogProduct 리스트반환
	 */
	public List<Product> getProductList() throws Exception{		
		
		List<Product> productList = productDao.getProductList(); 
		return productList;
	}
	/*
	DogProduct 1개반환
	 */
	public Product getProduct(int p_no) throws Exception { 
		ProductDao productDao = new ProductDao();
		Product product = productDao.getProduct(p_no); 
		return product;
	}
	public boolean updateReadcount(int p_no) throws Exception{
		boolean result = false;
		ProductDao productDao = new ProductDao(); 
		result = productDao.updateReadcount(p_no); 
		return result;
	}
}

