package com.herokuapp.service.khachhang;

import com.herokuapp.domain.khachhang.BinhLuanKhachHangDomain;
import com.herokuapp.domain.khachhang.list.ListBinhLuanKhachHang;

public interface BinhLuanKhachHangService {
	void binhLuanSanPham (BinhLuanKhachHangDomain binhLuanKhachHangDomain, String makh);

	ListBinhLuanKhachHang getAllBinhLuanByIdGiay(String magiay);

}
