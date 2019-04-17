package elisha.project.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import elisha.project.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	UserService userService;
	
	@Autowired
	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService);		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()        
		.antMatchers("/login").permitAll()
		.antMatchers("/register").permitAll()
		.antMatchers("/users/**", "/create-user").hasRole("ADMIN")
		.antMatchers("/admin/**").hasRole("ADMIN")
		.antMatchers("/addItem/**").hasRole("ADMIN")
		.antMatchers("viewItems").permitAll()
		.antMatchers("/api/**").permitAll()
		.antMatchers("/**").authenticated()
		.and()
		.formLogin()              
		.usernameParameter("email")
		.passwordParameter("password")
		.loginPage("/login")
		.loginProcessingUrl("/login")       
		.and()
		.logout()
		.logoutUrl("/logout")
		.logoutSuccessUrl("/login?logout")  
		.and()
		.csrf().disable();             
	}
	

}
