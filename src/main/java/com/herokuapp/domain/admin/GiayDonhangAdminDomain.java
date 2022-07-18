package com.herokuapp.domain.admin;

import com.herokuapp.abstracts.AbstractsDomain;
import com.herokuapp.entity.GiayDonhang;

public class GiayDonhangAdminDomain extends AbstractsDomain<GiayDonhang> {

	private GiayAdminDomain giay;
	private SizeAdminDomain size;
	private MauSacAdminDomain mausac;
	private int soluong;
	private int tonggia;

	public GiayDonhangAdminDomain() {

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

	public GiayAdminDomain getGiay() {
		return giay;
	}

	public void setGiay(GiayAdminDomain giay) {
		this.giay = giay;
	}

	public SizeAdminDomain getSize() {
		return size;
	}

	public void setSize(SizeAdminDomain size) {
		this.size = size;
	}

	public MauSacAdminDomain getMausac() {
		return mausac;
	}

	public void setMausac(MauSacAdminDomain mausac) {
		this.mausac = mausac;
	}

	@Override
	public void converToDomain(GiayDonhang giayDonHang) {
//		this.magiay = giayDonHang.getGiay().getMagiay();
//		this.tengiay = giayDonHang.getGiay().getTengiay();
		this.soluong = giayDonHang.getSoluong();
		this.tonggia = giayDonHang.getTonggia();

	}

	@Override
	public GiayDonhang converToEntity() {
		// TODO Auto-generated method stub
		return null;
	}

}
