package com.herokuapp.service.admin;

import com.herokuapp.domain.admin.DonHangAdminDomain;
import com.herokuapp.domain.admin.list.ListDonHangAdmin;
import com.herokuapp.enums.TinhTrang;
import com.herokuapp.handleexception.ThtShoesException;

public interface DonHangAdminService {
	void updateStatusForDonhang(String madonghang, String manhanvien, TinhTrang tinhtrang) throws ThtShoesException;
	ListDonHangAdmin getAllDonHang();
	DonHangAdminDomain getDonHangById(String idDonhang) throws Exception;
}
