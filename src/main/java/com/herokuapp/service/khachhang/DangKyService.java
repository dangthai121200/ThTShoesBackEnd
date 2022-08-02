package com.herokuapp.service.khachhang;

import javax.mail.MessagingException;

import com.herokuapp.domain.khachhang.InfoKhachHangDangKy;

public interface DangKyService {
	void dangKyKhachHang(InfoKhachHangDangKy infoDangKy) throws MessagingException;

	void authencationTaiKhoan(String manguoidung);
}
