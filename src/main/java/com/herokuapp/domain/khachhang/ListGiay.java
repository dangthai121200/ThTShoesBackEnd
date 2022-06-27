package com.herokuapp.domain.khachhang;

import java.util.ArrayList;
import java.util.List;

public class ListGiay {

	private List<GiayDomain> giays = new ArrayList<>();

	public ListGiay() {
	}

	public List<GiayDomain> getGiays() {
		return giays;
	}

	public void setGiays(List<GiayDomain> giays) {
		this.giays = giays;
	}

	

}
