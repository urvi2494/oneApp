package com.cognizant.empportal.vo;

import java.util.List;

public class EmployeeVO {
	
	private String name;

	private Long empId;

	private String designation;
	
	private Integer yearsOfExp;
	
	private Long id;
	
	private String adharNumber;
	
	private String passportNumber;
	
	private String PANCard;
	
	private List<SkillSetVO> skillSetVO;
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Integer getYearsOfExp() {
		return yearsOfExp;
	}

	public void setYearsOfExp(Integer yearsOfExp) {
		this.yearsOfExp = yearsOfExp;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAdharNumber() {
		return adharNumber;
	}

	public void setAdharNumber(String adharNumber) {
		this.adharNumber = adharNumber;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getPANCard() {
		return PANCard;
	}

	public void setPANCard(String pANCard) {
		PANCard = pANCard;
	}

	public List<SkillSetVO> getSkillSetVO() {
		return skillSetVO;
	}

	public void setSkillSetVO(List<SkillSetVO> skillSetVO) {
		this.skillSetVO = skillSetVO;
	}

	
	
}
