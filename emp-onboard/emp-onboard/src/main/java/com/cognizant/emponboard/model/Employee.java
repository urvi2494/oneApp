package com.cognizant.emponboard.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee_master",catalog="empdb")
public class Employee {

	
	@Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="employee_id",nullable=false)
	private Long empId;
	
	@Column(name="fname",length=8,nullable=false)
	private String fname;
	
	@Column(name="lname",length=15,nullable=false)
	private String lname;
	
	@Column(name="designation")
	private String designation;
	
	@Column(name="experience")
	private Integer yearsOfExp;
	
	@Column(name="email_id")
	private String emailId;
	
	@Column(name="phone_number",length=10,nullable=false)
	private String phoneNumber;

	
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
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", fname=" + fname + ", lname=" + lname + ", designation=" + designation
				+ ", yearsOfExp=" + yearsOfExp + ", emailId=" + emailId + ", phoneNumber=" + phoneNumber + "]";
	}
	
	
	
}
