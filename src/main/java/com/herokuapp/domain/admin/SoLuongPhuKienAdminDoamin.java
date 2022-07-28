package com.herokuapp.domain.admin;

import java.util.Date;

import com.herokuapp.abstracts.AbstractsDomain;
import com.herokuapp.entity.SoluongPhukien;

public class SoLuongPhuKienAdminDoamin extends AbstractsDomain<SoluongPhukien> {

	private int id;
	private String mota;
	private Date ngaythem;
	private int soluong;
	private PhuKienAdminDomain phukien;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public Date getNgaythem() {
		return ngaythem;
	}

	public void setNgaythem(Date ngaythem) {
		this.ngaythem = ngaythem;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public PhuKienAdminDomain getPhukien() {
		return phukien;
	}

	public void setPhukien(PhuKienAdminDomain phukien) {
		this.phukien = phukien;
	}

	@Override
	public void converToDomain(SoluongPhukien soluongPhukien) {
		this.id = soluongPhukien.getId();
		this.mota = soluongPhukien.getMota();
		this.ngaythem = soluongPhukien.getNgaythem();
		this.soluong = soluongPhukien.getSoluong();

	}

	@Override
	public SoluongPhukien converToEntity() {
		// TODO Auto-generated method stub
		return null;
	}

}
