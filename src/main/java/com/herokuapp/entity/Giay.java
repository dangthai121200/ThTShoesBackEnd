package com.herokuapp.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the giay database table.
 * 
 */
@Entity
@NamedQuery(name = "Giay.findAll", query = "SELECT g FROM Giay g")
@Table(name = "giay")
public class Giay implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(length = 10)
	private String magiay;

	@Column(nullable = false, length = 40)
	private String chatlieu;

	@Column(nullable = false)
	private int gia;

	@Column(nullable = false, length = 30)
	private String kieudang;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date ngaythem;

	private String mota;

	@Column(length = 50, nullable = false)
	private String tengiay;

	@Column(nullable = false)
	private int trongluong;

	private String urlanh;

	@Column(name = "ma_lgiay_hang")
	private int maLgiayHang;

	// bi-directional many-to-one association to Binhluan
	@OneToMany(mappedBy = "giay", fetch = FetchType.LAZY)
	private List<Binhluan> binhluans;

	// bi-directional many-to-one association to Hinh
	@OneToMany(mappedBy = "giay", fetch = FetchType.LAZY)
	private List<Hinh> hinhs;

	// bi-directional many-to-one association to GiayMauSize
	@OneToMany(mappedBy = "giay", fetch = FetchType.LAZY)
	private List<GiayMauSize> giayMauSizes;

	public Giay() {
		this.magiay = "";
		this.ngaythem = new Date();
	}

	public String getUrlanh() {
		return urlanh;
	}

	public void setUrlanh(String urlanh) {
		this.urlanh = urlanh;
	}

	public String getMagiay() {
		return this.magiay;
	}

	public void setMagiay(String magiay) {
		this.magiay = magiay;
	}

	public String getChatlieu() {
		return this.chatlieu;
	}

	public void setChatlieu(String chatlieu) {
		this.chatlieu = chatlieu;
	}

	public Date getNgaythem() {
		return ngaythem;
	}

	public void setNgaythem(Date ngaythem) {
		this.ngaythem = ngaythem;
	}

	public int getGia() {
		return this.gia;
	}

	public void setGia(int gia) {
		this.gia = gia;
	}

	public String getKieudang() {
		return this.kieudang;
	}

	public void setKieudang(String kieudang) {
		this.kieudang = kieudang;
	}

	public String getMota() {
		return this.mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public String getTengiay() {
		return this.tengiay;
	}

	public void setTengiay(String tengiay) {
		this.tengiay = tengiay;
	}

	public int getTrongluong() {
		return this.trongluong;
	}

	public void setTrongluong(int trongluong) {
		this.trongluong = trongluong;
	}

	public List<Binhluan> getBinhluans() {
		return this.binhluans;
	}

	public void setBinhluans(List<Binhluan> binhluans) {
		this.binhluans = binhluans;
	}

	public Binhluan addBinhluan(Binhluan binhluan) {
		getBinhluans().add(binhluan);
		binhluan.setGiay(this);

		return binhluan;
	}

	public Binhluan removeBinhluan(Binhluan binhluan) {
		getBinhluans().remove(binhluan);
		binhluan.setGiay(null);

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
		hinh.setGiay(this);

		return hinh;
	}

	public Hinh removeHinh(Hinh hinh) {
		getHinhs().remove(hinh);
		hinh.setGiay(null);

		return hinh;
	}

	public int getMaLgiayHang() {
		return maLgiayHang;
	}

	public void setMaLgiayHang(int maLgiayHang) {
		this.maLgiayHang = maLgiayHang;
	}

	public List<GiayMauSize> getGiayMauSizes() {
		return this.giayMauSizes;
	}

	public void setGiayMauSizes(List<GiayMauSize> giayMauSizes) {
		this.giayMauSizes = giayMauSizes;
	}

	public GiayMauSize addGiayMauSize(GiayMauSize giayMauSize) {
		getGiayMauSizes().add(giayMauSize);
		giayMauSize.setGiay(this);

		return giayMauSize;
	}

	public GiayMauSize removeGiayMauSize(GiayMauSize giayMauSize) {
		getGiayMauSizes().remove(giayMauSize);
		giayMauSize.setGiay(null);

		return giayMauSize;
	}

}