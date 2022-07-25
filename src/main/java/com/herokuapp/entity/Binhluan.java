package com.herokuapp.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the binhluan database table.
 * 
 */
@Entity
@Table(name = "binhluan")
@NamedQuery(name = "Binhluan.findAll", query = "SELECT b FROM Binhluan b")
public class Binhluan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(length = 10)
	private String mabl;

	@Lob
	@Column(nullable = false)
	private String mota;

	@Temporal(TemporalType.TIMESTAMP)
	private Date thoigian;

	// bi-directional many-to-one association to Giay
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "magiay")
	private Giay giay;

	// bi-directional many-to-one association to Khachhang
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "makh", nullable = false)
	private Khachhang khachhang;

	// bi-directional many-to-one association to Phukien
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "mapk")
	private Phukien phukien;

	public Binhluan() {
		this.mabl = "";
		this.thoigian = new Date();
	}

	public String getMabl() {
		return this.mabl;
	}

	public void setMabl(String mabl) {
		this.mabl = mabl;
	}

	public String getMota() {
		return this.mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public Date getThoigian() {
		return this.thoigian;
	}

	public void setThoigian(Date thoigian) {
		this.thoigian = thoigian;
	}

	public Giay getGiay() {
		return this.giay;
	}

	public void setGiay(Giay giay) {
		this.giay = giay;
	}

	public Khachhang getKhachhang() {
		return this.khachhang;
	}

	public void setKhachhang(Khachhang khachhang) {
		this.khachhang = khachhang;
	}

	public Phukien getPhukien() {
		return this.phukien;
	}

	public void setPhukien(Phukien phukien) {
		this.phukien = phukien;
	}

}