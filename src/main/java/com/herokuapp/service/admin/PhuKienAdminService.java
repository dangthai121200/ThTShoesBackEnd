package com.herokuapp.service.admin;

import com.herokuapp.domain.admin.AddPhuKienAdmin;
import com.herokuapp.domain.admin.PhuKienAdminDomain;
import com.herokuapp.domain.admin.list.ListPhuKienAdmin;
import com.herokuapp.handleexception.ThtShoesException;

public interface PhuKienAdminService {
	
	ListPhuKienAdmin getAllPhuKien();

	PhuKienAdminDomain getPhuKienById(String idPhuKien);

	String addPhuKien(AddPhuKienAdmin addPhuKienAdmin);

	void updatePhuKien(AddPhuKienAdmin addPhuKienAdmin) throws ThtShoesException;

	void deletePhuKien(String mapk) throws ThtShoesException;
}
