package com.herokuapp.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the phuongthucthanhtoan database table.
 * 
 */
@Entity
@Table(name = "phuongthucthanhtoan")
@NamedQuery(name = "Phuongthucthanhtoan.findAll", query = "SELECT p FROM Phuongthucthanhtoan p")
public class Phuongthucthanhtoan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique = true, nullable = false, length = 10)
	private String maloaithanhtoan;

	@Column(nullable = false, length = 45, unique = true)
	private String loaiphuongthuc;

	@OneToMany(mappedBy = "phuongthucthanhtoan")
	private List<Donhang> donhangs;

	public Phuongthucthanhtoan() {
	}

	public String getMaloaithanhtoan() {
		return this.maloaithanhtoan;
	}

	public void setMaloaithanhtoan(String maloaithanhtoan) {
		this.maloaithanhtoan = maloaithanhtoan;
	}

	public String getLoaiphuongthuc() {
		return this.loaiphuongthuc;
	}

	public void setLoaiphuongthuc(String loaiphuongthuc) {
		this.loaiphuongthuc = loaiphuongthuc;
	}

	public List<Donhang> getDonhangs() {
		return donhangs;
	}

	public void setDonhangs(List<Donhang> donhangs) {
		this.donhangs = donhangs;
	}

}