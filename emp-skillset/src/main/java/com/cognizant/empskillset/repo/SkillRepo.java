package com.cognizant.empskillset.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.empskillset.model.Skill;

public interface SkillRepo extends JpaRepository<Skill, Long> {

}
