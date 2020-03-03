package com.itwill3.dao;
import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import com.itwill.user.annotation.UserDaoImplJDBC2Annotation;
import com.itwill.user.annotation.UserDaoImplJdbcTemplateAnnotation;
import com.itwill.user.annotation.UserDaoImplMyBatisMapperInterfaceAnnotation;
import com.itwill.user.annotation.UserDaoImplMyBatisMapperInterfaceAnnotation2;
@Configuration
@ComponentScan(	basePackages = {"com.itwill.user.annotation"},
				excludeFilters = @Filter(type = FilterType.ASSIGNABLE_TYPE,
										 classes = {	
											UserDaoImplJDBC2Annotation.class,
											UserDaoImplJdbcTemplateAnnotation.class,
											UserDaoImplMyBatisMapperInterfaceAnnotation.class,
											UserDaoImplMyBatisMapperInterfaceAnnotation2.class
										  }
										)
			  )
public class UserDaoImplMyBatisAnnotationConfig {
	@Autowired
	private ApplicationContext applicationContext;
	
	@Autowired
	private DataSource dataSource;

	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	@Autowired
	private SqlSession sqlSession;
	
	@Bean
	public DataSource springDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@182.237.126.19:1521:XE");
		dataSource.setUsername("javaspring31");
		dataSource.setPassword("javaspring31");
		return dataSource;
	}
	@Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception{
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(dataSource);
		/********case1*********
		factoryBean.setConfigLocation(applicationContext.getResource("classpath:mybatis-config.xml"));
        factoryBean.setMapperLocations(applicationContext.getResources("classpath:/com/itwill3/dao/UserMapper.xml"));
		**********************/
		/********case2********/
		Resource[] myBatisConfigResource=new PathMatchingResourcePatternResolver()
			       .getResources("classpath:mybatis-config.xml");
		Resource[] mapperResource=new PathMatchingResourcePatternResolver()
				.getResources("classpath:com/itwill3/dao/UserMapper.xml");
		factoryBean.setConfigLocation(myBatisConfigResource[0]);
        factoryBean.setMapperLocations(mapperResource);
        /*********************/
        return factoryBean.getObject();
    }
	@Bean
	public SqlSessionTemplate sqlSession() throws Exception {
	  return new SqlSessionTemplate(sqlSessionFactory);
	}
	

}
