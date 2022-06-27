package com.herokuapp.domain.khachhang;

import com.herokuapp.abstracts.AbstractsDomain;
import com.herokuapp.entity.Loaigiay;

public class LoaiGiayDomain extends AbstractsDomain<Loaigiay> {

	private String maloaigiay;
	private String tenloai;
	private DanhmucDomain danhMuc = new DanhmucDomain();

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

	public DanhmucDomain getDanhMuc() {
		return danhMuc;
	}

	public void setDanhMuc(DanhmucDomain danhMuc) {
		this.danhMuc = danhMuc;
	}

	@Override
	public void converToDomain(Loaigiay loaigiay) {
		this.maloaigiay = loaigiay.getMaloaigiay();
		this.tenloai = loaigiay.getTenloai();
		this.danhMuc.converToDomain(loaigiay.getDanhmuc());
	}

	@Override
	public Loaigiay converToEntity() {
		return null;
	}

}
