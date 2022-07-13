package com.herokuapp.service.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.herokuapp.domain.admin.PhuKienAdminDomain;
import com.herokuapp.domain.admin.list.ListPhuKienAdmin;
import com.herokuapp.entity.Phukien;
import com.herokuapp.reponsitory.PhuKienReponsitory;

@Service
public class PhuKienAdminServiceImpl implements PhuKienAdminService {

	@Autowired
	public PhuKienReponsitory phuKienReponsitory;

	@Override
	public ListPhuKienAdmin getAllPhuKien() {
		ListPhuKienAdmin listPhuKienAdmin = new ListPhuKienAdmin();
		List<PhuKienAdminDomain> phuKienAdminDomains = new ArrayList<>();
		List<Phukien> phukiens = phuKienReponsitory.findAll();
		phukiens.forEach(phukien -> {
			PhuKienAdminDomain phukienAdminDomain = new PhuKienAdminDomain();
			phukienAdminDomain.converToDomain(phukien);
			phuKienAdminDomains.add(phukienAdminDomain);

		});
		listPhuKienAdmin.setPhuKiens(phuKienAdminDomains);
		return listPhuKienAdmin;
	}

	@Override
	public PhuKienAdminDomain getPhuKienById(String idPhuKien) {
		PhuKienAdminDomain phuKienAdminDomain = new PhuKienAdminDomain();
		Phukien phukien = phuKienReponsitory.findById(idPhuKien).get();
		phuKienAdminDomain.converToDomain(phukien);
		return phuKienAdminDomain;
	}

}
