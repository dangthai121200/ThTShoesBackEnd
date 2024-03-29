package com.herokuapp.domain.admin;

import javax.validation.Valid;

import com.herokuapp.domain.common.TaiKhoanDomain;

public class InfoNhanvienDangKy {
	
	@Valid
	private NhanvienDomain nhanvien;
	
	@Valid
	private TaiKhoanDomain taikhoan;

	public InfoNhanvienDangKy() {

	}

	public NhanvienDomain getNhanvien() {
		return nhanvien;
	}

	public void setNhanvien(NhanvienDomain nhanvien) {
		this.nhanvien = nhanvien;
	}

	public TaiKhoanDomain getTaikhoan() {
		return taikhoan;
	}

	public void setTaikhoan(TaiKhoanDomain taikhoan) {
		this.taikhoan = taikhoan;
	}

}
