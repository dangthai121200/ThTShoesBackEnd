package com.herokuapp.domain.khachhang;

public class InfoGiayDonHang {
	
	private String masize;
	private String mamau;
	private int soluong;

	public InfoGiayDonHang() {

	}

	public String getMamau() {
		return mamau;
	}

	public void setMamau(String mamau) {
		this.mamau = mamau;
	}

	public String getMasize() {
		return masize;
	}

	public void setMasize(String masize) {
		this.masize = masize;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

}
