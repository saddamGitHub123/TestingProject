
package com.backend.apitest.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@Configuration
//@EnableWebSecurity
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//	@Autowired
//	public void configureGlobalSecurity(AuthenticationManagerBuilder auth)
//			throws Exception {
//		auth.inMemoryAuthentication().withUser("saddam").password("saddam")
//				.roles("USER", "ADMIN");
//	}
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().antMatchers("/login").permitAll()
//				.antMatchers("/", "/*apitest*/**")
//				.access("hasRole('USER')").and()
//				.formLogin();
//	}
	
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//	  auth.inMemoryAuthentication().withUser("mkyong").password("123456").roles("USER");
//	  auth.inMemoryAuthentication().withUser("admin").password("123456").roles("ADMIN");
//	  auth.inMemoryAuthentication().withUser("dba").password("123456").roles("DBA");
//	}
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//
//		
//		
//		
//	  http.authorizeRequests()
//	  .antMatchers("/*apitest*/**").access("hasRole('USER')")
//		.antMatchers("/*apitest/home").access("hasRole('ROLE_ADMIN')")
//		.antMatchers("/dba/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_DBA')")
//		.and().formLogin();
//		
//	}
//}
