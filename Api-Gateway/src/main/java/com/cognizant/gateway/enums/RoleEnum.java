package com.cognizant.gateway.enums;

public enum RoleEnum {
		
		ADMIN("Admin"), USER("User");
		private String value;

		RoleEnum(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}


