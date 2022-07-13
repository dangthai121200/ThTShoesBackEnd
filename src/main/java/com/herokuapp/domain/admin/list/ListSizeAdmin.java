package com.herokuapp.domain.admin.list;

import java.util.ArrayList;
import java.util.List;

import com.herokuapp.domain.admin.SizeAdminDomain;

public class ListSizeAdmin {
	private List<SizeAdminDomain> sizes = new ArrayList<>();

	public List<SizeAdminDomain> getSizes() {
		return sizes;
	}

	public void setSizes(List<SizeAdminDomain> sizes) {
		this.sizes = sizes;
	}

}
