package com.herokuapp.domain.khachhang;

import java.util.ArrayList;
import java.util.List;

public class ListKhuyenMai {
	
	private List<KhuyenMaiDomain> khuyenMaiList = new ArrayList<>();

	public ListKhuyenMai() {

	}

	public List<KhuyenMaiDomain> getKhuyenMaiList() {
		return khuyenMaiList;
	}

	public void setKhuyenMaiList(List<KhuyenMaiDomain> khuyenMaiList) {
		this.khuyenMaiList = khuyenMaiList;
	}

}
