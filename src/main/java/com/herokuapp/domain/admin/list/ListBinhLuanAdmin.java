package com.herokuapp.domain.admin.list;

import java.util.ArrayList;
import java.util.List;

import com.herokuapp.domain.admin.BinhLuanAdminDomain;

public class ListBinhLuanAdmin {
	
	private List<BinhLuanAdminDomain> binhluans = new ArrayList<>();

	public ListBinhLuanAdmin() {
	}

	public List<BinhLuanAdminDomain> getBinhluans() {
		return binhluans;
	}

	public void setBinhluans(List<BinhLuanAdminDomain> binhluans) {
		this.binhluans = binhluans;
	}

}
