package com.itwill.guest.config.one;
/**
 * servlet 설정용 클래스
 * servlet-context.xml 의 역할을 대신 하거나 보충한다.
 */

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.CacheControl;
import org.springframework.http.MediaType;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.springframework.web.servlet.view.xml.MappingJackson2XmlView;

@Configuration
@EnableAspectJAutoProxy     //ASPECT 사용을 위함.
//extends WebMvcConfigurationSupport - 커스텀하게 구현
//extedns WebMvcConfigurerAdapter    - 기본설정으로 구현
@EnableWebMvc   //Spring 내부적으로 WebMvcConfigurationSupport 클래스를 환경설정 클래스로 등록하여 Spring MVC 환경을 구성하게됨.
//몇몇 구성에 대해서 커스터마이징을 처리. -> WebMvcConfigurerAdapter을 사용
//전면 재구성을 위해서는 EnableWebMvc어노테이션 제거 후 WebMvcConfigurationSupport를 상속받아 재구성
@ComponentScan (
        basePackages = "com.itwill"
       ,useDefaultFilters = false   // 기본 스캔 전략을 종료. 중요함.
       ,includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Controller.class),
                          @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = RestController.class)
       }  //Controller만 스캔
       ,excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class),
                          @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Repository.class),
                          @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Service.class),
                          @ComponentScan.Filter(type = FilterType.ASPECTJ,pattern="com.itwill.guest.config.one.*")
       } //Configuration은 스캔대상에서 제외. Config는 명시적으로 지정
)
public class ServletContextConfig extends WebMvcConfigurerAdapter {
   
	protected static Logger logger = Logger.getLogger(ServletContextConfig.class);
    /**
     * 리소스 핸들러 설정
     * <resources location="/resources/" mapping="/resources/**">
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("/css/")
                .setCacheControl(CacheControl.maxAge(10, TimeUnit.SECONDS).mustRevalidate());
        registry.addResourceHandler("/lib/**").addResourceLocations("/lib/")
                .setCacheControl(CacheControl.maxAge(10, TimeUnit.SECONDS).mustRevalidate());
        registry.addResourceHandler("/web/**").addResourceLocations("/webroot/")
                .setCacheControl(CacheControl.noStore());   //prevent cache
                //.setCachePeriod(0);     //0: prevent cache
    }   
    /**
     * ViewResolver 등록
     */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        MappingJackson2JsonView jsonView = new MappingJackson2JsonView();
        jsonView.setPrettyPrint(true);
       
        MappingJackson2XmlView xmlView = new MappingJackson2XmlView();
        xmlView.setPrettyPrint(true);
       
        registry.enableContentNegotiation(
                jsonView
               ,xmlView
        );
        registry.jsp("/WEB-INF/views/", ".jsp");
        super.configureViewResolvers(registry);
    }
    /**
     * Interceptor 설정
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //registry.addInterceptor(new ApiInterceptor());
    }
    /**
     * Configure content negotiation options.
     */
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        //Restful 한 서비스에서 APPLICATION_JSON_VALUE로 지정하여도 충분하나
        //IE9에서 JSON을 iframe transport로 전송 시 파일로 저장하려는 버그 발생으로 인해 아래와 같이 선언.
        MediaType API_PRODUCES_MEDIATYPE = MediaType.valueOf(MediaType.TEXT_HTML_VALUE+";charset=utf-8");
        configurer.ignoreAcceptHeader(false)                	//HttpRequest Header의 Accept 무시 여부
                  .favorPathExtension(true)                 	//프로퍼티 값을 보고 URL의 확장자에서 리턴 포맷을 결정 여부
                  .ignoreUnknownPathExtensions(true)       		//모든 미디어 유형으로 해결할 수없는 경로 확장자를 가진 요청을 무시할지 여부
                  .favorParameter(true)                         //URL 호출 시 특정 파라미터로 리턴포맷 전달 허용 여부 ex)a.do?format=json
                  .mediaType("json", MediaType.APPLICATION_JSON_UTF8)//UTF-8 기반 JSON 타입 선언
                  .defaultContentType(API_PRODUCES_MEDIATYPE);
    }
    /**
     * Add Converters and Formatters in addition to the ones registered by default.
     * This implementation is empty.
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        super.addFormatters(registry);
        //registry.addConverter(new StringToJodaDateTimeConverter());
        //egistry.addConverter(new StringToJodaLocalDateTimeConverter());
    }
    /**
     * {@link HttpMessageConverter}를 설정
     * 설정시 기본 컨버터 미사용. {@link #addDefaultHttpMessageConverters(List)}
     * {@link RequestMappingHandlerAdapter}, {@link ExceptionHandlerExceptionResolver}에서 사용.
     */

    @Override

    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new ByteArrayHttpMessageConverter());//바이트 배열 읽기/쓰기. 모든 미디어 타입(*/*)에서 읽고 application/octect-stream으로 쓴다.
        converters.add(new StringHttpMessageConverter(java.nio.charset.Charset.forName("UTF-8")){{
            setWriteAcceptCharset(true);
        }});                                               //모든 미디어 타입(*/*)을 String으로 읽는다. text/plain에 대한 String을 쓴다.
        converters.add(new ResourceHttpMessageConverter());//Resource를 읽고 쓰기.
        converters.add(new FormHttpMessageConverter());    //application/x-www-form-urlencoded. Form data is read from and written into a MultiValueMap.
        converters.add(new MappingJackson2HttpMessageConverter());
        //converters.add(new MappingJackson2XmlHttpMessageConverter());
    }

}
