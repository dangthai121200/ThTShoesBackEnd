package com.herokuapp.domain.khachhang;

import java.util.HashMap;
import java.util.Map;

public class AddDonHang {

	private String nguoinhan;
	private String maKhuyenMai;
	private String maKhachHang;
	private Map<String, Integer> giays = new HashMap<String, Integer>();
	private Map<String, Integer> phukiens = new HashMap<String, Integer>();

	public String getNguoinhan() {
		return nguoinhan;
	}

	public void setNguoinhan(String nguoinhan) {
		this.nguoinhan = nguoinhan;
	}

	public String getMaKhuyenMai() {
		return maKhuyenMai;
	}

	public void setMaKhuyenMai(String maKhuyenMai) {
		this.maKhuyenMai = maKhuyenMai;
	}

	public String getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public Map<String, Integer> getGiays() {
		return giays;
	}

	public void setGiays(Map<String, Integer> giays) {
		this.giays = giays;
	}

	public Map<String, Integer> getPhukiens() {
		return phukiens;
	}

	public void setPhukiens(Map<String, Integer> phukiens) {
		this.phukiens = phukiens;
	}

}
