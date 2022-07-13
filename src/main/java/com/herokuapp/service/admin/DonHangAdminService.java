package com.herokuapp.service.admin;

import com.herokuapp.enums.TinhTrang;
import com.herokuapp.handleexception.ThtShoesException;

public interface DonHangAdminService {
	void updateStatusForDonhang(String madonghang, String manhanvien, TinhTrang tinhtrang) throws ThtShoesException;
}
