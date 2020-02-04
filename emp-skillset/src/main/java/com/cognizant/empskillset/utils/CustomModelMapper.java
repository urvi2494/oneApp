package com.cognizant.empskillset.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.cognizant.empskillset.enums.SkillStatus;
import com.cognizant.empskillset.model.EmpSkillMapping;
import com.cognizant.empskillset.model.Employee;
import com.cognizant.empskillset.model.Skill;
import com.cognizant.empskillset.vo.SkillSetVO;

@Component
public class CustomModelMapper {

	
	public EmpSkillMapping getEmpSkillMapEntityfromSkillSetVO(SkillSetVO skillSetVO)
	{
		EmpSkillMapping empSkillMapping=new EmpSkillMapping();
		empSkillMapping.setCompetencyType(skillSetVO.getCompetencyType());
		
		Employee emp=new Employee();
		emp.setEmpId(skillSetVO.getEmpId());
		empSkillMapping.setEmployee(emp);
		
		Skill skill=new Skill();
		skill.setSkillId(skillSetVO.getSkillId());
		empSkillMapping.setSkill(skill);
		
		empSkillMapping.setStatus(SkillStatus.PENDING);
		return empSkillMapping;
	}
	
	public List<SkillSetVO> getSkillSetVOfromEmpSkillMapEntity(List<EmpSkillMapping> empSkillMapList)
	{
		System.out.println("inside getSkillSetVOfromEmpSkillMapEntity---> CustomModelMapper");
		List<SkillSetVO> skillSetVOList=new ArrayList<>();
		empSkillMapList.forEach((e)-> {
			SkillSetVO skillSetVO=new SkillSetVO();
			skillSetVO.setCompetencyCategory(e.getSkill().getCompetencyCategory());
			skillSetVO.setCompetencyType(e.getCompetencyType());
			skillSetVO.setEmpId(e.getEmployee().getEmpId());
			skillSetVO.setSkillId(e.getSkill().getSkillId());
			skillSetVO.setSkillName(e.getSkill().getSkillName());
			skillSetVO.setStatus(e.getStatus());
			skillSetVOList.add(skillSetVO);
			System.out.println("skill set vo"+skillSetVO);
		});
		return skillSetVOList;
	}
}
