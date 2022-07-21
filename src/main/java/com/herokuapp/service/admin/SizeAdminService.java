package com.herokuapp.service.admin;

import com.herokuapp.domain.admin.AddSizeAdmin;
import com.herokuapp.domain.admin.SizeAdminDomain;
import com.herokuapp.domain.admin.list.ListSizeAdmin;

public interface SizeAdminService {

	ListSizeAdmin getAllSize();

	StringBuilder addSize(AddSizeAdmin addSizeAdmin);
	
}
