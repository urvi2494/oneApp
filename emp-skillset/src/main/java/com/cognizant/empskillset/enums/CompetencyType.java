package com.cognizant.empskillset.enums;

public enum CompetencyType {
	CURRENT("Current"), ASPIRATIONAL("Aspirational"), HISTORICAL("Historical");
	private String value;

	CompetencyType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
