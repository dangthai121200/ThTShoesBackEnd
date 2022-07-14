package com.herokuapp.domain.admin.list;

import java.util.ArrayList;
import java.util.List;

import com.herokuapp.domain.admin.KhuyenMaiAdminDomain;

public class ListKhuyenMaiAdmin {
	
	private List<KhuyenMaiAdminDomain> khuyenMais = new ArrayList<>();

	public ListKhuyenMaiAdmin() {
		super();
	}

	public List<KhuyenMaiAdminDomain> getKhuyenMais() {
		return khuyenMais;
	}

	public void setKhuyenMais(List<KhuyenMaiAdminDomain> khuyenMais) {
		this.khuyenMais = khuyenMais;
	}

}
