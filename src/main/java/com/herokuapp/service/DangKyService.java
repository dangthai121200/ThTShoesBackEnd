package com.herokuapp.service;

import com.herokuapp.domain.khachhang.InfoKhachHangDangKy;

public interface DangKyService {
	void dangKyKhachHang(InfoKhachHangDangKy infoDangKy);

	void dangKyNhanVien(InfoKhachHangDangKy infoDangKy);
	
	void authencationTaiKhoan(String manguoidung);
}
