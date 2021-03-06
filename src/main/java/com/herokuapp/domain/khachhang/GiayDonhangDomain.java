package com.herokuapp.domain.khachhang;

import com.herokuapp.abstracts.AbstractsDomain;
import com.herokuapp.entity.GiayDonhang;

public class GiayDonhangDomain extends AbstractsDomain<GiayDonhang> {

	private String magiay;
	private String tengiay;
	private int soluong;
	private int tonggia;
	private MauSacDomain mauSac = new MauSacDomain();
	private SizeDomain size = new SizeDomain();

	public GiayDonhangDomain() {

	}

	@Override
	public void converToDomain(GiayDonhang giayDonHang) {
//		this.magiay = giayDonHang.getGiay().getMagiay();
//		this.tengiay = giayDonHang.getGiay().getTengiay();
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

	public MauSacDomain getMauSac() {
		return mauSac;
	}

	public void setMauSac(MauSacDomain mauSac) {
		this.mauSac = mauSac;
	}

	public SizeDomain getSize() {
		return size;
	}

	public void setSize(SizeDomain size) {
		this.size = size;
	}

}
