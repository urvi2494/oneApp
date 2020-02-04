package com.cognizant.gateway.config;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import com.cognizant.gateway.service.CustomUserDetailsService;

@Component
public class JwtTokenFilter extends GenericFilterBean {


    private JwtTokenProvider jwtTokenProvider;
    
    private CustomUserDetailsService customUserDetailsService;
    
    private static final Logger logger = LoggerFactory.getLogger(JwtTokenFilter.class);
   
    public JwtTokenFilter(JwtTokenProvider jwtTokenProvider,CustomUserDetailsService customUserDetailsService) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.customUserDetailsService=customUserDetailsService;
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain)
        throws IOException, ServletException {
    	logger.info("inside JwtTokenFilter");
    
        String token = jwtTokenProvider.resolveToken((HttpServletRequest) req);
    	logger.info("extracting token from request: "+token);
    	if(token!=null)
    	{
        String userName=jwtTokenProvider.getUsername(token);
        logger.info("username: "+userName);
     
        
        if(userName!=null)
        {
        	   logger.info("customUserDetailsService: "+customUserDetailsService);
        	   UserDetails user=customUserDetailsService.loadUserByUsername(userName);
        	   if(jwtTokenProvider.validateToken(token,user)) {
        		   logger.info("user validated");
        		   //Authentication auth = token != null ? jwtTokenProvider.getAuthentication(token,user) : null;
        		   UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword(), user.getAuthorities());
                   //authentication.setAuthenticated(true);
                 
        		   logger.info("set security context: "+authentication);
        	       SecurityContextHolder.getContext().setAuthentication(authentication);
        	   }
        }
    	}
        
        filterChain.doFilter(req, res);
        logger.info("end JwtTokenFilter");
        return;
    }

}