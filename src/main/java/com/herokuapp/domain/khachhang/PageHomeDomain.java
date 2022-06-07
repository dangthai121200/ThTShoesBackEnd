package com.herokuapp.domain.khachhang;

import java.util.ArrayList;
import java.util.List;

public class PageHomeDomain {
	
	List<GiayDomain> giayDomains = new ArrayList<>();
	List<PhuKienDomain> phuKienDomains = new ArrayList<>();

	public PageHomeDomain() {
	}

	public PageHomeDomain(List<GiayDomain> giayDomains, List<PhuKienDomain> phuKienDomains) {
		this.giayDomains = giayDomains;
		this.phuKienDomains = phuKienDomains;
	}

	public List<GiayDomain> getGiayDomains() {
		return giayDomains;
	}

	public void setGiayDomains(List<GiayDomain> giayDomains) {
		this.giayDomains = giayDomains;
	}

	public List<PhuKienDomain> getPhuKienDomains() {
		return phuKienDomains;
	}

	public void setPhuKienDomains(List<PhuKienDomain> phuKienDomains) {
		this.phuKienDomains = phuKienDomains;
	}

}
