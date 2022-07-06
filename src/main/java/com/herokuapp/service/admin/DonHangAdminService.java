package com.herokuapp.service.admin;

import com.herokuapp.enums.TinhTrang;

public interface DonHangAdminService {
	void updateStatusForDonhang(String madonghang, TinhTrang tinhtrang);
}
