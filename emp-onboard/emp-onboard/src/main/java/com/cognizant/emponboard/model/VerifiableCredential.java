
package com.cognizant.emponboard.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="verifiable_credential",catalog="vcdb")
public class VerifiableCredential {

	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="adhar_number")
	private String adharNumber;
	
	@Column(name="passport_number")
	private String passportNumber;
	
	@Column(name="pan_card")
	private String PANCard;
	
	
	  @Column(name="employee_id") private Long employeeId;
	 
	/*
	 * @OneToOne
	 * 
	 * @JoinColumn(name="employee_id",table="employee_master") private Employee
	 * employee;
	 */
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAdharNumber() {
		return adharNumber;
	}

	public void setAdharNumber(String adharNumber) {
		this.adharNumber = adharNumber;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getPANCard() {
		return PANCard;
	}

	public void setPANCard(String pANCard) {
		PANCard = pANCard;
	}

	/*
	 * public Employee getEmployee() { return employee; }
	 * 
	 * public void setEmployee(Employee employee) { this.employee = employee; }
	 */
	
	  public Long getEmployeeId() { return employeeId; }
	  
	  public void setEmployeeId(Long employeeId) { this.employeeId = employeeId; }
	 

	
	
}
