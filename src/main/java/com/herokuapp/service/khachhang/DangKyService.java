package com.herokuapp.service.khachhang;

import com.herokuapp.domain.khachhang.InfoKhachHangDangKy;

public interface DangKyService {
	void dangKyKhachHang(InfoKhachHangDangKy infoDangKy);

	void authencationTaiKhoan(String manguoidung);
}
