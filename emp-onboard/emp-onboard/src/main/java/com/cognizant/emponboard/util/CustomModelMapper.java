package com.cognizant.emponboard.util;

import org.springframework.stereotype.Component;

import com.cognizant.emponboard.model.Employee;
import com.cognizant.emponboard.model.VerifiableCredential;
import com.cognizant.emponboard.vo.EmployeeVO;

@Component
public class CustomModelMapper {

	public Employee getEmployeeFromEmployeeVO(EmployeeVO employeeVO)
	{
		Employee employee=new Employee();
		employee.setDesignation(employeeVO.getDesignation());
		employee.setFname(employeeVO.getFname());
		employee.setEmailId(employeeVO.getEmailId());
		employee.setYearsOfExp(employeeVO.getYearsOfExp());
		employee.setLname(employeeVO.getLname());
		employee.setPhoneNumber(employeeVO.getPhoneNumber());
		return employee;
	}
	
	public VerifiableCredential getVerifiableCredentialFromEmployeeVO(EmployeeVO employeeVO) {
		VerifiableCredential verifiableCredential=new VerifiableCredential();
		verifiableCredential.setAdharNumber(employeeVO.getAdharNumber());
		verifiableCredential.setEmployeeId(employeeVO.getEmpId());
		verifiableCredential.setPANCard(employeeVO.getPanCard());
		verifiableCredential.setPassportNumber(employeeVO.getPassportNumber());
		return verifiableCredential;
	}
	
	public EmployeeVO getEmployeeVOfromEntity(Employee empEntity,VerifiableCredential vcEntity)
	{
		EmployeeVO employeeVO=new EmployeeVO();
		if(vcEntity!=null)
		{
			employeeVO.setAdharNumber(vcEntity.getAdharNumber());
			employeeVO.setPanCard(vcEntity.getPANCard());
			employeeVO.setPassportNumber(vcEntity.getPassportNumber());
		}
		employeeVO.setDesignation(empEntity.getDesignation());
		employeeVO.setEmailId(empEntity.getEmailId());
		employeeVO.setFname(empEntity.getFname());
		employeeVO.setLname(empEntity.getLname());
		employeeVO.setPhoneNumber(empEntity.getPhoneNumber());
		employeeVO.setEmpId(empEntity.getEmpId());
		employeeVO.setYearsOfExp(empEntity.getYearsOfExp());
		return employeeVO;	
	}
}
