package com.herokuapp.service.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.herokuapp.domain.admin.HangAdminDomain;
import com.herokuapp.domain.admin.list.ListHangAdminDomain;
import com.herokuapp.entity.Hang;
import com.herokuapp.reponsitory.HangReponsitory;

@Service
public class HangAdminServiceImpl implements HangAdminService {

	@Autowired
	public HangReponsitory hangReponsitory;

	@Override
	public ListHangAdminDomain getAllHang() {
		ListHangAdminDomain listHangAdminDomain = new ListHangAdminDomain();
		List<HangAdminDomain> hangAdminDomains = new ArrayList<>();
		List<Hang> hangs = hangReponsitory.findAll();
		for (Hang hang : hangs) {
			HangAdminDomain hangAdminDomain = new HangAdminDomain();
			hangAdminDomain.converToDomain(hang);
			hangAdminDomains.add(hangAdminDomain);
		}
		listHangAdminDomain.setHangs(hangAdminDomains);
		return listHangAdminDomain;
	}

}
