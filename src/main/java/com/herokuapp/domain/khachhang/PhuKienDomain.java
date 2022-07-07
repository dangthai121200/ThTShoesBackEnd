package com.herokuapp.domain.khachhang;

import java.util.ArrayList;
import java.util.List;

import com.herokuapp.abstracts.AbstractsDomain;
import com.herokuapp.entity.Phukien;

public class PhuKienDomain extends AbstractsDomain<Phukien> {
	private String mapk;
	private int gia;
	private String mota;
	private int soluong;
	private String tenpk;
	private String urlanh;
	private List<HinhDomain> hinhs = new ArrayList<>();
	private LoaiPhuKienDomain loaiPhuKien = new LoaiPhuKienDomain();

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

	public List<HinhDomain> getHinhs() {
		return hinhs;
	}

	public void setHinhs(List<HinhDomain> hinhs) {
		this.hinhs = hinhs;
	}

	public LoaiPhuKienDomain getLoaiPhuKien() {
		return loaiPhuKien;
	}

	public void setLoaiPhuKien(LoaiPhuKienDomain loaiPhuKien) {
		this.loaiPhuKien = loaiPhuKien;
	}

	public String getUrlanh() {
		return urlanh;
	}

	public void setUrlanh(String urlanh) {
		this.urlanh = urlanh;
	}

	@Override
	public void converToDomain(Phukien phuKien) {
		this.mapk = phuKien.getMapk();
		this.gia = phuKien.getGia();
		this.mota = phuKien.getMota();
		this.soluong = phuKien.getSoluong();
		this.tenpk = phuKien.getTenpk();
		this.urlanh = phuKien.getUrlAnh();
		this.loaiPhuKien.converToDomain(phuKien.getLoaiphukien());
		phuKien.getHinhs().forEach(hinh -> {
			HinhDomain hinhDomain = new HinhDomain();
			hinhDomain.converToDomain(hinh);
			this.hinhs.add(hinhDomain);
		});

	}

	@Override
	public Phukien converToEntity() {
		return null;
	}

}
