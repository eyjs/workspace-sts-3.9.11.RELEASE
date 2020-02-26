@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.javaconfig" }, useDefaultFilters = false, includeFilters = {
		@ComponentScan.Filter(Controller.class) })
public class WebConfig {
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
}
