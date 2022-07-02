package com.herokuapp.domain.khachhang.list;

import java.util.ArrayList;
import java.util.List;

import com.herokuapp.domain.khachhang.GiayDomain;

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
