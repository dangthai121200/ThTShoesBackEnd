package com.herokuapp.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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

	// bi-directional many-to-one association to Binhluan
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ma_bl_traloi")
	private Binhluan binhluan;

	// bi-directional many-to-one association to Binhluan
	@OneToMany(mappedBy = "binhluan")
	private List<Binhluan> binhluans;

	// bi-directional many-to-one association to Giay
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "magiay")
	private Giay giay;

	// bi-directional many-to-one association to Khachhang
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "makh")
	private Khachhang khachhang;

	// bi-directional many-to-one association to Nhanvien
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "manv")
	private Nhanvien nhanvien;

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

	public Binhluan getBinhluan() {
		return binhluan;
	}

	public void setBinhluan(Binhluan binhluan) {
		this.binhluan = binhluan;
	}

	public List<Binhluan> getBinhluans() {
		return binhluans;
	}

	public void setBinhluans(List<Binhluan> binhluans) {
		this.binhluans = binhluans;
	}
	
	public Binhluan addBinhluan(Binhluan binhluan) {
		getBinhluans().add(binhluan);
		binhluan.setBinhluan(this);

		return binhluan;
	}

	public Binhluan removeBinhluan(Binhluan binhluan) {
		getBinhluans().remove(binhluan);
		binhluan.setBinhluan(null);

		return binhluan;
	}

	public Nhanvien getNhanvien() {
		return nhanvien;
	}

	public void setNhanvien(Nhanvien nhanvien) {
		this.nhanvien = nhanvien;
	}

}