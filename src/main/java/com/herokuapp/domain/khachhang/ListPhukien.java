package com.herokuapp.domain.khachhang;

import java.util.ArrayList;
import java.util.List;

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
