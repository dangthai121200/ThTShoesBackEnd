package com.herokuapp.domain.khachhang;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.herokuapp.abstracts.AbstractsDomain;
import com.herokuapp.entity.Binhluan;
import com.herokuapp.util.ThtShoesMess;

public class BinhLuanKhachHangDomain extends AbstractsDomain<Binhluan> {
	
	private String mabl;
	
	@NotEmpty(message = ThtShoesMess.BINH_LUAN)
	private String mota;
	
	private Date thoigian;
	
	@NotEmpty(message = ThtShoesMess.BINH_LUAN_MA_SP)
	@Length(max = 10, message = ThtShoesMess.MAX_LENGHT + "của masp là 10")
	private String masp;
	
	private KhachHangDomain khachHangDomain;
	
	private NhanVienKhachHangDomain nhanvien;
	
	private List<BinhLuanKhachHangDomain> binhluans;

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

	public NhanVienKhachHangDomain getNhanvien() {
		return nhanvien;
	}

	public void setNhanvien(NhanVienKhachHangDomain nhanvien) {
		this.nhanvien = nhanvien;
	}

	public List<BinhLuanKhachHangDomain> getBinhluans() {
		return binhluans;
	}

	public void setBinhluans(List<BinhLuanKhachHangDomain> binhluans) {
		this.binhluans = binhluans;
	}

	@Override
	public void converToDomain(Binhluan binhluan) {
		this.mabl = binhluan.getMabl();
		this.thoigian = binhluan.getThoigian();
		this.mota = binhluan.getMota();
	}

	@Override
	public Binhluan converToEntity() {
		// TODO Auto-generated method stub
		return null;
	}

}
