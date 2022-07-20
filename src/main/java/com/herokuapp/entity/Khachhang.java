package com.herokuapp.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the khachhang database table.
 * 
 */
@Entity
@Table(name="khachhang")
@NamedQuery(name="Khachhang.findAll", query="SELECT k FROM Khachhang k")
public class Khachhang implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, length=10)
	private String makh;

	@Column(nullable=false)
	private String diachi;

	@Column(nullable=false, length=10)
	private String ho;

	@Column(nullable=false)
	private Long sdt;

	@Column(nullable=false, length=30)
	private String ten;

	//bi-directional many-to-one association to Binhluan
	@OneToMany(mappedBy="khachhang")
	private List<Binhluan> binhluans;

	//bi-directional many-to-one association to Donhang
	@OneToMany(mappedBy="khachhang")
	private List<Donhang> donhangs;

	//bi-directional one-to-one association to Taikhoan
	@OneToOne
	@JoinColumn(name="makh", nullable=false, insertable=false, updatable=false)
	private Taikhoan taikhoan;

	public Khachhang() {
	}

	public String getMakh() {
		return this.makh;
	}

	public void setMakh(String makh) {
		this.makh = makh;
	}

	public String getDiachi() {
		return this.diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getHo() {
		return this.ho;
	}

	public void setHo(String ho) {
		this.ho = ho;
	}

	public Long getSdt() {
		return this.sdt;
	}

	public void setSdt(Long sdt) {
		this.sdt = sdt;
	}

	public String getTen() {
		return this.ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public List<Binhluan> getBinhluans() {
		return this.binhluans;
	}

	public void setBinhluans(List<Binhluan> binhluans) {
		this.binhluans = binhluans;
	}

	public Binhluan addBinhluan(Binhluan binhluan) {
		getBinhluans().add(binhluan);
		binhluan.setKhachhang(this);

		return binhluan;
	}

	public Binhluan removeBinhluan(Binhluan binhluan) {
		getBinhluans().remove(binhluan);
		binhluan.setKhachhang(null);

		return binhluan;
	}

	public List<Donhang> getDonhangs() {
		return this.donhangs;
	}

	public void setDonhangs(List<Donhang> donhangs) {
		this.donhangs = donhangs;
	}

	public Donhang addDonhang(Donhang donhang) {
		getDonhangs().add(donhang);
		donhang.setKhachhang(this);

		return donhang;
	}

	public Donhang removeDonhang(Donhang donhang) {
		getDonhangs().remove(donhang);
		donhang.setKhachhang(null);

		return donhang;
	}

	public Taikhoan getTaikhoan() {
		return this.taikhoan;
	}

	public void setTaikhoan(Taikhoan taikhoan) {
		this.taikhoan = taikhoan;
	}

}