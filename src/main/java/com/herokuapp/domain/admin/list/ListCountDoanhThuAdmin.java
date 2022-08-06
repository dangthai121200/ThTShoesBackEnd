package com.herokuapp.domain.admin.list;

import java.util.ArrayList;
import java.util.List;

import com.herokuapp.domain.admin.DoanhThuAdmin;

public class ListCountDoanhThuAdmin {
	
	private List<DoanhThuAdmin> list = new ArrayList<>();

	public ListCountDoanhThuAdmin() {

	}

	public List<DoanhThuAdmin> getList() {
		return list;
	}

	public void setList(List<DoanhThuAdmin> list) {
		this.list = list;
	}

}
