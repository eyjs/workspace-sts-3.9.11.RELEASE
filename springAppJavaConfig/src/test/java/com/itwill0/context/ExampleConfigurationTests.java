package com.itwill0.context;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
@Log4j
public class ExampleConfigurationTests {
	@Autowired
	private ProductService productService;
	//@Test
	public void getProductService() throws Exception {
		assertNotNull(productService);
	}
	@Test
	public void productList()throws Exception{
		//log.info(productService.productList().toString());
	}
	
	
}
