package com.cognizant.gateway.config;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.tomcat.util.json.JSONParser;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.cognizant.gateway.vo.LoginVO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomUsernamePasswordFilter extends UsernamePasswordAuthenticationFilter {

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	ObjectMapper objectMapper;
	private static final Logger logger = LoggerFactory.getLogger(CustomUsernamePasswordFilter.class);

	public CustomUsernamePasswordFilter(CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler,
			AuthenticationManager authenticationManager) {
		logger.info("Inside CustomUsernamePasswordFilter");
		setAuthenticationSuccessHandler(customAuthenticationSuccessHandler);
		setAuthenticationManager(authenticationManager);
		setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/**/admin/sign-in", "POST"));
		logger.info("end CustomUsernamePasswordFilter");

	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		logger.info("inside CustomUsernamePasswordFilter--> attemptAuthentication");
		 String username=null; 
		 String password=null;
		  
		 String str, wholeStr = ""; 
		 try {
			 BufferedReader br = request.getReader();
		 
			 while ((str = br.readLine()) != null) 
			 { wholeStr += str; }
			 
		  if(StringUtils.isNotBlank(wholeStr)) {
			  
		 logger.info("request body: "+wholeStr); 
	
		 LoginVO loginVO =objectMapper.readValue(wholeStr, new TypeReference<LoginVO>(){});
		 password=loginVO.getPassword(); 
		 username=loginVO.getUserName();
		 logger.info("username: "+username+" password: "+password);
		 }
		  }
		 catch(Exception e)
		 { logger.error("Exception in reading stream", e.getMessage());
		 }
		 
		 
		 if (username == null) { username = ""; }
		 
		 if (password == null) { password = ""; }
		 
		 username = username.trim();
		 
		 UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken( username, password);
		
		 // Allow subclasses to set the "details" property //
		 setDetails(request,authRequest);
		logger.info("end CustomUsernamePasswordFilter--> attemptAuthentication");
		 return this.getAuthenticationManager().authenticate(authRequest);
	}

	/*
	 * @Override public Authentication attemptAuthentication(HttpServletRequest
	 * request, HttpServletResponse response) throws AuthenticationException,
	 * IOException, ServletException {
	 * 
	 * logger.info("inside CustomUsernamePasswordFilter--> attemptAuthentication");
	 * String username=null; String password=null;
	 * 
	 * String str, wholeStr = ""; try { BufferedReader br = request.getReader();
	 * while ((str = br.readLine()) != null) { wholeStr += str; }
	 * if(StringUtils.isNotBlank(wholeStr)) {
	 * logger.info("request body: "+wholeStr); //LoginVO
	 * loginVO=modelMapper.map(wholeStr,LoginVO.class); LoginVO loginVO =
	 * objectMapper.readValue(wholeStr, new TypeReference<LoginVO>(){});
	 * password=loginVO.getPassword(); username=loginVO.getUserName();
	 * logger.info("username: "+username+" password: "+password); } }
	 * catch(Exception e) { logger.error("Exception in reading stream",
	 * e.getMessage()); }
	 * 
	 * 
	 * if (username == null) { username = ""; }
	 * 
	 * if (password == null) { password = ""; }
	 * 
	 * username = username.trim();
	 * 
	 * UsernamePasswordAuthenticationToken authRequest = new
	 * UsernamePasswordAuthenticationToken( username, password);
	 * 
	 * // Allow subclasses to set the "details" property //setDetails(request,
	 * authRequest);
	 * logger.info("end CustomUsernamePasswordFilter--> attemptAuthentication");
	 * return this.getAuthenticationManager().authenticate(authRequest);
	 * 
	 * }
	 */

}
