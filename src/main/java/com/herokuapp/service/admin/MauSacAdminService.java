package com.herokuapp.service.admin;

import com.herokuapp.domain.admin.AddMauSac;
import com.herokuapp.domain.admin.list.ListMauSacAdmin;

public interface MauSacAdminService {
	ListMauSacAdmin getAllMauSac();

	String addMauSac(AddMauSac addMauSac);
}
