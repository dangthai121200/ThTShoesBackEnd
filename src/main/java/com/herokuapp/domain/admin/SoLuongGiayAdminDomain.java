package com.herokuapp.domain.admin;

import java.util.Date;

import com.herokuapp.abstracts.AbstractsDomain;
import com.herokuapp.entity.SoluongGiay;

public class SoLuongGiayAdminDomain extends AbstractsDomain<SoluongGiay> {

	private int id;
	private int soluong;
	private Date ngaythem;
	private String mota;
	private int idGiaySizeMau;
	private GiayAdminDomain giay;
	private SizeAdminDomain size;
	private MauSacAdminDomain mau;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSoluongthem() {
		return soluong;
	}

	public void setSoluongthem(int soluongthem) {
		this.soluong = soluongthem;
	}

	public Date getNgaythem() {
		return ngaythem;
	}

	public void setNgaythem(Date ngaythem) {
		this.ngaythem = ngaythem;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
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

	public MauSacAdminDomain getMau() {
		return mau;
	}

	public void setMau(MauSacAdminDomain mau) {
		this.mau = mau;
	}

	public int getIdGiaySizeMau() {
		return idGiaySizeMau;
	}

	public void setIdGiaySizeMau(int idGiaySizeMau) {
		this.idGiaySizeMau = idGiaySizeMau;
	}

	@Override
	public void converToDomain(SoluongGiay soluongGiay) {
		this.id = soluongGiay.getId();
		this.soluongthem = soluongGiay.getSoluongthem();
		this.ngaythem = soluongGiay.getNgaythem();
		this.mota = soluongGiay.getMota();
		this.idGiaySizeMau = soluongGiay.getIdGiaySizeMau();

	}

	@Override
	public SoluongGiay converToEntity() {
		// TODO Auto-generated method stub
		return null;
	}

}
