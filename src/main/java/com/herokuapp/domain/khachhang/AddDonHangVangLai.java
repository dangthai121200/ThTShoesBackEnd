package com.herokuapp.domain.khachhang;

import java.util.HashMap;
import java.util.Map;

public class AddDonHangVangLai {
	private String ho;
	private String ten;
	private String sdt;
	private String diachi;
	private String email;
	private String ghichu;
	private String makhuyenmai;
	private String maloaithanhtoan;
	private Map<String, Integer> giays = new HashMap<String, Integer>();
	private Map<String, Integer> phukiens = new HashMap<String, Integer>();

	public AddDonHangVangLai() {
	}

	public String getHo() {
		return ho;
	}

	public void setHo(String ho) {
		this.ho = ho;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGhichu() {
		return ghichu;
	}

	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
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

	public String getMakhuyenmai() {
		return makhuyenmai;
	}

	public void setMakhuyenmai(String makhuyenmai) {
		this.makhuyenmai = makhuyenmai;
	}

	public String getMaloaithanhtoan() {
		return maloaithanhtoan;
	}

	public void setMaloaithanhtoan(String maloaithanhtoan) {
		this.maloaithanhtoan = maloaithanhtoan;
	}

}
