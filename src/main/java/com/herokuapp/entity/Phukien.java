package com.herokuapp.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the phukien database table.
 * 
 */
@Entity
@NamedQuery(name="Phukien.findAll", query="SELECT p FROM Phukien p")
public class Phukien implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String mapk;

	private int gia;

	@Lob
	private String mota;

	private int soluong;

	private String tenpk;

	//bi-directional many-to-one association to Binhluan
	@OneToMany(mappedBy="phukien")
	private List<Binhluan> binhluans;

	//bi-directional many-to-one association to Hinh
	@OneToMany(mappedBy="phukien")
	private List<Hinh> hinhs;

	//bi-directional many-to-one association to Loaiphukien
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="maloaipk")
	private Loaiphukien loaiphukien;

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

}