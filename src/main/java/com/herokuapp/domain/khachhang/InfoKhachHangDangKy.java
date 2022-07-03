package com.herokuapp.domain.khachhang;

import com.herokuapp.domain.common.TaiKhoanDomain;

public class InfoKhachHangDangKy {

	private KhachHangDomain khachHang;
	private TaiKhoanDomain taiKhoan;

	public InfoKhachHangDangKy() {
	}

	public KhachHangDomain getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHangDomain khachHang) {
		this.khachHang = khachHang;
	}

	public TaiKhoanDomain getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(TaiKhoanDomain taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

}
