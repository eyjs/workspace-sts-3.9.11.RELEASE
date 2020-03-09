@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.javaconfig"}, 
excludeFilters = @ComponentScan.Filter(Controller.class))
@PropertySource("classpath:jdbc.properties")
public class RootConfig {
    
    @Value("${jdbc.url}")
    private String url;
    
    @Value("${jdbc.username}")
    private String userName;
    
    @Value("${jdbc.password}")
    private String password;
    
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
    
    @Bean
    public DataSource dataSource() {
        SimpleDriverDataSource ds = new SimpleDriverDataSource();
        ds.setDriverClass(org.h2.Driver.class);
        ds.setUrl(url);
        ds.setUsername(userName);
        ds.setPassword(password);
        
        return ds;
    }
    
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource());
        
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resolver.getResources("classpath*:mapper/**/*-mapper.xml");
        sqlSessionFactory.setMapperLocations(resources);
        
        return sqlSessionFactory;
    }
    
    @Bean(destroyMethod = "clearCache")
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
    
    @Bean
    public PlatformTransactionManager txManager() {
        return new DataSourceTransactionManager(dataSource());
    }
}
