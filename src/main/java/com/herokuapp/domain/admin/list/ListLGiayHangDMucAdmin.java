package com.herokuapp.domain.admin.list;

import java.util.ArrayList;
import java.util.List;

import com.herokuapp.domain.admin.LoaigiayHangDanhmucAdminDomain;

public class ListLGiayHangDMucAdmin {
	private List<LoaigiayHangDanhmucAdminDomain> loaigiayHangDanhmucAdmins = new ArrayList<>();

	public List<LoaigiayHangDanhmucAdminDomain> getLoaigiayHangDanhmucAdmins() {
		return loaigiayHangDanhmucAdmins;
	}

	public void setLoaigiayHangDanhmucAdmins(List<LoaigiayHangDanhmucAdminDomain> loaigiayHangDanhmucAdmins) {
		this.loaigiayHangDanhmucAdmins = loaigiayHangDanhmucAdmins;
	}
	
	
}
