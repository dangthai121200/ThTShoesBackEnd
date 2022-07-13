package com.herokuapp.enums;

public enum HanhDong {
	DUYET("DUYET"), GIAO("GIAO"), HUY("HUY");

	private String value;

	HanhDong (String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
