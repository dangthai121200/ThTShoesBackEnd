package com.herokuapp.service.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.herokuapp.domain.admin.KhachHangAdminDomain;
import com.herokuapp.domain.admin.list.ListKhachHangAdmin;
import com.herokuapp.entity.Khachhang;
import com.herokuapp.reponsitory.KhachHangReponsitory;

@Service
public class KhachHangAdminServiceImpl implements KhachHangAdminService {

	@Autowired
	public KhachHangReponsitory khachHangReponsitory;

	@Override
	public ListKhachHangAdmin getAllKhachHang() {
		ListKhachHangAdmin listKhachHangAdmin = new ListKhachHangAdmin();
		List<KhachHangAdminDomain> khachHangAdminDomains = new ArrayList<>();
		List<Khachhang> khachhangs = khachHangReponsitory.findAll();
		for (Khachhang khachhang : khachhangs) {
			KhachHangAdminDomain khachHangAdminDomain = new KhachHangAdminDomain();
			khachHangAdminDomain.converToDomain(khachhang);
			khachHangAdminDomains.add(khachHangAdminDomain);
		}
		listKhachHangAdmin.setKhachHangs(khachHangAdminDomains);
		return listKhachHangAdmin;
	}

	@Override
	public KhachHangAdminDomain getKhachHangById(String makh) {
		Khachhang khachhang = khachHangReponsitory.findById(makh).get();
		KhachHangAdminDomain khachHangAdminDomain = new KhachHangAdminDomain();
		khachHangAdminDomain.converToDomain(khachhang);
		return khachHangAdminDomain;
	}

}
