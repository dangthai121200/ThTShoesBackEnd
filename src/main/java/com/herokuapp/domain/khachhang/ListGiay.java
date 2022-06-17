package com.herokuapp.domain.khachhang;

import java.util.ArrayList;
import java.util.List;

public class ListGiay {

	private List<GiayDomainGeneral> giays = new ArrayList<>();

	public ListGiay() {
	}

	public List<GiayDomainGeneral> getGiays() {
		return giays;
	}

	public void setGiays(List<GiayDomainGeneral> giays) {
		this.giays = giays;
	}

	

}
