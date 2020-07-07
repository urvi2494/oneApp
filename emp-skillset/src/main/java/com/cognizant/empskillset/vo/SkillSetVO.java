package com.cognizant.empskillset.vo;

import com.cognizant.empskillset.enums.CompetencyCategory;
import com.cognizant.empskillset.enums.CompetencyType;
import com.cognizant.empskillset.enums.SkillStatus;

public class SkillSetVO {

	//private Long roleId;
	private CompetencyCategory competencyCategory;
	private CompetencyType competencyType;
	private SkillStatus status;
	private Long skillId;
	private String skillName;
	private Long empId;
	//private Long empSkillMappingId;

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
	@Override
	public String toString() {
		return "SkillSetVO [competencyCategory=" + competencyCategory + ", competencyType=" + competencyType
				+ ", status=" + status + ", skillId=" + skillId + ", skillName=" + skillName + ", empId=" + empId + "]";
	}
	
}
