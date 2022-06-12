package com.herokuapp.domain.khachhang;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.herokuapp.abstracts.AbstractsDomain;
import com.herokuapp.entity.Binhluan;

public class BinhLuanDomain extends AbstractsDomain<Binhluan> {

	private String mabl;
	private String mota;
	@Temporal(TemporalType.TIMESTAMP)
	private Date thoigian;
	private KhachHangDomain khachhang = new KhachHangDomain();

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

	public KhachHangDomain getKhachhang() {
		return khachhang;
	}

	public void setKhachhang(KhachHangDomain khachhang) {
		this.khachhang = khachhang;
	}

	@Override
	public void converToDomain(Binhluan binhluan) {
		this.mabl = binhluan.getMabl();
		this.mota = binhluan.getMota();
		this.thoigian = binhluan.getThoigian();
		this.khachhang.converToDomain(binhluan.getKhachhang());

	}

	@Override
	public Binhluan converToEntity() {
		// TODO Auto-generated method stub
		return null;
	}

}
