package com.herokuapp.domain.admin;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.herokuapp.util.ThtShoesMess;

public class AddGiayMauSizeAdmin {

	@NotEmpty(message = ThtShoesMess.MA_GIAY)
	@Length(max = 10, message = ThtShoesMess.MAX_LENGHT + "của mã giày là 10")
	private String magiay;

	@NotEmpty(message = ThtShoesMess.MA_SIZE)
	@Length(max = 10, message = ThtShoesMess.MAX_LENGHT + "của mã size là 10")
	private String masize;

	@NotEmpty(message = ThtShoesMess.MA_MAU)
	@Length(max = 10, message = ThtShoesMess.MAX_LENGHT + "của mã màu là 10")
	private String mamau;

	@NotNull
	private int soluong;

	public AddGiayMauSizeAdmin() {

	}

	public String getMagiay() {
		return magiay;
	}

	public void setMagiay(String magiay) {
		this.magiay = magiay;
	}

	public String getMasize() {
		return masize;
	}

	public void setMasize(String masize) {
		this.masize = masize;
	}

	public String getMamau() {
		return mamau;
	}

	public void setMamau(String mamau) {
		this.mamau = mamau;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

}
