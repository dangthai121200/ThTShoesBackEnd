package com.herokuapp.service.admin;

import com.herokuapp.domain.admin.HangAdminDomain;
import com.herokuapp.domain.admin.list.ListHangAdminDomain;
import com.herokuapp.handleexception.ThtShoesException;

public interface HangAdminService {

	ListHangAdminDomain getAllHang();

	void addHang(HangAdminDomain hangAdminDomain) throws ThtShoesException;

}
