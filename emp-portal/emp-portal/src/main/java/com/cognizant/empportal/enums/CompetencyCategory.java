package com.cognizant.empportal.enums;

public enum CompetencyCategory {
	BEHAVIOURAL("Behavioural"), FUNCTIONAL("Functional"), DOMAIN("Domain"), TECHNICAL("Technical"),NA("Not Available");
	private String value;

	CompetencyCategory(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
