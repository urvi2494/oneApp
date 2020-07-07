package com.cognizant.empportal.enums;

public enum CompetencyType {
	CURRENT("Current"), ASPIRATIONAL("Aspirational"), HISTORICAL("Historical"),NA("Not Assigned");
	private String value;

	CompetencyType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
