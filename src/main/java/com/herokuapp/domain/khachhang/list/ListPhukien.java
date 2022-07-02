package com.herokuapp.domain.khachhang.list;

import java.util.ArrayList;
import java.util.List;

import com.herokuapp.domain.khachhang.PhuKienDomain;

public class ListPhukien {
	private List<PhuKienDomain> phukiens = new ArrayList<>();

	public ListPhukien() {

	}

	public List<PhuKienDomain> getPhukiens() {
		return phukiens;
	}

	public void setPhukiens(List<PhuKienDomain> phukiens) {
		this.phukiens = phukiens;
	}

}
