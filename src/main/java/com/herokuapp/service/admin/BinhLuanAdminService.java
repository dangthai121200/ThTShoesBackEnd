package com.herokuapp.service.admin;

import com.herokuapp.domain.admin.list.ListBinhLuanAdmin;

public interface BinhLuanAdminService {

	ListBinhLuanAdmin getAllBinhLuan();

	void deleteBinhLuan(String mabl);

}
