package com.herokuapp.domain.admin;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.herokuapp.util.ThtShoesMess;

public class SoLuongGiaySizeMau {
	
	@NotEmpty
	@Min(value = 0L, message = ThtShoesMess.MIN_NUMBER + "của id là 0")
	@Max(value = 9999999999L, message = ThtShoesMess.MAX_NUMBER + "của id là 9999999999")
	private int id;
	
	@NotNull
	@Min(value = 0L, message = ThtShoesMess.MIN_NUMBER + "của soluong là 0")
	@Max(value = 9999999999L, message = ThtShoesMess.MAX_NUMBER + "của soluong là 9999999999")
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
