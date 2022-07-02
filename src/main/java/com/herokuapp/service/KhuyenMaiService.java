package com.herokuapp.service;

import com.herokuapp.domain.khachhang.KhuyenMaiDomain;
import com.herokuapp.domain.khachhang.list.ListKhuyenMai;

public interface KhuyenMaiService {
	ListKhuyenMai getAllKhuyenMai();
	KhuyenMaiDomain getKhuyenMaiById(String idKm);
}
