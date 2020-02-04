package com.cognizant.emponboard.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.emponboard.model.Employee;
import com.cognizant.emponboard.service.EmployeeService;
import com.cognizant.emponboard.vo.EmployeeVO;

@RestController
@RequestMapping("/profile")
public class EmpOnboardController {

	
	@Autowired
	EmployeeService employeeService;

	@PostMapping("/add-emp")
	public void addEmployee(@RequestBody EmployeeVO empVO) {
		employeeService.addEmployee(empVO);
	}

	@GetMapping("/all")
	public List<Employee> getAllEmp() {
		//log.info("inside getAllEmp");
		return employeeService.getAllEmp();
	}

	@GetMapping("/{empId}") 
	public EmployeeVO getEmpById(@PathVariable("empId")Long empId) { 
		/*
		 * Optional<Employee> emp= empList.stream().filter(e-> {return
		 * e.getEmpId().equals(empId);}).findFirst();
		 */
		return employeeService.getEmpById(empId);
}

}
