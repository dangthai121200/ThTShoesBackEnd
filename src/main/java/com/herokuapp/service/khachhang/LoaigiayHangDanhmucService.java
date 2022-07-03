package com.herokuapp.service.khachhang;

import com.herokuapp.domain.khachhang.LoaigiayHangDanhmucDomain;

public interface LoaigiayHangDanhmucService {
	LoaigiayHangDanhmucDomain findByMaLgiayHang(int id);
}
