package com.herokuapp.service.admin;

import javax.validation.Valid;

import com.herokuapp.domain.admin.LoaiPhuKienAdminDomain;
import com.herokuapp.domain.admin.list.ListLoaiPhuKienAdmin;
import com.herokuapp.domain.khachhang.list.ListLoaiPhuKien;

public interface LoaiPhuKienAdminService {

	ListLoaiPhuKienAdmin getAllLoaiPhuKien();

	void addLoaiPhuKien(@Valid LoaiPhuKienAdminDomain loaiPhuKienAdminDomain);

}
