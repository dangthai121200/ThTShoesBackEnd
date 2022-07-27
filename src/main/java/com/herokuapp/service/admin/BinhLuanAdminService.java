package com.herokuapp.service.admin;

import com.herokuapp.domain.admin.BinhLuanAdminDomain;
import com.herokuapp.domain.admin.TraLoiBinhLuanAdminDomain;
import com.herokuapp.domain.admin.list.ListBinhLuanAdmin;
import com.herokuapp.handleexception.ThtShoesException;

public interface BinhLuanAdminService {

	ListBinhLuanAdmin getAllBinhLuan();

	void deleteBinhLuan(String mabl);

	BinhLuanAdminDomain getBinhLuanbyId(String mabl);

	void traLoiBinhLuan(String manv, TraLoiBinhLuanAdminDomain traLoiBinhLuanAdminDomain) throws ThtShoesException;

}
