package com.herokuapp.service;

import com.herokuapp.domain.khachhang.LoaigiayHangDanhmucDomain;

public interface LoaigiayHangDanhmucService {
	LoaigiayHangDanhmucDomain findByMaLgiayHang(int id);
}
