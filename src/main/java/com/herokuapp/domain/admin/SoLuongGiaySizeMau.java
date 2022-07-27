package com.herokuapp.domain.admin;

public class SoLuongGiaySizeMau {
	private int id;
	private int soluong;
	private String note;

	public SoLuongGiaySizeMau() {
		super();

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
