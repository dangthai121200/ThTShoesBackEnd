package com.herokuapp.domain.admin;

import com.herokuapp.abstracts.AbstractsDomain;
import com.herokuapp.entity.Khachhang;

public class KhachHangAdminDomain extends AbstractsDomain<Khachhang> {
	private String makh;
	private String diachi;
	private String ho;
	private Long sdt;
	private String ten;
	private TaiKhoanAdminDomain taiKhoan = new TaiKhoanAdminDomain();

	public KhachHangAdminDomain() {
	}

	public String getMakh() {
		return makh;
	}

	public void setMakh(String makh) {
		this.makh = makh;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getHo() {
		return ho;
	}

	public void setHo(String ho) {
		this.ho = ho;
	}

	public Long getSdt() {
		return sdt;
	}

	public void setSdt(Long sdt) {
		this.sdt = sdt;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public TaiKhoanAdminDomain getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(TaiKhoanAdminDomain taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	@Override
	public void converToDomain(Khachhang khachhang) {
		this.makh = khachhang.getMakh();
		this.ho = khachhang.getHo();
		this.ten = khachhang.getTen();
		this.diachi = (String) khachhang.getDiachi();
		this.sdt = khachhang.getSdt();
		this.taiKhoan.converToDomain(khachhang.getTaikhoan());
	}

	@Override
	public Khachhang converToEntity() {

		return null;
	}

}
