package com.herokuapp.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the giay database table.
 * 
 */
@Entity
@NamedQuery(name="Giay.findAll", query="SELECT g FROM Giay g")
public class Giay implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String magiay;

	private String chatlieu;

	private int gia;

	private String kieudang;

	@Lob
	private String mota;

	private String tengiay;

	private int trongluong;

	//bi-directional many-to-one association to Binhluan
	@OneToMany(mappedBy="giay")
	private List<Binhluan> binhluans;

	//bi-directional many-to-one association to Loaigiay
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="maloaigiay")
	private Loaigiay loaigiay;

	//bi-directional many-to-many association to Size
	@ManyToMany
	@JoinTable(
		name="giay_size"
		, joinColumns={
			@JoinColumn(name="magiay")
			}
		, inverseJoinColumns={
			@JoinColumn(name="masize")
			}
		)
	private List<Size> sizes;

	//bi-directional many-to-one association to GiayDonhang
	@OneToMany(mappedBy="giay")
	private List<GiayDonhang> giayDonhangs;

	//bi-directional many-to-one association to Hinh
	@OneToMany(mappedBy="giay")
	private List<Hinh> hinhs;

	//bi-directional many-to-many association to Mausac
	@ManyToMany(mappedBy="giays")
	private List<Mausac> mausacs;

	public Giay() {
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

	public Loaigiay getLoaigiay() {
		return this.loaigiay;
	}

	public void setLoaigiay(Loaigiay loaigiay) {
		this.loaigiay = loaigiay;
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

}