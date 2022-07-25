package com.herokuapp.service.admin;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.herokuapp.domain.admin.DanhmucAdminDomain;
import com.herokuapp.domain.admin.list.ListDanhMucAdminDomain;
import com.herokuapp.entity.Danhmuc;
import com.herokuapp.handleexception.ThtShoesException;
import com.herokuapp.reponsitory.DanhMucReponsitory;

@Service
public class DanhMucAdminServiceImpl implements DanhMucAdminService {

	@Autowired
	public DanhMucReponsitory danhMucReponsitory;

	@Override
	public ListDanhMucAdminDomain getAllDanhMuc() {
		ListDanhMucAdminDomain listDanhMucAdminDomain = new ListDanhMucAdminDomain();
		List<DanhmucAdminDomain> danhmucAdminDomains = new ArrayList<>();
		List<Danhmuc> danhmucs = danhMucReponsitory.findAll();
		for (Danhmuc danhmuc : danhmucs) {
			DanhmucAdminDomain danhmucAdminDomain = new DanhmucAdminDomain();
			danhmucAdminDomain.converToDomain(danhmuc);
			danhmucAdminDomains.add(danhmucAdminDomain);
		}
		listDanhMucAdminDomain.setDanhmucs(danhmucAdminDomains);
		return listDanhMucAdminDomain;
	}

	@Override
	public void addDanhMuc(DanhmucAdminDomain danhmucAdminDomain) throws ThtShoesException {
		String tendanhmuc = StringUtils.capitalize(danhmucAdminDomain.getTendanhmuc());
		Danhmuc danhmuc = danhMucReponsitory.getDanhMucByTen(tendanhmuc);
		if (danhmuc != null) {
			throw new ThtShoesException("Tên danh mục đã tồn tại");
		} else {
			Danhmuc danhmucAdd = new Danhmuc();
			danhmucAdd.setTendanhmuc(tendanhmuc);
			danhMucReponsitory.save(danhmucAdd);
		}
	}

}
