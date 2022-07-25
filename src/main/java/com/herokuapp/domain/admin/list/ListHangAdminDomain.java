package com.herokuapp.domain.admin.list;

import java.util.ArrayList;
import java.util.List;

import com.herokuapp.domain.admin.HangAdminDomain;

public class ListHangAdminDomain {
	private List<HangAdminDomain> hangs = new ArrayList<>();

	public ListHangAdminDomain() {

	}

	public List<HangAdminDomain> getHangs() {
		return hangs;
	}

	public void setHangs(List<HangAdminDomain> hangs) {
		this.hangs = hangs;
	}

}
