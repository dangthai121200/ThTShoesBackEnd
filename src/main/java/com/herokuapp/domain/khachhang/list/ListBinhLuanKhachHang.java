package com.herokuapp.domain.khachhang.list;

import java.util.ArrayList;
import java.util.List;

import com.herokuapp.domain.khachhang.BinhLuanKhachHangDomain;

public class ListBinhLuanKhachHang {
	private List<BinhLuanKhachHangDomain> binhluans = new ArrayList<>();

	public ListBinhLuanKhachHang() {
	}

	public List<BinhLuanKhachHangDomain> getBinhluans() {
		return binhluans;
	}

	public void setBinhluans(List<BinhLuanKhachHangDomain> binhluans) {
		this.binhluans = binhluans;
	}

}
