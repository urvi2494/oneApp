package com.cognizant.gateway.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.gateway.config.CustomAuthenticationSuccessHandler;
import com.cognizant.gateway.vo.LoginVO;

@RestController
@RequestMapping("/admin")
public class AdminController {

	

	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@PostMapping("/sign-in")
	public String signIn(@RequestBody LoginVO loginVO) {
		  logger.info("inside signIn");
		  return "fsdfsd";
		
		
	}
}
