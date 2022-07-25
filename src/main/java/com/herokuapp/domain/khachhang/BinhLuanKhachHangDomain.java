package com.herokuapp.domain.khachhang;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.herokuapp.abstracts.AbstractsDomain;
import com.herokuapp.entity.Binhluan;

public class BinhLuanKhachHangDomain extends AbstractsDomain<Binhluan> {
	private String mabl;
	private String mota;
	private Date thoigian;
	private String masp;
	private KhachHangDomain khachHangDomain = new KhachHangDomain();

	public BinhLuanKhachHangDomain() {

	}

	public String getMabl() {
		return mabl;
	}

	public void setMabl(String mabl) {
		this.mabl = mabl;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public Date getThoigian() {
		return thoigian;
	}

	public void setThoigian(Date thoigian) {
		this.thoigian = thoigian;
	}

	public String getMasp() {
		return masp;
	}

	public void setMasp(String masp) {
		this.masp = masp;
	}

	public KhachHangDomain getKhachHangDomain() {
		return khachHangDomain;
	}

	public void setKhachHangDomain(KhachHangDomain khachHangDomain) {
		this.khachHangDomain = khachHangDomain;
	}

	@Override
	public void converToDomain(Binhluan binhluan) {
		this.mabl = binhluan.getMabl();
		this.thoigian = binhluan.getThoigian();
		this.mota = binhluan.getMota();
		khachHangDomain.converToDomain(binhluan.getKhachhang());
	}

	@Override
	public Binhluan converToEntity() {
		// TODO Auto-generated method stub
		return null;
	}

}
