
package com.cognizant.gateway.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.cognizant.gateway.service.CustomUserDetailsService;

public class JwtConfigurer extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {


	private JwtTokenProvider jwtTokenProvider;
	private CustomUserDetailsService customUserDetailsService;
	
	private static final Logger logger = LoggerFactory.getLogger(JwtConfigurer.class);
	
	public JwtConfigurer(JwtTokenProvider jwtTokenProvider,CustomUserDetailsService customUserDetailsService) {
		this.jwtTokenProvider = jwtTokenProvider;
		this.customUserDetailsService=customUserDetailsService;
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		logger.info("inside JwtConfigurer");
		JwtTokenFilter customFilter = new JwtTokenFilter(jwtTokenProvider,customUserDetailsService);
		http.addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class);
		logger.info("end JwtConfigurer");
	}
}
