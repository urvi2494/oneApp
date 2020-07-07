package com.cognizant.empportal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.cognizant.empportal.enums.CompetencyCategory;
import com.cognizant.empportal.enums.CompetencyType;
import com.cognizant.empportal.enums.SkillStatus;
import com.cognizant.empportal.proxy.EmployeeInfoProxy;
import com.cognizant.empportal.proxy.EmployeeSkillProxy;
import com.cognizant.empportal.vo.EmployeeVO;
import com.cognizant.empportal.vo.SkillSetVO;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class EmployeePortalService {
	@Autowired
	EmployeeInfoProxy employeeInfoProxy;
	
	@Autowired
	EmployeeSkillProxy employeeSkillProxy;
	
	@Autowired
	WebClient webClient;
	@Autowired
	RestTemplate restTemplate;
	

	
	@HystrixCommand(fallbackMethod="viewDefaultEmpDetails")
	public EmployeeVO viewDetails(Long empId) {
		// return webClient.get().uri("http://localhost:8081/profile/"+empId).retrieve().bodyToMono(Employee.class);	
		//return webClient.get().uri("http://emp-onboard/profile/"+empId).retrieve().bodyToMono(EmployeeVO.class);
		return employeeInfoProxy.getEmpById(empId); 	 
	}
	
	
	public EmployeeVO viewDefaultEmpDetails(Long empId)
	{
		EmployeeVO employee=new EmployeeVO();
		employee.setDesignation("No designation");
		employee.setEmpId(empId);
		employee.setName("No employee found");
		employee.setYearsOfExp(0);
		return employee;
	}
	
	@HystrixCommand(fallbackMethod="viewDefaultEmpSkillDetails")
	public List<SkillSetVO> viewSkillDetails(Long empId) {
		// return webClient.get().uri("http://localhost:8081/profile/"+empId).retrieve().bodyToMono(Employee.class);	
		//return webClient.get().uri("http://emp-onboard/profile/"+empId).retrieve().bodyToMono(EmployeeVO.class);
		return employeeSkillProxy.getEmpSkillById(empId); 	 
	}
	
	
	public List<SkillSetVO> viewDefaultEmpSkillDetails(Long empId)
	{
		ArrayList<SkillSetVO> skillSetVOs=new ArrayList<SkillSetVO>();
		SkillSetVO skillSetVO=new SkillSetVO();
		skillSetVO.setCompetencyCategory(CompetencyCategory.NA);
		skillSetVO.setCompetencyType(CompetencyType.NA);
		skillSetVO.setSkillName("No skill allocated");
		skillSetVO.setStatus(SkillStatus.NA);
		skillSetVOs.add(skillSetVO);
		return skillSetVOs;
	}
}
