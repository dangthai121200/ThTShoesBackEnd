package com.herokuapp.service.admin;

import com.herokuapp.domain.admin.PhuKienAdminDomain;
import com.herokuapp.domain.admin.list.ListPhuKienAdmin;

public interface PhuKienAdminService {
	ListPhuKienAdmin getAllPhuKien();

	PhuKienAdminDomain getPhuKienById(String idPhuKien);
}
