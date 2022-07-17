package com.herokuapp.domain.khachhang;

public class InfoGiayDonHang {

	private String magiay;
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

	public String getMagiay() {
		return magiay;
	}

	public void setMagiay(String magiay) {
		this.magiay = magiay;
	}
	
	

	@Override
	public int hashCode() {
		
		return this.magiay.hashCode()^this.masize.hashCode()^this.mamau.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		InfoGiayDonHang infoGiayDonHang = (InfoGiayDonHang) obj;
		if (infoGiayDonHang.magiay.equals(this.magiay) && infoGiayDonHang.masize.equals(this.masize)
				&& infoGiayDonHang.mamau.equals(this.mamau)) {
			return true;
		}
		return false;
	}

}
