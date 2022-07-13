package com.herokuapp.domain.admin.list;

import java.util.ArrayList;
import java.util.List;

import com.herokuapp.domain.admin.MauSacAdminDomain;

public class ListMauSacAdmin {
	private List<MauSacAdminDomain> mausacs = new ArrayList<>();

	public List<MauSacAdminDomain> getMausacs() {
		return mausacs;
	}

	public void setMausacs(List<MauSacAdminDomain> mausacs) {
		this.mausacs = mausacs;
	}

}
