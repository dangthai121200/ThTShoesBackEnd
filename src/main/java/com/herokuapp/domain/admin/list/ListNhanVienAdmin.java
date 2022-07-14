package com.herokuapp.domain.admin.list;

import java.util.ArrayList;
import java.util.List;

import com.herokuapp.domain.admin.NhanVienAdminDomain;

public class ListNhanVienAdmin {

	private List<NhanVienAdminDomain> nhanviens = new ArrayList<>();

	public ListNhanVienAdmin() {

	}

	public List<NhanVienAdminDomain> getNhanviens() {
		return nhanviens;
	}

	public void setNhanviens(List<NhanVienAdminDomain> nhanviens) {
		this.nhanviens = nhanviens;
	}

}
