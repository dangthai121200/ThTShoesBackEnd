package com.herokuapp.domain.khachhang;

public class InfoKhachHangDangKy {
	
	private KhachHangDomain khachHangDomain;
	private TaiKhoanDomain taiKhoanDomain;

	public InfoKhachHangDangKy() {
	}

	public KhachHangDomain getKhachHangDomain() {
		return khachHangDomain;
	}

	public void setKhachHangDomain(KhachHangDomain khachHangDomain) {
		this.khachHangDomain = khachHangDomain;
	}

	public TaiKhoanDomain getTaiKhoanDomain() {
		return taiKhoanDomain;
	}

	public void setTaiKhoanDomain(TaiKhoanDomain taiKhoanDomain) {
		this.taiKhoanDomain = taiKhoanDomain;
	}

}
