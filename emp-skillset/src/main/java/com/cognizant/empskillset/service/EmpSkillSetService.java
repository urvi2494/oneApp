package com.cognizant.empskillset.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.empskillset.model.EmpSkillMapping;
import com.cognizant.empskillset.repo.EmpSkillMappingRepo;
import com.cognizant.empskillset.utils.CustomModelMapper;
import com.cognizant.empskillset.vo.SkillSetVO;

@Service
public class EmpSkillSetService {

	@Autowired
	EmpSkillMappingRepo empSkillMappingRepo;
	
	@Autowired
	CustomModelMapper customModelMapper;
	
	public void addSkill(SkillSetVO skillSetVO){
	    
		EmpSkillMapping empSkillMapping=customModelMapper.getEmpSkillMapEntityfromSkillSetVO(skillSetVO);
		empSkillMappingRepo.save(empSkillMapping);
	}
	
	public List<SkillSetVO> viewEmpSkillById(Long empId) {
		System.out.println("inside viewEmpSkillById--->EmpSkillSetService");
		List<EmpSkillMapping> empSkillMapping= empSkillMappingRepo.findSkillByEmpId(empId);
		
		return customModelMapper.getSkillSetVOfromEmpSkillMapEntity(empSkillMapping);
		
	}
	
}
