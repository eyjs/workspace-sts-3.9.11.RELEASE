package com.itwill0.context;

import junit.framework.TestCase;

public class ProductServiceTests extends TestCase {

	private ProductService productService = new ProductService();
	
	public void testReadOnce() throws Exception {
		assertNotNull("sdas", productService);
	}

}
