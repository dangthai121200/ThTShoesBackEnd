package com.herokuapp.domain.khachhang;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.herokuapp.util.ThtShoesMess;

public class AddDonHangVangLai {

	@NotEmpty(message = ThtShoesMess.HO)
	@Length(max = 10, message = ThtShoesMess.MAX_LENGHT + "của họ là 10")
	private String ho;

	@NotEmpty(message = ThtShoesMess.TEN)
	@Length(max = 30, message = ThtShoesMess.MAX_LENGHT + "của tên là 30")
	private String ten;

	@NotEmpty(message = ThtShoesMess.SDT)
	@Length(max = 10, min = 10, message = ThtShoesMess.SDT_SAI)
	private String sdt;

	private String diachi;

	@Email(message = ThtShoesMess.EMAIL_SAI)
	@Length(max = 30, message = ThtShoesMess.MAX_LENGHT + "của email là 30")
	private String email;

	private String ghichu;

	private String makhuyenmai;

	@NotEmpty(message = ThtShoesMess.MA_LOAI_THANH_TOAN)
	@Length(max = 10, message = ThtShoesMess.MAX_LENGHT + "của maloaithanhtoan là 10")
	private String maloaithanhtoan;

	private Set<InfoGiayDonHang> giays = new HashSet<InfoGiayDonHang>();
	
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

	public Set<InfoGiayDonHang> getGiays() {
		return giays;
	}

	public void setGiays(Set<InfoGiayDonHang> giays) {
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
