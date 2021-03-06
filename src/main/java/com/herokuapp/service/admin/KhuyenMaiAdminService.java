package com.herokuapp.service.admin;

import com.herokuapp.domain.admin.AddKhuyenMaiAdminDomain;
import com.herokuapp.domain.admin.KhuyenMaiAdminDomain;
import com.herokuapp.domain.admin.list.ListKhuyenMaiAdmin;
import com.herokuapp.handleexception.ThtShoesException;

public interface KhuyenMaiAdminService {
	ListKhuyenMaiAdmin getAllKhuyenMai();

	KhuyenMaiAdminDomain getKhuyenMaiById(String makm);

	String addKhuyenMai(AddKhuyenMaiAdminDomain addKhuyenMaiAdminDomain);

	String updateKhuyenMai(AddKhuyenMaiAdminDomain addKhuyenMaiAdminDomain) throws ThtShoesException;

	void deleteKhuyenMai(String makm) throws ThtShoesException;
}
