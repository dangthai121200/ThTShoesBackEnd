package com.herokuapp.domain.admin.list;

import java.util.ArrayList;
import java.util.List;

import com.herokuapp.domain.admin.SoLuongGiayAdminDomain;

public class ListSoLuongGiayAdmin {
	private List<SoLuongGiayAdminDomain> soluonggiays = new ArrayList<>();

	public ListSoLuongGiayAdmin() {

	}

	public List<SoLuongGiayAdminDomain> getSoluonggiays() {
		return soluonggiays;
	}

	public void setSoluonggiays(List<SoLuongGiayAdminDomain> soluonggiays) {
		this.soluonggiays = soluonggiays;
	}

}
