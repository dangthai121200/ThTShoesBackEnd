package com.herokuapp.domain.khachhang.list;

import java.util.ArrayList;
import java.util.List;

import com.herokuapp.domain.khachhang.DonHangDomain;

public class ListDonHang {

	private List<DonHangDomain> donHangs = new ArrayList<>();

	public ListDonHang() {
		if (donHangs == null) {
			donHangs = new ArrayList<>();
		}
	}

	public List<DonHangDomain> getDonHangs() {
		return donHangs;
	}

	public void setDonHangs(List<DonHangDomain> donHangs) {
		this.donHangs = donHangs;
	}

	public void addDonHangDomain(DonHangDomain donHangDomain) {
		donHangs.add(donHangDomain);
	}

}
