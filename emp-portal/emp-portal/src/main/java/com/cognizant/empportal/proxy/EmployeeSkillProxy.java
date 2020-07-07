package com.cognizant.empportal.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cognizant.empportal.vo.SkillSetVO;

@FeignClient(name="emp-skillset" )//Service Id 
public interface EmployeeSkillProxy {

	@RequestMapping("/skill/view/{empId}")
	public List<SkillSetVO> getEmpSkillById(@PathVariable("empId") Long empId);
}
