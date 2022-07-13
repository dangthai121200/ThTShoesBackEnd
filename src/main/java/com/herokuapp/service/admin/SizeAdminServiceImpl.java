package com.herokuapp.service.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.herokuapp.domain.admin.SizeAdminDomain;
import com.herokuapp.domain.admin.list.ListSizeAdmin;
import com.herokuapp.entity.Size;
import com.herokuapp.reponsitory.SizeReponsitory;

@Service
public class SizeAdminServiceImpl implements SizeAdminService {

	@Autowired
	public SizeReponsitory sizeReponsitory;

	@Override
	public ListSizeAdmin getAllSize() {
		ListSizeAdmin listSizeAdmin = new ListSizeAdmin();
		List<SizeAdminDomain> sizeAdminDomains = new ArrayList<>();
		List<Size> sizes = sizeReponsitory.findAll();
		sizes.forEach(size -> {
			SizeAdminDomain sizeAdminDomain = new SizeAdminDomain();
			sizeAdminDomain.converToDomain(size);
			sizeAdminDomains.add(sizeAdminDomain);
		});
		listSizeAdmin.setSizes(sizeAdminDomains);
		return listSizeAdmin;
	}

}
