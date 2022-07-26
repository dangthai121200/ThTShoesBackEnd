package com.herokuapp.domain.admin.list;

import java.util.ArrayList;
import java.util.List;

import com.herokuapp.domain.admin.LoaiPhuKienAdminDomain;

public class ListLoaiPhuKienAdmin {
	private List<LoaiPhuKienAdminDomain> loaiphukiens = new ArrayList<>();

	public ListLoaiPhuKienAdmin() {

	}

	public List<LoaiPhuKienAdminDomain> getLoaiphukiens() {
		return loaiphukiens;
	}

	public void setLoaiphukiens(List<LoaiPhuKienAdminDomain> loaiphukiens) {
		this.loaiphukiens = loaiphukiens;
	}

}
