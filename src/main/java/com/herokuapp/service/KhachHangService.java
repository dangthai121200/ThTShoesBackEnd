package com.herokuapp.service;

import com.herokuapp.domain.khachhang.KhachHangDomain;

public interface KhachHangService {
	KhachHangDomain getInfoKhachHangById(String idKh);

	KhachHangDomain updateInfoKhachHang(KhachHangDomain khachHangDomain);
	
	Boolean checkSdt(int sdt);
}
