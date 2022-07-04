package com.herokuapp.domain.khachhang;

import java.util.HashMap;
import java.util.Map;

public class AddDonHang {

	private String nguoinhan;
	private String diachi;
	private String ghichu;
	private String maloaithanhtoan;
	private String maKhuyenMai;
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

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getGhichu() {
		return ghichu;
	}

	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
	}

	public String getMaloaithanhtoan() {
		return maloaithanhtoan;
	}

	public void setMaloaithanhtoan(String maloaithanhtoan) {
		this.maloaithanhtoan = maloaithanhtoan;
	}

}
