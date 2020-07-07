package com.cognizant.empskillset.enums;

public enum CompetencyCategory {
	BEHAVIOURAL("Behavioural"), FUNCTIONAL("Functional"), DOMAIN("Domain"), TECHNICAL("Technical");
	private String value;
	CompetencyCategory(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
