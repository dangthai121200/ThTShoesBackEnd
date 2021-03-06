package com.herokuapp.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the khachvanglai database table.
 * 
 */
@Entity
@Table(name = "khachvanglai")
@NamedQuery(name = "Khachvanglai.findAll", query = "SELECT k FROM Khachvanglai k")
public class Khachvanglai implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique = true, length = 10)
	private String makh; // this is id default if no has khachangvanglai for dathang

	@Lob
	@Column(nullable = false)
	private String diachi;

	@Column(length = 30)
	private String email;

	@Lob
	private String ghichu;

	@Column(nullable = false, length = 10)
	private String ho;

	@Column(nullable = false, length = 11)
	private String sdt;

	@Column(nullable = false, length = 30)
	private String ten;

	// bi-directional many-to-one association to Donhang
	@OneToMany(mappedBy = "khachvanglai", fetch = FetchType.LAZY)
	private List<Donhang> donhangs;

	public Khachvanglai() {
		this.makh = "";
	}

	public String getMakh() {
		return this.makh;
	}

	public void setMakh(String makh) {
		this.makh = makh;
	}

	public String getDiachi() {
		return this.diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGhichu() {
		return this.ghichu;
	}

	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
	}

	public String getHo() {
		return this.ho;
	}

	public void setHo(String ho) {
		this.ho = ho;
	}

	public String getSdt() {
		return this.sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getTen() {
		return this.ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public List<Donhang> getDonhangs() {
		return this.donhangs;
	}

	public void setDonhangs(List<Donhang> donhangs) {
		this.donhangs = donhangs;
	}

	public Donhang addDonhang(Donhang donhang) {
		getDonhangs().add(donhang);
		donhang.setKhachvanglai(this);

		return donhang;
	}

	public Donhang removeDonhang(Donhang donhang) {
		getDonhangs().remove(donhang);
		donhang.setKhachvanglai(null);

		return donhang;
	}

}