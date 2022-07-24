package com.herokuapp.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the hinh database table.
 * 
 */
@Entity
@Table(name = "hinh")
@NamedQuery(name = "Hinh.findAll", query = "SELECT h FROM Hinh h")
public class Hinh implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique = true, nullable = false, length = 10)
	private String mahinh;

	@Lob
	@Column(nullable = false)
	private String duongdan;

	// bi-directional many-to-one association to Giay
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "magiay", nullable = true)
	private Giay giay;

	// bi-directional many-to-one association to Phukien
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "mapk", nullable = true)
	private Phukien phukien;

	public Hinh() {
		this.mahinh = "";
	}
	
	public Hinh(String duongdan, Giay giay) {
		this.mahinh = "";
		this.duongdan = duongdan;
		this.giay = giay;
	}

	public String getMahinh() {
		return this.mahinh;
	}

	public void setMahinh(String mahinh) {
		this.mahinh = mahinh;
	}

	public String getDuongdan() {
		return this.duongdan;
	}

	public void setDuongdan(String duongdan) {
		this.duongdan = duongdan;
	}

	public Giay getGiay() {
		return this.giay;
	}

	public void setGiay(Giay giay) {
		this.giay = giay;
	}

	public Phukien getPhukien() {
		return this.phukien;
	}

	public void setPhukien(Phukien phukien) {
		this.phukien = phukien;
	}

}