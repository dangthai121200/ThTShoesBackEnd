package com.herokuapp.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the dskhuyenmai database table.
 * 
 */
@Entity
@NamedQuery(name="Dskhuyenmai.findAll", query="SELECT d FROM Dskhuyenmai d")
public class Dskhuyenmai implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String makm;

	private int giatrigiam;

	@Lob
	private String mota;

	@Temporal(TemporalType.TIMESTAMP)
	private Date ngaybd;

	@Temporal(TemporalType.TIMESTAMP)
	private Date ngaykt;

	private int soluong;

	//bi-directional many-to-one association to Donhang
	@OneToMany(mappedBy="dskhuyenmai")
	private List<Donhang> donhangs;

	//bi-directional many-to-one association to Nhanvien
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="manv")
	private Nhanvien nhanvien;

	public Dskhuyenmai() {
	}

	public String getMakm() {
		return this.makm;
	}

	public void setMakm(String makm) {
		this.makm = makm;
	}

	public int getGiatrigiam() {
		return this.giatrigiam;
	}

	public void setGiatrigiam(int giatrigiam) {
		this.giatrigiam = giatrigiam;
	}

	public String getMota() {
		return this.mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public Date getNgaybd() {
		return this.ngaybd;
	}

	public void setNgaybd(Date ngaybd) {
		this.ngaybd = ngaybd;
	}

	public Date getNgaykt() {
		return this.ngaykt;
	}

	public void setNgaykt(Date ngaykt) {
		this.ngaykt = ngaykt;
	}

	public int getSoluong() {
		return this.soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public List<Donhang> getDonhangs() {
		return this.donhangs;
	}

	public void setDonhangs(List<Donhang> donhangs) {
		this.donhangs = donhangs;
	}

	public Donhang addDonhang(Donhang donhang) {
		getDonhangs().add(donhang);
		donhang.setDskhuyenmai(this);

		return donhang;
	}

	public Donhang removeDonhang(Donhang donhang) {
		getDonhangs().remove(donhang);
		donhang.setDskhuyenmai(null);

		return donhang;
	}

	public Nhanvien getNhanvien() {
		return this.nhanvien;
	}

	public void setNhanvien(Nhanvien nhanvien) {
		this.nhanvien = nhanvien;
	}

}