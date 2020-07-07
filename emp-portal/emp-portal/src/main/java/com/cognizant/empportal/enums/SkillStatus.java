package com.cognizant.empportal.enums;

public enum SkillStatus {
	PENDING("Pending"), APPROVED("Approved"),NA("Not Allocated");
	private String value;

	SkillStatus(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
