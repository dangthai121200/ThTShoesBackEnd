package com.herokuapp.service.admin;

import com.herokuapp.domain.admin.InfoNhanvienDangKy;
import com.herokuapp.domain.admin.NhanVienAdminDomain;

public interface NhanVienService {
	void addNhanVien(InfoNhanvienDangKy infoNhanvienDangKy);

	NhanVienAdminDomain getInfoNhanVien(String idMaNhanvien);
}
