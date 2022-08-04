package com.herokuapp.service.admin;

import com.herokuapp.domain.admin.KhachHangAdminDomain;
import com.herokuapp.domain.admin.list.ListKhachHangAdmin;

public interface KhachHangAdminService {
	
	ListKhachHangAdmin getAllKhachHang();
	
	KhachHangAdminDomain getKhachHangById(String makh);
	
	int countAllKhachHang();
}
