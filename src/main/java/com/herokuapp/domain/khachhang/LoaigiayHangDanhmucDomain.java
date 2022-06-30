package com.herokuapp.domain.khachhang;

import com.herokuapp.abstracts.AbstractsDomain;
import com.herokuapp.entity.LoaigiayHangDanhmuc;

public class LoaigiayHangDanhmucDomain extends AbstractsDomain<LoaigiayHangDanhmuc> {

	private int maLgiayHang;
	private DanhmucDomain danhmuc = new DanhmucDomain();
	private HangDomain hang = new HangDomain();
	private LoaiGiayDomain loaigiay = new LoaiGiayDomain();

	public LoaigiayHangDanhmucDomain() {

	}

	public int getMaLgiayHang() {
		return maLgiayHang;
	}

	public void setMaLgiayHang(int maLgiayHang) {
		this.maLgiayHang = maLgiayHang;
	}

	public DanhmucDomain getDanhmuc() {
		return danhmuc;
	}

	public void setDanhmuc(DanhmucDomain danhmuc) {
		this.danhmuc = danhmuc;
	}

	public HangDomain getHang() {
		return hang;
	}

	public void setHang(HangDomain hang) {
		this.hang = hang;
	}

	public LoaiGiayDomain getLoaigiay() {
		return loaigiay;
	}

	public void setLoaigiay(LoaiGiayDomain loaigiay) {
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
