package com.herokuapp.domain.admin.list;

import java.util.ArrayList;
import java.util.List;

import com.herokuapp.domain.admin.PhuKienAdminDomain;

public class ListPhuKienAdmin {
	
	private List<PhuKienAdminDomain> phuKiens = new ArrayList<>();

	public ListPhuKienAdmin() {

	}

	public List<PhuKienAdminDomain> getPhuKiens() {
		return phuKiens;
	}

	public void setPhuKiens(List<PhuKienAdminDomain> phuKiens) {
		this.phuKiens = phuKiens;
	}

}
