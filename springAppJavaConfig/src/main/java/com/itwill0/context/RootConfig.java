package com.itwill0.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
RootConfig 는 0.applicationContext.xml 과 동일하다. (스프링 빈 관련)
@Configuration 을 통해 설정 파일이라는 것을 알려준다.
*/


/*
0.applicationContext.xml
 */
@Configuration
public class RootConfig {
	/*
	 <bean id="springBean" class="com.itwill0.context.SpringBean"/>
	 */
	@Bean(value = "springBean")
	public SpringBean springBean() {
		return new SpringBean();
	}
	/*
	<bean id="productDao" class="com.itwill0.context.ProductDao"/>
	 */
	@Bean(value = "productDao")
	public ProductDao productDao() {
		return new ProductDao();
	}
	/*
	<bean id="productService" class="com.itwill0.context.ProductService">
		<property name="productDao" ref="productDao"/>
	</bean>
	 */
	@Bean(value = "productService")
	public ProductService productService() {
		ProductService productService = new ProductService();
		productService.setProductDao(this.productDao());
		return productService;
	}
	

}











