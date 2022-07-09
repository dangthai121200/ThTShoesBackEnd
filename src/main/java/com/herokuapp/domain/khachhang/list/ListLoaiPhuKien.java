package com.herokuapp.domain.khachhang.list;

import java.util.ArrayList;
import java.util.List;

import com.herokuapp.domain.khachhang.LoaiPhuKienDomain;

public class ListLoaiPhuKien {
	private List<LoaiPhuKienDomain> loaiPhuKiens = new ArrayList<>();

	public ListLoaiPhuKien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<LoaiPhuKienDomain> getLoaiPhuKiens() {
		return loaiPhuKiens;
	}

	public void setLoaiPhuKiens(List<LoaiPhuKienDomain> loaiPhuKiens) {
		this.loaiPhuKiens = loaiPhuKiens;
	}

}
