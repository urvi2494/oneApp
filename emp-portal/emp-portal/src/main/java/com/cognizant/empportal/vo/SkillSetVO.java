package com.cognizant.empportal.vo;

import com.cognizant.empportal.enums.CompetencyCategory;
import com.cognizant.empportal.enums.CompetencyType;
import com.cognizant.empportal.enums.SkillStatus;

public class SkillSetVO {


	private CompetencyCategory competencyCategory;
	private CompetencyType competencyType;
	private SkillStatus status;
	private Long skillId;
	private String skillName;
	private Long empId;


	public Long getSkillId() {
		return skillId;
	}
	public void setSkillId(Long skillId) {
		this.skillId = skillId;
	}
	public String getSkillName() {
		return skillName;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	public Long getEmpId() {
		return empId;
	}
	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public CompetencyCategory getCompetencyCategory() {
		return competencyCategory;
	}
	public void setCompetencyCategory(CompetencyCategory competencyCategory) {
		this.competencyCategory = competencyCategory;
	}
	public CompetencyType getCompetencyType() {
		return competencyType;
	}
	public void setCompetencyType(CompetencyType competencyType) {
		this.competencyType = competencyType;
	}
	public SkillStatus getStatus() {
		return status;
	}
	public void setStatus(SkillStatus status) {
		this.status = status;
	}
	
}
