package com.herokuapp.service.admin;

import com.herokuapp.domain.admin.GiayAdminDomain;
import com.herokuapp.domain.admin.list.ListGiayAdmin;
import com.herokuapp.domain.khachhang.GiayDomain;

public interface GiayAdminService {
	ListGiayAdmin getAllGiay();

	void addGiay(GiayAdminDomain giayAdminDomain);

	GiayAdminDomain getGiayById(String idGiay);
}
