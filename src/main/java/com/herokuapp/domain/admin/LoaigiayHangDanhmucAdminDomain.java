package com.herokuapp.domain.admin;

import com.herokuapp.abstracts.AbstractsDomain;
import com.herokuapp.controller.admin.DanhmucAdminDomain;
import com.herokuapp.controller.admin.HangAdminDomain;
import com.herokuapp.controller.admin.LoaiGiayAdminDomain;
import com.herokuapp.entity.LoaigiayHangDanhmuc;

public class LoaigiayHangDanhmucAdminDomain extends AbstractsDomain<LoaigiayHangDanhmuc> {

	private int maLgiayHang;
	private DanhmucAdminDomain danhmuc = new DanhmucAdminDomain();
	private HangAdminDomain hang = new HangAdminDomain();
	private LoaiGiayAdminDomain loaigiay = new LoaiGiayAdminDomain();

	public LoaigiayHangDanhmucAdminDomain() {

	}

	public int getMaLgiayHang() {
		return maLgiayHang;
	}

	public void setMaLgiayHang(int maLgiayHang) {
		this.maLgiayHang = maLgiayHang;
	}

	public DanhmucAdminDomain getDanhmuc() {
		return danhmuc;
	}

	public void setDanhmuc(DanhmucAdminDomain danhmuc) {
		this.danhmuc = danhmuc;
	}

	public HangAdminDomain getHang() {
		return hang;
	}

	public void setHang(HangAdminDomain hang) {
		this.hang = hang;
	}

	public LoaiGiayAdminDomain getLoaigiay() {
		return loaigiay;
	}

	public void setLoaigiay(LoaiGiayAdminDomain loaigiay) {
		this.loaigiay = loaigiay;
	}

	@Override
	public void converToDomain(LoaigiayHangDanhmuc loaigiayHangDanhmuc) {
		this.maLgiayHang = loaigiayHangDanhmuc.getId().getMaLgiayHang();
		this.danhmuc.converToDomain(loaigiayHangDanhmuc.getDanhmuc());
		this.hang.converToDomain(loaigiayHangDanhmuc.getHang());
		this.loaigiay.converToDomain(loaigiayHangDanhmuc.getLoaigiay());
	}

	@Override
	public LoaigiayHangDanhmuc converToEntity() {
		// TODO Auto-generated method stub
		return null;
	}

}
