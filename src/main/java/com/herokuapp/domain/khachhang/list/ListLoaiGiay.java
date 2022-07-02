package com.herokuapp.domain.khachhang.list;

import java.util.ArrayList;
import java.util.List;

import com.herokuapp.domain.khachhang.LoaiGiayDomain;

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
