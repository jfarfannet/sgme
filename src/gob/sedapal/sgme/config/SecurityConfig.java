package gob.sedapal.sgme.config;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

import gob.sedapal.sgme.service.UserService;

@Configuration
@EnableWebMvcSecurity	//A diferencia de @EnableWebSecurity anade el soporte a @AuthenticationPrincipal http://norrisshelton.com/2014/01/14/getting-the-spring-security-principal-in-a-spring-mvc-controller-method/ 
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	protected static final Logger log = Logger.getLogger(WebConfig.class);
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private UserService userService;
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		
		// inMemoryAuthentication: http://www.mkyong.com/spring-security/spring-security-hello-world-annotation-example/
//		auth.inMemoryAuthentication().withUser("ebenites").password("tecsup").roles("ADMIN"/*, "USER"*/); //En este caso se agregar� el prefijo ROLE_
//		auth.inMemoryAuthentication().withUser("jflores").password("tecsup").roles("USER");
		
		// jdbcAuthentication: Consulta SQL personalizada para UserDetailsService
//		auth.jdbcAuthentication().dataSource(dataSource)
//			.usersByUsernameQuery("SELECT username,PASSWORD, enabled FROM users WHERE username = ?")
//			.authoritiesByUsernameQuery("SELECT username, r.name AS role FROM users_has_roles h "
//					+ "INNER JOIN users u ON u.id=h.users_id "
//					+ "INNER JOIN roles r ON r.id=h.roles_id "
//					+ "WHERE username = ?");
		
		// userDetailsService: UserDetailsService personalizado
//		auth.userDetailsService(userService);
		
		// authenticationProvider: AuthenticationProvider personalizado (para definir otra l�gica de validaci�n)
//		auth.authenticationProvider(userService);
		
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

//		http.authorizeRequests()
//			.antMatchers("/").access("permitAll")
//			.antMatchers("/academico/**").access("hasRole('ADMIN')") //para inMemoryAuthentication el rol es ROLE_ADMIN
//			.antMatchers("/monitor/**").access("isAuthenticated()")
//			.and()
//				.exceptionHandling().accessDeniedPage("/403.html")
//			.and()
//				.formLogin().loginPage("/login.html").loginProcessingUrl("/authenticate.html").defaultSuccessUrl("/welcome.html").failureUrl("/login.html?error")
//					.usernameParameter("username").passwordParameter("password")
//			.and()
//				.logout().logoutUrl("/logout.html").logoutSuccessUrl("/login.html")
//			
//			.and()
//				.csrf();
		 
		//Para los tags y thymeleaf ver: https://github.com/thymeleaf/thymeleaf-extras-springsecurity
		
	}
	
}
