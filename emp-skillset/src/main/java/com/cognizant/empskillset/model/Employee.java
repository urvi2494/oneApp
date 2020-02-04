package com.cognizant.empskillset.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee_master")
public class Employee {

	@Column(name="name",length=8,nullable=false)
	private String name;
	
	@Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="employee_id",nullable=false)
	private Long empId;
	
	@Column(name="designation")
	private String designation;
	
	@Column(name="experience")
	private Integer yearsOfExp;
	
	
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
	@Override
	public String toString() {
		return "Employee [name=" + name + ", empId=" + empId + ", designation=" + designation + ", yearsOfExp="
				+ yearsOfExp + "]";
	}
	
	
}
