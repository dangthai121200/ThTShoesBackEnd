package com.herokuapp.enums;

public enum TinhTrang {
	CHODUYET("CHODUYET"), DADUYET("DADUYET"), DAGIAO("DAGIAO"), TUCHOI("TUCHOI");

	private String value;

	TinhTrang(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
