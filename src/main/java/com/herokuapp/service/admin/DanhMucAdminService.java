package com.herokuapp.service.admin;

import com.herokuapp.domain.admin.DanhmucAdminDomain;
import com.herokuapp.domain.admin.list.ListDanhMucAdminDomain;
import com.herokuapp.handleexception.ThtShoesException;

public interface DanhMucAdminService {

	ListDanhMucAdminDomain getAllDanhMuc();

	void addDanhMuc(DanhmucAdminDomain danhmucAdminDomain) throws ThtShoesException;

}
