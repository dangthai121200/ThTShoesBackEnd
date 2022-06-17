package com.herokuapp.domain.khachhang;

import com.herokuapp.abstracts.AbstractsDomain;
import com.herokuapp.entity.Phukien;

public class PhuKienDomain extends AbstractsDomain<Phukien> {
	private String mapk;
	private int gia;
	private String mota;
	private int soluong;
	private String tenpk;
	private HinhDomain hinh;
	private LoaiPhuKienDomain loaiPhuKien;

	public PhuKienDomain() {

	}

	public String getMapk() {
		return mapk;
	}

	public void setMapk(String mapk) {
		this.mapk = mapk;
	}

	public int getGia() {
		return gia;
	}

	public void setGia(int gia) {
		this.gia = gia;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public String getTenpk() {
		return tenpk;
	}

	public void setTenpk(String tenpk) {
		this.tenpk = tenpk;
	}

	public HinhDomain getHinh() {
		return hinh;
	}

	public void setHinh(HinhDomain hinh) {
		this.hinh = hinh;
	}

	public LoaiPhuKienDomain getLoaiPhuKien() {
		return loaiPhuKien;
	}

	public void setLoaiPhuKien(LoaiPhuKienDomain loaiPhuKien) {
		this.loaiPhuKien = loaiPhuKien;
	}

	@Override
	public void converToDomain(Phukien phuKien) {
		this.mapk = phuKien.getMapk();
		this.gia = phuKien.getGia();
		this.mota = phuKien.getMota();
		this.soluong = phuKien.getSoluong();
		this.tenpk = phuKien.getTenpk();
	}

	@Override
	public Phukien converToEntity() {
		return null;
	}

}
