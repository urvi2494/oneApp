package com.cognizant.empportal.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cognizant.empportal.vo.EmployeeVO;

@FeignClient(name="emp-onboard" )//Service Id of EmployeeSerach service
public interface EmployeeInfoProxy {

	@RequestMapping("/profile/{empId}")
	public EmployeeVO getEmpById(@PathVariable("empId") Long empId);
}
