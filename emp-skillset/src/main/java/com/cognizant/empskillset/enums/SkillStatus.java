package com.cognizant.empskillset.enums;

public enum SkillStatus {
	PENDING("Pending"), APPROVED("Approved");
	private String value;

	SkillStatus(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
