package com.herokuapp.domain.khachhang;

import java.util.ArrayList;
import java.util.List;

public class PageHomeDomain {

	List<GiayDomainGeneral> giayLatest = new ArrayList<>();
	List<GiayDomainGeneral> giayBestSells = new ArrayList<>();
	List<PhuKienDomain> phuKienLatest = new ArrayList<>();

	public PageHomeDomain() {
	}

	public List<GiayDomainGeneral> getGiayLatest() {
		return giayLatest;
	}

	public void setGiayLatest(List<GiayDomainGeneral> giayLatest) {
		this.giayLatest = giayLatest;
	}

	public List<PhuKienDomain> getPhuKienLatest() {
		return phuKienLatest;
	}

	public void setPhuKienLatest(List<PhuKienDomain> phuKienLatest) {
		this.phuKienLatest = phuKienLatest;
	}

	public List<GiayDomainGeneral> getGiayBestSells() {
		return giayBestSells;
	}

	public void setGiayBestSells(List<GiayDomainGeneral> giayBestSells) {
		this.giayBestSells = giayBestSells;
	}

}
