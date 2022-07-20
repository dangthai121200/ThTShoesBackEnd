package com.herokuapp.service.admin;

import com.herokuapp.domain.admin.KhuyenMaiAdminDomain;
import com.herokuapp.domain.admin.list.ListKhuyenMaiAdmin;

public interface KhuyenMaiAdminService {
	ListKhuyenMaiAdmin getAllKhuyenMai();

	KhuyenMaiAdminDomain getKhuyenMaiById(String makm);
}
