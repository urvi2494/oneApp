package com.cognizant.gateway.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.gateway.vo.LoginVO;

@RestController
@RequestMapping("/emp")
public class LoginController {
	
	@PostMapping("/sign-in")
	public String signIn(@RequestBody LoginVO loginVO) {
		return "";
	}
}
