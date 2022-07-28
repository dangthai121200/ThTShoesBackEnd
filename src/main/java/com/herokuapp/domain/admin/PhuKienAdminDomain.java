package com.herokuapp.domain.admin;

import java.util.ArrayList;
import java.util.List;

import com.herokuapp.abstracts.AbstractsDomain;
import com.herokuapp.entity.Phukien;

public class PhuKienAdminDomain extends AbstractsDomain<Phukien> {
	private String mapk;
	private int gia;
	private String mota;
	private int soluong;
	private String tenpk;
	private String urlanh;
	private List<HinhAdminDomain> hinhs = new ArrayList<>();
	private LoaiPhuKienAdminDomain loaiPhuKien = new LoaiPhuKienAdminDomain();
	private List<SoLuongPhuKienAdminDoamin> soluongphukiens = new ArrayList<>();

	public PhuKienAdminDomain() {

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

	public String getUrlanh() {
		return urlanh;
	}

	public void setUrlanh(String urlanh) {
		this.urlanh = urlanh;
	}

	public List<HinhAdminDomain> getHinhs() {
		return hinhs;
	}

	public void setHinhs(List<HinhAdminDomain> hinhs) {
		this.hinhs = hinhs;
	}

	public LoaiPhuKienAdminDomain getLoaiPhuKien() {
		return loaiPhuKien;
	}

	public void setLoaiPhuKien(LoaiPhuKienAdminDomain loaiPhuKien) {
		this.loaiPhuKien = loaiPhuKien;
	}
	
	

	public List<SoLuongPhuKienAdminDoamin> getSoluongphukiens() {
		return soluongphukiens;
	}

	public void setSoluongphukiens(List<SoLuongPhuKienAdminDoamin> soluongphukiens) {
		this.soluongphukiens = soluongphukiens;
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
			HinhAdminDomain hinhDomain = new HinhAdminDomain();
			hinhDomain.converToDomain(hinh);
			this.hinhs.add(hinhDomain);
		});

	}

	@Override
	public Phukien converToEntity() {
		return null;
	}

}
