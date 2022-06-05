package com.herokuapp.enums;

public enum Quyen {

	ADMIN("ADMIN"), KHACHHANG("KHACHHANG"), NHANVIEN("NHANVIEN");

	private String name;

	private Quyen(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
