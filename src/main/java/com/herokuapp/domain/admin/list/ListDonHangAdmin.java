package com.herokuapp.domain.admin.list;

import java.util.ArrayList;
import java.util.List;

import com.herokuapp.domain.admin.DonHangAdminDomain;

public class ListDonHangAdmin {
	private List<DonHangAdminDomain> donHangs = new ArrayList<>();

	public List<DonHangAdminDomain> getDonHangs() {
		return donHangs;
	}

	public void setDonHangs(List<DonHangAdminDomain> donHangs) {
		this.donHangs = donHangs;
	}

}
