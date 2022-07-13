package com.herokuapp.service.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.herokuapp.domain.admin.LoaigiayHangDanhmucAdminDomain;
import com.herokuapp.domain.admin.list.ListLGiayHangDMucAdmin;
import com.herokuapp.entity.LoaigiayHangDanhmuc;
import com.herokuapp.reponsitory.LoaigiayHangDanhmucReponsitory;

@Service
public class LGiayHangDMucAdminServiceImpl implements LGiayHangDMucAdminService {

	@Autowired
	public LoaigiayHangDanhmucReponsitory loaigiayHangDanhmucReponsitory;

	@Override
	public ListLGiayHangDMucAdmin getAllLGiayHangDMuc() {
		ListLGiayHangDMucAdmin lGiayHangDMucAdminList = new ListLGiayHangDMucAdmin();
		List<LoaigiayHangDanhmucAdminDomain> loaigiayHangDanhmucAdmins = new ArrayList<>();
		List<LoaigiayHangDanhmuc> loaigiayHangDanhmucs = loaigiayHangDanhmucReponsitory.findAll();
		loaigiayHangDanhmucs.forEach(lgiayHangDMuc -> {
			LoaigiayHangDanhmucAdminDomain loaigiayHangDanhmucAdminDomain = new LoaigiayHangDanhmucAdminDomain();
			loaigiayHangDanhmucAdminDomain.converToDomain(lgiayHangDMuc);
			loaigiayHangDanhmucAdmins.add(loaigiayHangDanhmucAdminDomain);
		});
		lGiayHangDMucAdminList.setLoaigiayHangDanhmucAdmins(loaigiayHangDanhmucAdmins);
		return lGiayHangDMucAdminList;
	}

}
