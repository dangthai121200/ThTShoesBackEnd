package com.herokuapp.service.khachhang;

import com.herokuapp.domain.khachhang.AddDonHang;
import com.herokuapp.domain.khachhang.AddDonHangVangLai;
import com.herokuapp.domain.khachhang.list.ListDonHang;
import com.herokuapp.domain.khachhang.list.ListDonHangVangLai;
import com.herokuapp.handleexception.ThtShoesException;

public interface DonHangService {
	void addDonHang(AddDonHang addDonHang) throws ThtShoesException;
	
	String addDonHangKhachVangLai(AddDonHangVangLai addDonHangVangLai) throws ThtShoesException;

	ListDonHang getLichSuDonHangByKhachHangId(String makh);

	ListDonHangVangLai getLichSuDonHangByKhachVangLaiId(String idKVL);

	void huyDonHangOfKhachHang(String madh, String makh) throws ThtShoesException;
}
