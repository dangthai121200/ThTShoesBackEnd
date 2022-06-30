package com.herokuapp.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the binhluan database table.
 * 
 */
@Entity
@Table(name="binhluan")
@NamedQuery(name="Binhluan.findAll", query="SELECT b FROM Binhluan b")
public class Binhluan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, length=10)
	private String mabl;

	@Column(nullable=false, length=10)
	private String mota;

	@Temporal(TemporalType.TIMESTAMP)
	private Date thoigian;

	//bi-directional many-to-one association to Giay
	@ManyToOne
	@JoinColumn(name="magiay")
	private Giay giay;

	//bi-directional many-to-one association to Khachhang
	@ManyToOne
	@JoinColumn(name="makh", nullable=false)
	private Khachhang khachhang;

	//bi-directional many-to-one association to Phukien
	@ManyToOne
	@JoinColumn(name="mapk")
	private Phukien phukien;

	public Binhluan() {
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