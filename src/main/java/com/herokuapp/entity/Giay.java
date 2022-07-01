package com.herokuapp.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
	private String magiay;

	private String chatlieu;

	private int gia;

	private String kieudang;

	private String ngaythem;

	private String mota;

	private String tengiay;

	private int trongluong;

	private String urlanh;

	private int soluong;

	@Column(name = "ma_lgiay_hang")
	private int maLgiayHang;

	// bi-directional many-to-one association to Binhluan
	@OneToMany(mappedBy = "giay", fetch = FetchType.LAZY)
	private List<Binhluan> binhluans;

	// bi-directional many-to-many association to Size
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "giay_size", joinColumns = { @JoinColumn(name = "magiay") }, inverseJoinColumns = {
			@JoinColumn(name = "masize") })
	private List<Size> sizes;

	// bi-directional many-to-one association to GiayDonhang
	@OneToMany(mappedBy = "giay", fetch = FetchType.LAZY)
	private List<GiayDonhang> giayDonhangs;

	// bi-directional many-to-one association to Hinh
	@OneToMany(mappedBy = "giay", fetch = FetchType.LAZY)
	private List<Hinh> hinhs;

	// bi-directional many-to-many association to Mausac
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "giay_mau", joinColumns = { @JoinColumn(name = "magiay") }, inverseJoinColumns = {
			@JoinColumn(name = "mamau") })
	private List<Mausac> mausacs;

	public Giay() {
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

	public String getNgaythem() {
		return ngaythem;
	}

	public void setNgaythem(String ngaythem) {
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

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
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

	public List<Size> getSizes() {
		return this.sizes;
	}

	public void setSizes(List<Size> sizes) {
		this.sizes = sizes;
	}

	public List<GiayDonhang> getGiayDonhangs() {
		return this.giayDonhangs;
	}

	public void setGiayDonhangs(List<GiayDonhang> giayDonhangs) {
		this.giayDonhangs = giayDonhangs;
	}

	public GiayDonhang addGiayDonhang(GiayDonhang giayDonhang) {
		getGiayDonhangs().add(giayDonhang);
		giayDonhang.setGiay(this);

		return giayDonhang;
	}

	public GiayDonhang removeGiayDonhang(GiayDonhang giayDonhang) {
		getGiayDonhangs().remove(giayDonhang);
		giayDonhang.setGiay(null);

		return giayDonhang;
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

	public List<Mausac> getMausacs() {
		return this.mausacs;
	}

	public void setMausacs(List<Mausac> mausacs) {
		this.mausacs = mausacs;
	}

	public int getMaLgiayHang() {
		return maLgiayHang;
	}

	public void setMaLgiayHang(int maLgiayHang) {
		this.maLgiayHang = maLgiayHang;
	}

}