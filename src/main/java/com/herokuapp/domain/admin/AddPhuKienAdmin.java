package com.herokuapp.domain.admin;

import com.herokuapp.abstracts.AbstractsDomain;
import com.herokuapp.entity.Phukien;

public class AddPhuKienAdmin extends AbstractsDomain<Phukien> {

	private String mapk;
	private String tenpk;
	private int gia;
	private int soluong;
	private String maLoaiPk;
	private String mota;
	private String motaSoLuong;

	public AddPhuKienAdmin() {

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

	public String getMaLoaiPk() {
		return maLoaiPk;
	}

	public void setMaLoaiPk(String maLoaiPk) {
		this.maLoaiPk = maLoaiPk;
	}

	public String getMapk() {
		return mapk;
	}

	public void setMapk(String mapk) {
		this.mapk = mapk;
	}

	@Override
	public void converToDomain(Phukien object) {
		// TODO Auto-generated method stub

	}

	public String getMotaSoLuong() {
		return motaSoLuong;
	}

	public void setMotaSoLuong(String motaSoLuong) {
		this.motaSoLuong = motaSoLuong;
	}

	@Override
	public Phukien converToEntity() {
		Phukien phukien = new Phukien();
		phukien.setTenpk(this.tenpk);
		phukien.setGia(this.gia);
		phukien.setSoluong(this.soluong);
		phukien.setMota(this.mota);
		return phukien;
	}

}
