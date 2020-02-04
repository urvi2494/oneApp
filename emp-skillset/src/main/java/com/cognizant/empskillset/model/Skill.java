package com.cognizant.empskillset.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cognizant.empskillset.enums.CompetencyCategory;

@Entity
@Table(name="skill")
public class Skill {

	@Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="skill_id",nullable=false)
	private Long skillId;
	
	@Column(name="skill_name")
	private String skillName;
	
	@Enumerated(EnumType.STRING)
	@Column(name="category")
	private CompetencyCategory competencyCategory;

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

	public CompetencyCategory getCompetencyCategory() {
		return competencyCategory;
	}

	public void setCompetencyCategory(CompetencyCategory competencyCategory) {
		this.competencyCategory = competencyCategory;
	}
	
	
}
