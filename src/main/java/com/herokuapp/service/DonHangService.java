package com.herokuapp.service;

import com.herokuapp.domain.khachhang.AddDonHang;
import com.herokuapp.domain.khachhang.AddDonHangVangLai;
import com.herokuapp.domain.khachhang.list.ListDonHang;

public interface DonHangService {
	void addDonHang(AddDonHang addDonHang);
	
	void addDonHangKhachVangLai(AddDonHangVangLai addDonHangVangLai);

	ListDonHang getLichSuDonHangByKhachHangId(String makh);
}
