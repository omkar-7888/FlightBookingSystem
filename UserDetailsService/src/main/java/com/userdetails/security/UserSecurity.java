package com.userdetails.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class UserSecurity extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService userDetailsService;
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("mani").password("mani123").roles("user");
//	}
	@Bean
	public AuthenticationProvider authProvider() {
		DaoAuthenticationProvider provider =new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		return provider;
	}
	@Bean
	public PasswordEncoder getEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception{
		return super.authenticationManagerBean();
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/add","/getallflights","/auth","/addUser").permitAll().and().formLogin();
//		http.authorizeRequests()
//		.antMatchers("/**").hasRole("ADMIN")
//		.antMatchers("/get**").hasAnyRole("USER","ADMIN")
//		.antMatchers("/").permitAll().and().formLogin();
	}

}
