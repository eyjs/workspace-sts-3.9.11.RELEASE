import org.springframework.context.annotation.ComponentScan;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.List;

// servlet-context.xml을 대신할 java 클래스
// @EnableWebMvc: web mvc을 이용하는데 있어서 spring container가 가져야할 기본적인 bean component 등록. 빠르고 편하게 mvc을 구축할수 있는 configuration 환경 제공
// WebMvcConfigurationSupport 클래스가 자동으로 Bean 등록된다. Mvc Java Config 설정에서 설정을 제공하는 주요 클래스
// Web에 필요한 Bean들을 대부분 자동으로 설정해준다.
// WebMvcConfigurer 인터페이스: 기본 설정 이외의 설정이 필요할 경우 해당 클래스 상속 받은 후 오버라이딩하여 구현.
// @ComponentScan: Controller, Service, Repository, Component 어노테이션이 붙을 클래스를 찾아 스프링 컨테이너가 관리
@EnableWebMvc
@ComponentScan(basePackages = {"org.home.controller"})
public class ServletConfig implements WebMvcConfigurer {

    // jsp를 view로 사용할 때 사용
    // Controller에서 리턴하는 뷰 이름에 접두, 접미어를 붙여서 jsp 경로를 찾는다.
    @Override
    public void configureViewResolvers(ViewResolverRegistry viewResolverRegistry) {
        InternalResourceViewResolver bean = new InternalResourceViewResolver();
        bean.setViewClass(JstlView.class);
        bean.setPrefix("/WEB-INF/views/");
        bean.setSuffix(".jsp");
        viewResolverRegistry.viewResolver(bean);
    }

    // '/'로 모든 요청을 받아들이는데 이 요청들을 처리할 url 설정에 대한 코드
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry resourceHandlerRegistry) {
        resourceHandlerRegistry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer pathMatchConfigurer) {

    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer contentNegotiationConfigurer) {

    }

    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer asyncSupportConfigurer) {

    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer defaultServletHandlerConfigurer) {

    }

    @Override
    public void addFormatters(FormatterRegistry formatterRegistry) {

    }

    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry) {

    }

    @Override
    public void addCorsMappings(CorsRegistry corsRegistry) {

    }

    @Override
    public void addViewControllers(ViewControllerRegistry viewControllerRegistry) {

    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> list) {

    }

    @Override
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> list) {

    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> list) {

    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> list) {

    }

    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> list) {

    }

    @Override
    public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> list) {

    }

    @Override
    public Validator getValidator() {
        return null;
    }

    @Override
    public MessageCodesResolver getMessageCodesResolver() {
        return null;
    }
}
