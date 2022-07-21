package com.herokuapp.service.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.herokuapp.domain.admin.AddMauSac;
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

	@Override
	@Transactional(rollbackFor = Exception.class)
	public String addMauSac(AddMauSac addMauSac) {
		StringBuilder message = new StringBuilder();
		for (String tenMau : addMauSac.getMausacs()) {
			Mausac mausac = mauSacReponsitory.getMauSacByTenmau(tenMau);
			if (mausac == null) {
				mauSacReponsitory.insertMauSac(tenMau);
				message.append("Thêm thành công size " + tenMau + ", ");

			} else {
				message.append("màu " + tenMau + " tồn tại, ");
			}
		}
		return message.toString();
	}

}
