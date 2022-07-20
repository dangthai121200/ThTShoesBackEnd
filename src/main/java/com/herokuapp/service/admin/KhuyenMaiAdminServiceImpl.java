package com.herokuapp.service.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.herokuapp.domain.admin.KhuyenMaiAdminDomain;
import com.herokuapp.domain.admin.list.ListKhuyenMaiAdmin;
import com.herokuapp.entity.Dskhuyenmai;
import com.herokuapp.reponsitory.KhuyenMaiReponsitory;

@Service
public class KhuyenMaiAdminServiceImpl implements KhuyenMaiAdminService {

	@Autowired
	public KhuyenMaiReponsitory khuyenMaiReponsitory;

	@Override
	public ListKhuyenMaiAdmin getAllKhuyenMai() {
		ListKhuyenMaiAdmin listKhuyenMaiAdmin = new ListKhuyenMaiAdmin();
		List<KhuyenMaiAdminDomain> khuyenMais = new ArrayList<>();
		List<Dskhuyenmai> dskhuyenmais = khuyenMaiReponsitory.findAll();
		dskhuyenmais.forEach(khuyenmai -> {
			KhuyenMaiAdminDomain khuyenMaiAdminDomain = new KhuyenMaiAdminDomain();
			khuyenMaiAdminDomain.converToDomain(khuyenmai);
			khuyenMais.add(khuyenMaiAdminDomain);
		});
		listKhuyenMaiAdmin.setKhuyenMais(khuyenMais);
		return listKhuyenMaiAdmin;
	}

	@Override
	public KhuyenMaiAdminDomain getKhuyenMaiById(String makm) {
		KhuyenMaiAdminDomain khuyenMaiAdminDomain = new KhuyenMaiAdminDomain();
		Dskhuyenmai dskhuyenmai = khuyenMaiReponsitory.findById(makm).get();
		khuyenMaiAdminDomain.converToDomain(dskhuyenmai);
		return khuyenMaiAdminDomain;
	}

}
