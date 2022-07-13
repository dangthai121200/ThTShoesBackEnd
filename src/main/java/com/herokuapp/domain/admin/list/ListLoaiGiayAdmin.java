package com.herokuapp.domain.admin.list;

import java.util.ArrayList;
import java.util.List;

import com.herokuapp.domain.admin.LoaiGiayAdminDomain;

public class ListLoaiGiayAdmin {
	private List<LoaiGiayAdminDomain> loaiGiays = new ArrayList<>();

	public List<LoaiGiayAdminDomain> getLoaiGiays() {
		return loaiGiays;
	}

	public void setLoaiGiays(List<LoaiGiayAdminDomain> loaiGiays) {
		this.loaiGiays = loaiGiays;
	}

}
