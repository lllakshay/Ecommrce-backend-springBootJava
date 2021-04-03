	package com.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.app.security.service.MyUserDetailsService;
import com.app.security.service.jwtUtil.AuthEntryPointJwt;
import com.app.security.service.jwtUtil.AuthTokenFilter;


//we will overrite WebSecurityConfigurerAdapter methods
@EnableWebSecurity
public class SecurityConfigure extends WebSecurityConfigurerAdapter {

	@Autowired
	private MyUserDetailsService myUserDetailsService;
	
	@Autowired
	private AuthEntryPointJwt unauthorizedHandler;
	
	
	
//	use to give the permissions to the url or to do authorization and filters spescification
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		//configiring Http requests
		http
		.cors()		//cross origin resource sharing
		.and()
		.csrf()    //CROSS SITE REQUEST FORGERY     this is a kind of attck in which forces end user to execute unwanted actions
		.disable()
		.exceptionHandling()
		.authenticationEntryPoint(unauthorizedHandler)
		.and()
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS)  // Spring Security will never create an HttpSession and it will never use it to obtain the SecurityContext
		.and()
		.authorizeRequests()
		.antMatchers("/user/signup")  //this is free to open not secured
		.permitAll()
		.antMatchers("/user/signin")
		.permitAll()
		.anyRequest()
		.authenticated();
		
//		adding filter for token authentication
	http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);

		
	}
	
	
	
//	use to declare authentication
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		
		auth.userDetailsService(myUserDetailsService).passwordEncoder(passwordEncoder());
	} 
	
	
	

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	

	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception
	{
		return super.authenticationManagerBean();
	}
	
	
	@Bean
	public AuthTokenFilter authenticationJwtTokenFilter() {
		return new AuthTokenFilter();
	}
	
}
