package com.herokuapp.service.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.herokuapp.domain.admin.BinhLuanAdminDomain;
import com.herokuapp.domain.admin.list.ListBinhLuanAdmin;
import com.herokuapp.entity.Binhluan;
import com.herokuapp.reponsitory.BinhLuanReponsitory;

@Service
public class BinhLuanAdminServiceImpl implements BinhLuanAdminService {

	@Autowired
	public BinhLuanReponsitory binhLuanReponsitory;

	@Override
	public ListBinhLuanAdmin getAllBinhLuan() {
		ListBinhLuanAdmin listBinhLuanAdmin = new ListBinhLuanAdmin();
		List<BinhLuanAdminDomain> binhLuanAdminDomains = new ArrayList<>();
		List<Binhluan> binhluans = binhLuanReponsitory.findAll();
		for (Binhluan binhluan : binhluans) {
			BinhLuanAdminDomain binhLuanAdminDomain = new BinhLuanAdminDomain();
			binhLuanAdminDomain.converToDomain(binhluan);
			binhLuanAdminDomains.add(binhLuanAdminDomain);
		}
		listBinhLuanAdmin.setBinhluans(binhLuanAdminDomains);
		return listBinhLuanAdmin;
	}

	@Override
	public void deleteBinhLuan(String mabl) {
		binhLuanReponsitory.deleteById(mabl);
	}

}
