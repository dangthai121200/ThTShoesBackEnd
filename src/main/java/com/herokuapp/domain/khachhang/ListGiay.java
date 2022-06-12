package com.herokuapp.domain.khachhang;

import java.util.ArrayList;
import java.util.List;

public class ListGiay {

	private List<GiayDomainGeneral> giayDomains = new ArrayList<>();

	public ListGiay() {
	}

	public List<GiayDomainGeneral> getGiayDomains() {
		return giayDomains;
	}

	public void setGiayDomains(List<GiayDomainGeneral> giayDomains) {
		this.giayDomains = giayDomains;
	}

}
