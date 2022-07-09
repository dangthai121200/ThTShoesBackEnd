package com.herokuapp.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
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
 * The persistent class for the dskhuyenmai database table.
 * 
 */
@Entity
@Table(name="dskhuyenmai")
@NamedQuery(name="Dskhuyenmai.findAll", query="SELECT d FROM Dskhuyenmai d")
public class Dskhuyenmai implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, length=10)
	private String makm;

	@Column(nullable=false)
	private int giatrigiam;

	@Lob
	private String mota;

	@Temporal(TemporalType.TIMESTAMP)
	private Date ngaybd;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date ngaykt;

	@Column(nullable=false)
	private int soluong;
	
	@Lob
	private String urlanh;
	
	private String tieude;

	//bi-directional many-to-one association to Donhang
	@OneToMany(mappedBy="dskhuyenmai")
	private List<Donhang> donhangs;

	//bi-directional many-to-one association to Nhanvien
	@ManyToOne
	@JoinColumn(name="manv", nullable=false)
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
	
	

	public String getUrlanh() {
		return urlanh;
	}

	public void setUrlanh(String urlanh) {
		this.urlanh = urlanh;
	}

	public String getTieude() {
		return tieude;
	}

	public void setTieude(String tieude) {
		this.tieude = tieude;
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