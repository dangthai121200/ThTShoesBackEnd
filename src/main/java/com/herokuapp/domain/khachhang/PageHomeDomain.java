package com.herokuapp.domain.khachhang;

import java.util.ArrayList;
import java.util.List;

public class PageHomeDomain {

	List<GiayDomain> giayLatest = new ArrayList<>();
	List<GiayDomain> giayBestSells = new ArrayList<>();
	List<PhuKienDomain> phuKienLatest = new ArrayList<>();

	public PageHomeDomain() {
	}

	public List<GiayDomain> getGiayLatest() {
		return giayLatest;
	}

	public void setGiayLatest(List<GiayDomain> giayLatest) {
		this.giayLatest = giayLatest;
	}

	public List<PhuKienDomain> getPhuKienLatest() {
		return phuKienLatest;
	}

	public void setPhuKienLatest(List<PhuKienDomain> phuKienLatest) {
		this.phuKienLatest = phuKienLatest;
	}

	public List<GiayDomain> getGiayBestSells() {
		return giayBestSells;
	}

	public void setGiayBestSells(List<GiayDomain> giayBestSells) {
		this.giayBestSells = giayBestSells;
	}

}
