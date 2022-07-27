package com.herokuapp.domain.admin;

import java.util.Date;
import java.util.List;

import com.herokuapp.abstracts.AbstractsDomain;
import com.herokuapp.entity.Binhluan;

public class BinhLuanAdminDomain extends AbstractsDomain<Binhluan> {

	private String mabl;
	private String mota;
	private Date thoigian;
	private GiayAdminDomain giay;
	private PhuKienAdminDomain phukien;
	private KhachHangAdminDomain khachhang;
	private NhanVienAdminDomain nhanvien;
	private List<BinhLuanAdminDomain> binhluans;

	public BinhLuanAdminDomain() {

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

	public GiayAdminDomain getGiay() {
		return giay;
	}

	public void setGiay(GiayAdminDomain giay) {
		this.giay = giay;
	}

	public PhuKienAdminDomain getPhukien() {
		return phukien;
	}

	public void setPhukien(PhuKienAdminDomain phukien) {
		this.phukien = phukien;
	}

	public KhachHangAdminDomain getKhachhang() {
		return khachhang;
	}

	public void setKhachhang(KhachHangAdminDomain khachhang) {
		this.khachhang = khachhang;
	}

	public NhanVienAdminDomain getNhanvien() {
		return nhanvien;
	}

	public void setNhanvien(NhanVienAdminDomain nhanvien) {
		this.nhanvien = nhanvien;
	}

	public List<BinhLuanAdminDomain> getBinhluans() {
		return binhluans;
	}

	public void setBinhluans(List<BinhLuanAdminDomain> binhluans) {
		this.binhluans = binhluans;
	}

	@Override
	public void converToDomain(Binhluan binhluan) {
		this.mabl = binhluan.getMabl();
		this.mota = binhluan.getMota();
		this.thoigian = binhluan.getThoigian();
	}

	@Override
	public Binhluan converToEntity() {
		// TODO Auto-generated method stub
		return null;
	}

}
