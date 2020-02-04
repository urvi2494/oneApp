package com.cognizant.empportal.controller;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.cognizant.empportal.service.EmployeePortalService;
import com.cognizant.empportal.vo.EmployeeVO;
import com.cognizant.empportal.vo.SkillSetVO;

@RestController
@RequestMapping("/portal")
public class EmpPortalController {

	@Autowired
	WebClient webClient;
//	RestTemplate restTemplate;
 
	 
	@Autowired
	EmployeePortalService employeePortalService;

	@RolesAllowed("User")
	@GetMapping("/view/{empId}") 
	public EmployeeVO viewDetails(@PathVariable("empId") Long empId) 	              
	{ 
		
		EmployeeVO employeeVO= employeePortalService.viewDetails(empId);
		
		 List<SkillSetVO> skillSetVOList=employeePortalService.viewSkillDetails(empId);
		 employeeVO.setSkillSetVO(skillSetVOList);
		 return employeeVO;
	}
	
	

	
	

}
