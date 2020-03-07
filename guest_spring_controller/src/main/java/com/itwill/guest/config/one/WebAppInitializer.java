package com.itwill.guest.config.one;
/**
 * Spring Dispatcher Servlet Web Application Initializer (web.xml)
 */

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.ShallowEtagHeaderFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
public class WebAppInitializer /*extends AbstractAnnotationConfigDispatcherServletInitializer*/ {
    /*
    //WebApplicationInitializer를 직접구현하는 샘플. 대신에 AbstractAnnotationConfigDispatcherServletInitializer를 사용하기로 함

    public class SpringWebAppInitializer implements org.springframework.web.WebApplicationInitializer {
        @Override public void onStartup(ServletContext servletContext) throws ServletException {
            // Create the 'root' Spring application context
            AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
            rootContext.register(RootContextConfig.class);
            // Manage the lifecycle of the root application context
            servletContext.addListener(new ContextLoaderListener(rootContext));
            // Create the dispatcher servlet's Spring application context
            AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
            appContext.register(AppServletContextConfig.class);
            // Register and map the dispatcher servlet
            ServletRegistration.Dynamic dispatcher = servletContext.addServlet("appServlet", new DispatcherServlet(appContext));
            dispatcher.setLoadOnStartup(1); dispatcher.addMapping("/");
        }
    }
    */
    //AbstractAnnotationConfigDispatcherServletInitializer 내부에서 startUp, registDispatcherServlet을 진행함.
    //@Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?> [] {
            DataContextConfig.class,        //데이터 베이스 관련 Config
            RootContextConfig.class         //root-context.xml
            //, 구분으로 N개의 class가 들어갈 수 있음.
        };
    }
    //@Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?> [] {
            AppServletConfig.class,
            ServletContextConfig.class
            //, 구분으로 N개의 class가 들어갈 수 있음.
        };
    }
    //@Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
    //@Override
    protected Filter[] getServletFilters() {
        //Dispatcher Servlet 필터를 등록
        return new Filter[] {
                new ShallowEtagHeaderFilter(),
                getCharacterEncodingFilter()
            };
    }
   
    protected CharacterEncodingFilter getCharacterEncodingFilter() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return characterEncodingFilter;
    }

 

}
