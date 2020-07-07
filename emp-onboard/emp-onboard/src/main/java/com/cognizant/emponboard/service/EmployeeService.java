package com.cognizant.emponboard.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.emponboard.model.Employee;
import com.cognizant.emponboard.model.VerifiableCredential;
import com.cognizant.emponboard.repo.emp.EmployeeRepo;
import com.cognizant.emponboard.repo.vc.VerifiableCredentialRepo;
import com.cognizant.emponboard.util.CustomModelMapper;
import com.cognizant.emponboard.vo.EmployeeVO;

@Service
public class EmployeeService{

	@Autowired
	private EmployeeRepo employeeRepo;

	@Autowired
	private VerifiableCredentialRepo verifiableCredentialRepo;

	@Autowired
	private CustomModelMapper customModelMapper;

	@Transactional(rollbackFor=Exception.class)
	public void addEmployee(EmployeeVO empVO){
		System.out.println("inside addEmployee-> Service");
		
		
		Employee empEntity=employeeRepo.save(customModelMapper.getEmployeeFromEmployeeVO(empVO));
		System.out.println("emp: entity saved"+ empEntity);
		empVO.setEmpId(empEntity.getEmpId());
		
		VerifiableCredential vcEntity=verifiableCredentialRepo.save(customModelMapper.getVerifiableCredentialFromEmployeeVO(empVO));
		System.out.println("vc: entity saved"+ vcEntity);
	}

	public List<Employee> getAllEmp() {
		return employeeRepo.findAll();
	}

	public EmployeeVO getEmpById(Long empId) {
		Optional<Employee> emp = employeeRepo.findById(empId);
		EmployeeVO employeeVO=null;
		if (emp.isPresent())
		{
			Employee empEntity= emp.get();
			VerifiableCredential vcEntity=verifiableCredentialRepo.findVCByEmpID(empId);
			employeeVO= customModelMapper.getEmployeeVOfromEntity(empEntity,vcEntity);
		}
		return employeeVO;
	}

}
