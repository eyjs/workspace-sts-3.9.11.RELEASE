package com.itwill.guest.config.one;
/**
 * root 설정용 클래스
 * root-context.xml 의 역할을 대신 하거나 보충한다.
 */


import java.util.logging.Logger;

import org.apache.log4j.spi.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(
        basePackages = "com.itwill",
        useDefaultFilters = false,
        excludeFilters = {
                @ComponentScan.Filter(type=FilterType.ANNOTATION, classes = Controller.class),
                @ComponentScan.Filter(type=FilterType.ANNOTATION, classes = RestController.class)
        },
        includeFilters = {
                @ComponentScan.Filter(type=FilterType.ANNOTATION, classes = Configuration.class),
                @ComponentScan.Filter(type=FilterType.ANNOTATION, classes = Repository.class),
                @ComponentScan.Filter(type=FilterType.ANNOTATION, classes = Service.class)
        }
)
@PropertySource("classpath:/runtimeEnv/config-${spring.profiles.active}.properties")
public class RootContextConfig implements ApplicationContextAware {
    //protected static Logger logger = LoggerFactory.getLogger(RootContextConfig.class);
    protected ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
    // Runtime 프로파일 설정 가능(propertyHolder)
    @Bean
    public PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
        PropertyPlaceholderConfigurer configurer = new PropertyPlaceholderConfigurer();
        /*
        String activeProfile = CommonUtils.getActiveProfile();
        logger.debug("ACTIVE SPRING PROFILE => {}", activeProfile);
        configurer.setLocations(
                this.applicationContext.getResource("classpath:/runtimeEnv/config-" + activeProfile + ".properties")
        );
		*/
        return configurer;

    }

}
