package com.herokuapp.service.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.herokuapp.domain.admin.MauSacAdminDomain;
import com.herokuapp.domain.admin.list.ListMauSacAdmin;
import com.herokuapp.entity.Mausac;
import com.herokuapp.reponsitory.MauSacReponsitory;

@Service
public class MauSacAdminServiceimpl implements MauSacAdminService {

	@Autowired
	public MauSacReponsitory mauSacReponsitory;

	@Override
	public ListMauSacAdmin getAllMauSac() {
		ListMauSacAdmin listMauSacAdmin = new ListMauSacAdmin();
		List<MauSacAdminDomain> mauSacAdminDomains = new ArrayList<>();
		List<Mausac> mausacs = mauSacReponsitory.findAll();
		mausacs.forEach(mausac -> {
			MauSacAdminDomain mauSacAdminDomain = new MauSacAdminDomain();
			mauSacAdminDomain.converToDomain(mausac);
			mauSacAdminDomains.add(mauSacAdminDomain);
		});
		listMauSacAdmin.setMausacs(mauSacAdminDomains);
		return listMauSacAdmin;
	}

}
