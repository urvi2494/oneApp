package com.cognizant.empskillset.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cognizant.empskillset.enums.CompetencyType;
import com.cognizant.empskillset.enums.SkillStatus;

@Entity
@Table(name = "employee_skill_mapping")
public class EmpSkillMapping {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_skill_mapping_id", nullable = false)
	private Long empSkillMappingId;

	@ManyToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;

	@ManyToOne
	@JoinColumn(name = "skill_id")
	private Skill skill;

	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private SkillStatus status;

	@Enumerated(EnumType.STRING)
	@Column(name = "competency_type")
	private CompetencyType competencyType;

	public Long getEmpSkillMappingId() {
		return empSkillMappingId;
	}

	public void setEmpSkillMappingId(Long empSkillMappingId) {
		this.empSkillMappingId = empSkillMappingId;
	}

	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	public SkillStatus getStatus() {
		return status;
	}

	public void setStatus(SkillStatus status) {
		this.status = status;
	}

	public CompetencyType getCompetencyType() {
		return competencyType;
	}

	public void setCompetencyType(CompetencyType competencyType) {
		this.competencyType = competencyType;
	}

}
