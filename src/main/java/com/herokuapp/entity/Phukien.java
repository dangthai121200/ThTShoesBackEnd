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
 * The persistent class for the phukien database table.
 * 
 */
@Entity
@Table(name="phukien")
@NamedQuery(name="Phukien.findAll", query="SELECT p FROM Phukien p")
public class Phukien implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, length=10)
	private String mapk;

	@Column(nullable=false)
	private int gia;

	@Lob
	private String mota;

	@Temporal(TemporalType.TIMESTAMP)
	private Date ngaythem;

	@Column(nullable=false)
	private int soluong;

	@Column(nullable=false, length=30)
	private String tenpk;

	@Lob
	private String urlanh;

	//bi-directional many-to-one association to Binhluan
	@OneToMany(mappedBy="phukien", fetch = FetchType.LAZY)
	private List<Binhluan> binhluans;

	//bi-directional many-to-one association to Hinh
	@OneToMany(mappedBy="phukien", fetch = FetchType.LAZY)
	private List<Hinh> hinhs;

	//bi-directional many-to-one association to Loaiphukien
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="maloaipk", nullable=false)
	private Loaiphukien loaiphukien;

	//bi-directional many-to-one association to PhukienDonhang
	@OneToMany(mappedBy="phukien", fetch = FetchType.LAZY)
	private List<PhukienDonhang> phukienDonhangs;

	public Phukien() {
	}

	public String getMapk() {
		return this.mapk;
	}

	public void setMapk(String mapk) {
		this.mapk = mapk;
	}

	public int getGia() {
		return this.gia;
	}

	public void setGia(int gia) {
		this.gia = gia;
	}

	public String getMota() {
		return this.mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public Date getNgaythem() {
		return this.ngaythem;
	}

	public void setNgaythem(Date ngaythem) {
		this.ngaythem = ngaythem;
	}

	public int getSoluong() {
		return this.soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public String getTenpk() {
		return this.tenpk;
	}

	public void setTenpk(String tenpk) {
		this.tenpk = tenpk;
	}

	public String getUrlAnh() {
		return this.urlanh;
	}

	public void setUrlAnh(String urlAnh) {
		this.urlanh = urlAnh;
	}

	public List<Binhluan> getBinhluans() {
		return this.binhluans;
	}

	public void setBinhluans(List<Binhluan> binhluans) {
		this.binhluans = binhluans;
	}

	public Binhluan addBinhluan(Binhluan binhluan) {
		getBinhluans().add(binhluan);
		binhluan.setPhukien(this);

		return binhluan;
	}

	public Binhluan removeBinhluan(Binhluan binhluan) {
		getBinhluans().remove(binhluan);
		binhluan.setPhukien(null);

		return binhluan;
	}

	public List<Hinh> getHinhs() {
		return this.hinhs;
	}

	public void setHinhs(List<Hinh> hinhs) {
		this.hinhs = hinhs;
	}

	public Hinh addHinh(Hinh hinh) {
		getHinhs().add(hinh);
		hinh.setPhukien(this);

		return hinh;
	}

	public Hinh removeHinh(Hinh hinh) {
		getHinhs().remove(hinh);
		hinh.setPhukien(null);

		return hinh;
	}

	public Loaiphukien getLoaiphukien() {
		return this.loaiphukien;
	}

	public void setLoaiphukien(Loaiphukien loaiphukien) {
		this.loaiphukien = loaiphukien;
	}

	public List<PhukienDonhang> getPhukienDonhangs() {
		return this.phukienDonhangs;
	}

	public void setPhukienDonhangs(List<PhukienDonhang> phukienDonhangs) {
		this.phukienDonhangs = phukienDonhangs;
	}

	public PhukienDonhang addPhukienDonhang(PhukienDonhang phukienDonhang) {
		getPhukienDonhangs().add(phukienDonhang);
		phukienDonhang.setPhukien(this);

		return phukienDonhang;
	}

	public PhukienDonhang removePhukienDonhang(PhukienDonhang phukienDonhang) {
		getPhukienDonhangs().remove(phukienDonhang);
		phukienDonhang.setPhukien(null);

		return phukienDonhang;
	}

}