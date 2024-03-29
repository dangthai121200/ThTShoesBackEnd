package com.herokuapp.service.admin;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.herokuapp.domain.admin.LoaiPhuKienAdminDomain;
import com.herokuapp.domain.admin.list.ListLoaiPhuKienAdmin;
import com.herokuapp.entity.Loaiphukien;
import com.herokuapp.reponsitory.LoaiPhuKienReponsitory;

@Service
public class LoaiPhuKienAdminServiceImpl implements LoaiPhuKienAdminService {

	@Autowired
	public LoaiPhuKienReponsitory loaiPhuKienReponsitory;

	@Override
	public ListLoaiPhuKienAdmin getAllLoaiPhuKien() {
		ListLoaiPhuKienAdmin listLoaiPhuKien = new ListLoaiPhuKienAdmin();
		List<LoaiPhuKienAdminDomain> loaiPhuKienDomains = new ArrayList<>();
		List<Loaiphukien> loaiphukiens = loaiPhuKienReponsitory.findAll();
		for (Loaiphukien loaiphukien : loaiphukiens) {
			LoaiPhuKienAdminDomain loaiPhuKienAdminDomain = new LoaiPhuKienAdminDomain();
			loaiPhuKienAdminDomain.converToDomain(loaiphukien);
			loaiPhuKienDomains.add(loaiPhuKienAdminDomain);
		}
		listLoaiPhuKien.setLoaiphukiens(loaiPhuKienDomains);
		return listLoaiPhuKien;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void addLoaiPhuKien(@Valid LoaiPhuKienAdminDomain loaiPhuKienAdminDomain) {
		Loaiphukien loaiphukien = new Loaiphukien();
		loaiphukien.setTenloai(loaiPhuKienAdminDomain.getTenLoaiPhuKien());
		loaiPhuKienReponsitory.save(loaiphukien);
	}

}
