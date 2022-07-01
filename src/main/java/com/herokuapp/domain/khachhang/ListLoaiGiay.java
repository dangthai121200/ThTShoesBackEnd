package com.herokuapp.domain.khachhang;

import java.util.ArrayList;
import java.util.List;

public class ListLoaiGiay {
	private List<LoaiGiayDomain> loaiGiays = new ArrayList<>();

	public ListLoaiGiay() {
	}

	public List<LoaiGiayDomain> getLoaiGiays() {
		return loaiGiays;
	}

	public void setLoaiGiays(List<LoaiGiayDomain> loaiGiays) {
		this.loaiGiays = loaiGiays;
	}

}
