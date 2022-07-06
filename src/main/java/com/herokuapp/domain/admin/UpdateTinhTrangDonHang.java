package com.herokuapp.domain.admin;

import com.herokuapp.enums.TinhTrang;

public class UpdateTinhTrangDonHang {
	
	private String madonhang;
	private TinhTrang tinhTrang;

	public String getMadonhang() {
		return madonhang;
	}

	public void setMadonhang(String madonhang) {
		this.madonhang = madonhang;
	}

	public TinhTrang getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(TinhTrang tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

}
