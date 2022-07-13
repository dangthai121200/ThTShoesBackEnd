package com.herokuapp.domain.admin;

import com.herokuapp.abstracts.AbstractsDomain;
import com.herokuapp.entity.PhukienDonhang;

public class PhukienDonhangAdminDomain extends AbstractsDomain<PhukienDonhang> {

	private String maphukien;
	private String tenphukien;
	private int soluong;
	private int tonggia;

	public PhukienDonhangAdminDomain() {

	}

	public String getMaphukien() {
		return maphukien;
	}

	public void setMaphukien(String maphukien) {
		this.maphukien = maphukien;
	}

	public String getTenphukien() {
		return tenphukien;
	}

	public void setTenphukien(String tenphukien) {
		this.tenphukien = tenphukien;
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
	public void converToDomain(PhukienDonhang phukienDonhang) {
		this.maphukien = phukienDonhang.getPhukien().getMapk();
		this.tenphukien = phukienDonhang.getPhukien().getTenpk();
		this.soluong = phukienDonhang.getSoluong();
		this.tonggia = phukienDonhang.getTonggia();

	}

	@Override
	public PhukienDonhang converToEntity() {
		// TODO Auto-generated method stub
		return null;
	}

}
