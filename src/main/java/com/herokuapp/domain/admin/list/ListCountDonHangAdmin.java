package com.herokuapp.domain.admin.list;

import java.util.ArrayList;
import java.util.List;

import com.herokuapp.domain.admin.CountDonHangDomainAdmin;

public class ListCountDonHangAdmin {
	private List<CountDonHangDomainAdmin> list = new ArrayList<>();

	public ListCountDonHangAdmin() {
	}

	public List<CountDonHangDomainAdmin> getList() {
		return list;
	}

	public void setList(List<CountDonHangDomainAdmin> list) {
		this.list = list;
	}

}
