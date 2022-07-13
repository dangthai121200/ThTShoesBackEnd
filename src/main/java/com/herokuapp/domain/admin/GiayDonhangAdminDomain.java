package com.herokuapp.domain.admin;

import com.herokuapp.abstracts.AbstractsDomain;
import com.herokuapp.entity.GiayDonhang;

public class GiayDonhangAdminDomain extends AbstractsDomain<GiayDonhang> {

	private String magiay;
	private String tengiay;
	private int soluong;
	private int tonggia;

	public GiayDonhangAdminDomain() {

	}

	@Override
	public void converToDomain(GiayDonhang giayDonHang) {
		this.magiay = giayDonHang.getGiay().getMagiay();
		this.tengiay = giayDonHang.getGiay().getTengiay();
		this.soluong = giayDonHang.getSoluong();
		this.tonggia = giayDonHang.getTonggia();

	}

	public String getMagiay() {
		return magiay;
	}

	public void setMagiay(String magiay) {
		this.magiay = magiay;
	}

	public String getTengiay() {
		return tengiay;
	}

	public void setTengiay(String tengiay) {
		this.tengiay = tengiay;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public int getTonggia() {
		return tonggia;
	}

	public void setTonggia(int tonggia) {
		this.tonggia = tonggia;
	}

	@Override
	public GiayDonhang converToEntity() {
		// TODO Auto-generated method stub
		return null;
	}

}
