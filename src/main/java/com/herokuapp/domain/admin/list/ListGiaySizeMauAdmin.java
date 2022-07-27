package com.herokuapp.domain.admin.list;

import java.util.ArrayList;
import java.util.List;

import com.herokuapp.domain.admin.GiaySizeMauAdminDomain;

public class ListGiaySizeMauAdmin {
	private List<GiaySizeMauAdminDomain> giaySizeMau = new ArrayList<>();

	public List<GiaySizeMauAdminDomain> getGiaySizeMau() {
		return giaySizeMau;
	}

	public void setGiaySizeMau(List<GiaySizeMauAdminDomain> giaySizeMau) {
		this.giaySizeMau = giaySizeMau;
	}
	
	
}
