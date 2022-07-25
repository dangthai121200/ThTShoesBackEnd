package com.herokuapp.service.admin;

import com.herokuapp.domain.admin.LoaiGiayAdminDomain;
import com.herokuapp.domain.admin.list.ListLoaiGiayAdmin;
import com.herokuapp.handleexception.ThtShoesException;

public interface LoaiGiayAdminService {
	ListLoaiGiayAdmin getAllLoaiGiay();

	void addLoaiGiay(LoaiGiayAdminDomain loaiGiayAdminDomain) throws ThtShoesException;
}
