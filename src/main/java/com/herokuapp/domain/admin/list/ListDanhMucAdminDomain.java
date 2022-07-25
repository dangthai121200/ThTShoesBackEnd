package com.herokuapp.domain.admin.list;

import java.util.ArrayList;
import java.util.List;

import com.herokuapp.domain.admin.DanhmucAdminDomain;

public class ListDanhMucAdminDomain {
	
	private List<DanhmucAdminDomain> danhmucs = new ArrayList<>();

	public ListDanhMucAdminDomain() {

	}

	public List<DanhmucAdminDomain> getDanhmucs() {
		return danhmucs;
	}

	public void setDanhmucs(List<DanhmucAdminDomain> danhmucs) {
		this.danhmucs = danhmucs;
	}

}
