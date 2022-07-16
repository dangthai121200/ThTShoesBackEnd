package com.herokuapp.service.khachhang;

import com.herokuapp.domain.khachhang.AddDonHang;
import com.herokuapp.domain.khachhang.AddDonHangVangLai;
import com.herokuapp.domain.khachhang.list.ListDonHang;
import com.herokuapp.domain.khachhang.list.ListDonHangVangLai;

public interface DonHangService {
	void addDonHang(AddDonHang addDonHang);
	
	String addDonHangKhachVangLai(AddDonHangVangLai addDonHangVangLai);

	ListDonHang getLichSuDonHangByKhachHangId(String makh);

	ListDonHangVangLai getLichSuDonHangByKhachVangLaiId(String idKVL);
}
