package com.herokuapp.domain.admin.list;

import java.util.ArrayList;
import java.util.List;

import com.herokuapp.domain.admin.GiayAdminDomain;

public class ListGiayAdmin {

	private List<GiayAdminDomain> giays = new ArrayList<>();

	public ListGiayAdmin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ListGiayAdmin(List<GiayAdminDomain> giays) {
		super();
		this.giays = giays;
	}

	public List<GiayAdminDomain> getGiays() {
		return giays;
	}

	public void setGiays(List<GiayAdminDomain> giays) {
		this.giays = giays;
	}

}
