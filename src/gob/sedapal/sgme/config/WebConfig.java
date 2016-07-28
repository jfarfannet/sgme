package gob.sedapal.sgme.config;

import java.util.Properties;

import javax.servlet.http.HttpServletResponse;

import nz.net.ultraq.thymeleaf.LayoutDialect;

import org.apache.log4j.Logger;
import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

@Configuration
@EnableWebMvc
@ComponentScan({ "gob.sedapal.sgme.*" })
@PropertySource({"classpath:jdbc.properties", "classpath:config.properties"})
public class WebConfig extends WebMvcConfigurerAdapter{

	protected static final Logger log = Logger.getLogger(WebConfig.class);
	
	@Autowired
	private Environment env;

	@Bean(name = "dataSource")
    public BasicDataSource dataSource() { // DataSource Commons DBCP, use properties in jdbc.properties
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
        dataSource.setUrl(env.getProperty("jdbc.url"));
        dataSource.setUsername(env.getProperty("jdbc.username"));
        dataSource.setPassword(env.getProperty("jdbc.password"));
        dataSource.setMaxActive(Integer.parseInt(env.getProperty("jdbc.maxActive")));
//        dataSource.setInitialSize(10);
//        dataSource.setMinIdle(10);
//        dataSource.setMaxIdle(20);
//        dataSource.setMaxWait(-1);
//        dataSource.setValidationQuery("SELECT 1");
//        dataSource.setTestOnBorrow(true);
        return dataSource;
    }
	
	@Bean
    public JdbcTemplate jdbcTemplate() {   
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }
	
	
	@Bean
	public ServletContextTemplateResolver templateResolver() {
		ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
		templateResolver.setPrefix("/WEB-INF/views/");
		templateResolver.setSuffix(".html");
	    //NB, selecting HTML5 as the template mode.
		templateResolver.setTemplateMode("HTML5");
		templateResolver.setCacheable(false);
		return templateResolver;
	}
	
	@Bean
	public SpringTemplateEngine templateEngine() {
	    SpringTemplateEngine templateEngine = new SpringTemplateEngine();
	    templateEngine.setTemplateResolver(templateResolver()); //
	    templateEngine.addDialect(new LayoutDialect());
	    return templateEngine;
	}
	
	@Bean
	public ThymeleafViewResolver viewResolver() {
		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		viewResolver.setTemplateEngine(templateEngine()); //	
		viewResolver.setContentType("text/html; charset=UTF-8");
		return viewResolver;
	}
	
	
	@Bean 
	public MessageSource messageSource(){
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasenames(new String[]{"classpath:messages"});
		return messageSource;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**").addResourceLocations("/");
	}

	@Bean
	public SimpleMappingExceptionResolver simpleMappingExceptionResolver() {
		SimpleMappingExceptionResolver exceptionResolver = new SimpleMappingExceptionResolver();
		Properties mappings = new Properties();
		mappings.put("java.lang.Throwable", "error"); // call controller -> redirect:/error
		exceptionResolver.setExceptionMappings(mappings);
		exceptionResolver.setDefaultStatusCode(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		return exceptionResolver;
	}

}
