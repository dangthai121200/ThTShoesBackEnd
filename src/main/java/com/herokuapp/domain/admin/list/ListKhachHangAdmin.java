package com.herokuapp.domain.admin.list;

import java.util.ArrayList;
import java.util.List;

import com.herokuapp.domain.admin.KhachHangAdminDomain;
import com.herokuapp.domain.admin.KhachVangLaiAdminDomain;

public class ListKhachHangAdmin {
	
	private List<KhachHangAdminDomain> khachHangs = new ArrayList<>();
	
	private List<KhachVangLaiAdminDomain> khachVanglais = new ArrayList<>();

	public List<KhachHangAdminDomain> getKhachHangs() {
		return khachHangs;
	}

	public void setKhachHangs(List<KhachHangAdminDomain> khachHangs) {
		this.khachHangs = khachHangs;
	}

	public List<KhachVangLaiAdminDomain> getKhachVanglais() {
		return khachVanglais;
	}

	public void setKhachVanglais(List<KhachVangLaiAdminDomain> khachVanglais) {
		this.khachVanglais = khachVanglais;
	}

}
