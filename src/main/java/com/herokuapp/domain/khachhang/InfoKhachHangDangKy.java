package com.herokuapp.domain.khachhang;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.herokuapp.domain.common.TaiKhoanDomain;
import com.herokuapp.util.ThtShoesMess;

public class InfoKhachHangDangKy {

	@Valid
	@NotNull(message = ThtShoesMess.KHACH_HANG)
	private KhachHangDomain khachHang;

	@Valid
	@NotNull(message = ThtShoesMess.TAIKHOAN)
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
