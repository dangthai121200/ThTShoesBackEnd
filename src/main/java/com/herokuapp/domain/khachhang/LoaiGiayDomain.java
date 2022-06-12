package com.herokuapp.domain.khachhang;

import com.herokuapp.abstracts.AbstractsDomain;
import com.herokuapp.entity.Loaigiay;

public class LoaiGiayDomain extends AbstractsDomain<Loaigiay> {
	private String maloaigiay;

	private String tenloai;

	public LoaiGiayDomain() {
	}

	public String getMaloaigiay() {
		return maloaigiay;
	}

	public void setMaloaigiay(String maloaigiay) {
		this.maloaigiay = maloaigiay;
	}

	public String getTenloai() {
		return tenloai;
	}

	public void setTenloai(String tenloai) {
		this.tenloai = tenloai;
	}

	@Override
	public void converToDomain(Loaigiay loaigiay) {
		this.maloaigiay = loaigiay.getMaloaigiay();
		this.tenloai = loaigiay.getTenloai();
	}

	@Override
	public Loaigiay converToEntity() {
		return null;
	}

}
