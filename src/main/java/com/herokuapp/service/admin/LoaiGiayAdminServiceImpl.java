package com.herokuapp.service.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.herokuapp.domain.admin.LoaiGiayAdminDomain;
import com.herokuapp.domain.admin.list.ListLoaiGiayAdmin;
import com.herokuapp.entity.Loaigiay;
import com.herokuapp.reponsitory.LoaiGiayReponsitory;

@Service
public class LoaiGiayAdminServiceImpl implements LoaiGiayAdminService {

	@Autowired
	public LoaiGiayReponsitory loaiGiayReponsitory;

	@Override
	public ListLoaiGiayAdmin getAllLoaiGiay() {
		ListLoaiGiayAdmin listLoaiGiayAdmin = new ListLoaiGiayAdmin();
		List<LoaiGiayAdminDomain> loaiGiayAdminDomains = new ArrayList<>();
		List<Loaigiay> loaigiays = loaiGiayReponsitory.findAll();
		loaigiays.forEach(loaigiay -> {
			LoaiGiayAdminDomain loaiGiayAdminDomain = new LoaiGiayAdminDomain();
			loaiGiayAdminDomain.converToDomain(loaigiay);
			loaiGiayAdminDomains.add(loaiGiayAdminDomain);
		});
		listLoaiGiayAdmin.setLoaiGiays(loaiGiayAdminDomains);
		return listLoaiGiayAdmin;
	}

}