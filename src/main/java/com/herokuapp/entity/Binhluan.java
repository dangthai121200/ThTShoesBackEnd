package com.herokuapp.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the binhluan database table.
 * 
 */
@Entity
@NamedQuery(name="Binhluan.findAll", query="SELECT b FROM Binhluan b")
public class Binhluan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String mabl;

	@Lob
	private String mota;

	@Temporal(TemporalType.TIMESTAMP)
	private Date thoigian;

	//bi-directional many-to-one association to Giay
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="magiay")
	private Giay giay;

	//bi-directional many-to-one association to Khachhang
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="makh")
	private Khachhang khachhang;

	//bi-directional many-to-one association to Phukien
	@ManyToOne(fetch=FetchType.LAZY)
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