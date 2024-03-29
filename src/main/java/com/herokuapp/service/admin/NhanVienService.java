package com.herokuapp.service.admin;

import com.herokuapp.domain.admin.InfoNhanvienDangKy;
import com.herokuapp.domain.admin.NhanVienAdminDomain;
import com.herokuapp.domain.admin.list.ListNhanVienAdmin;
import com.herokuapp.handleexception.ThtShoesException;

public interface NhanVienService {
	void addNhanVien(InfoNhanvienDangKy infoNhanvienDangKy);

	NhanVienAdminDomain getInfoNhanVien(String idMaNhanvien);

	ListNhanVienAdmin getAllNhanVien();

	NhanVienAdminDomain getNhanVienyId(String mavn);
	
	boolean checkSdt(Long sdt);

	void lockNhanVien(String manv) throws ThtShoesException;
	void unLockNhanVien(String manv);
}
