package com.herokuapp.service.admin;

import com.herokuapp.domain.admin.AddGiayAdminDomain;
import com.herokuapp.domain.admin.GiayAdminDomain;
import com.herokuapp.domain.admin.list.ListGiayAdmin;
import com.herokuapp.domain.khachhang.GiayDomain;

public interface GiayAdminService {
	ListGiayAdmin getAllGiay();

	String addGiay(AddGiayAdminDomain giayAdminDomain);

	GiayAdminDomain getGiayById(String idGiay);
}
