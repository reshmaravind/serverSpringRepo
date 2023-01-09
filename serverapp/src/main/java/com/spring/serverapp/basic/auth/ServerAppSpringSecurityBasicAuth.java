package com.spring.serverapp.basic.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class ServerAppSpringSecurityBasicAuth{

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/**").permitAll()
		.anyRequest().authenticated()
		.and()
		.httpBasic();
		return http.build();
	}
	
	@Bean
	public WebSecurityCustomizer WebSecurityCustomizer() {
		return(web)-> web.ignoring().antMatchers("/**");
	}
}
