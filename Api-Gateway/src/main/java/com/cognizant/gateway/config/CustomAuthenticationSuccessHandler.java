package com.cognizant.gateway.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;


@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler{

	@Autowired
	JwtTokenProvider jwtTokenProvider;
	
	private static final Logger logger = LoggerFactory.getLogger(CustomAuthenticationSuccessHandler.class);
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		 logger.info("inside onAuthenticationSuccess");
		 logger.info("auth credentials "+authentication.getCredentials());
		 logger.info("auth principal "+authentication.getPrincipal());
		 logger.info("is authenticated: "+authentication.isAuthenticated());
		 JwtTokenProvider j=new JwtTokenProvider();
		 User user=(User)authentication.getPrincipal();
		 String token = j.createToken(user.getUsername(), authentication.getAuthorities());
         logger.info("token created: "+token);
         HttpServletResponse  myResponse= (HttpServletResponse) response;
         
         myResponse.addHeader(user.getUsername(), token);
        // response.setHeader(((User)authentication.getPrincipal()).getUsername(), token);
         logger.info("setting response header: "+user.getUsername()+" "+token);
         logger.info("end onAuthenticationSuccess");
         return;
	}

	
}
