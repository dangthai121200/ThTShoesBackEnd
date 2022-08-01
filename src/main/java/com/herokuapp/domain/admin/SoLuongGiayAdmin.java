package com.herokuapp.domain.admin;

import java.util.Date;

import com.herokuapp.abstracts.AbstractsDomain;
import com.herokuapp.entity.SoluongGiay;

public class SoLuongGiayAdmin extends AbstractsDomain<SoluongGiay> {

	private int id;
	private int soluongthem;
	private Date ngaythem;
	private String mota;
	private int idGiaySizeMau;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSoluongthem() {
		return soluongthem;
	}

	public void setSoluongthem(int soluongthem) {
		this.soluongthem = soluongthem;
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

	public int getIdGiaySizeMau() {
		return idGiaySizeMau;
	}

	public void setIdGiaySizeMau(int idGiaySizeMau) {
		this.idGiaySizeMau = idGiaySizeMau;
	}

	@Override
	public void converToDomain(SoluongGiay object) {
		// TODO Auto-generated method stub

	}

	@Override
	public SoluongGiay converToEntity() {
		// TODO Auto-generated method stub
		return null;
	}

}
