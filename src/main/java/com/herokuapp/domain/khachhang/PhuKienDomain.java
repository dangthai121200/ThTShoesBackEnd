package com.herokuapp.domain.khachhang;

import com.herokuapp.abstracts.AbstractsDomain;
import com.herokuapp.entity.Phukien;

public class PhuKienDomain extends AbstractsDomain<Phukien> {
	private String mapk;
	private int gia;
	private String mota;
	private int soluong;
	private String tenpk;
	private HinhDomain hinhDomain;
	private LoaiPhuKienDomain loaiPhuKienDomain;

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

	public HinhDomain getHinhDomain() {
		return hinhDomain;
	}

	public void setHinhDomain(HinhDomain hinhDomain) {
		this.hinhDomain = hinhDomain;
	}

	public LoaiPhuKienDomain getLoaiPhuKienDomain() {
		return loaiPhuKienDomain;
	}

	public void setLoaiPhuKienDomain(LoaiPhuKienDomain loaiPhuKienDomain) {
		this.loaiPhuKienDomain = loaiPhuKienDomain;
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
