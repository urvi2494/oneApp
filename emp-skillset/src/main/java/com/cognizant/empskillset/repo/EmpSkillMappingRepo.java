package com.cognizant.empskillset.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cognizant.empskillset.model.EmpSkillMapping;

public interface EmpSkillMappingRepo extends JpaRepository<EmpSkillMapping, Long> {

	@Query("select esm from EmpSkillMapping esm inner join Skill s on esm.skill.skillId=s.skillId inner join Employee e on esm.employee.empId=e.empId  where e.empId=:empId")
	List<EmpSkillMapping> findSkillByEmpId(@Param("empId") Long empId);
}
