package com.herokuapp.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



/**
 * The persistent class for the nhanvien database table.
 * 
 */
@Entity
@Table(name = "nhanvien")
@NamedQuery(name = "Nhanvien.findAll", query = "SELECT n FROM Nhanvien n")
public class Nhanvien implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique = true, nullable = false, length = 10)
	private String manv;

	@Column(nullable = false)
	@Lob
	private String diachi;

	@Column(nullable = false, length = 10)
	private String ho;

	@Column(nullable = false, length = 11)
	private int sdt;

	@Column(nullable = false, length = 30)
	private String ten;

	// bi-directional many-to-one association to Dskhuyenmai
	@OneToMany(mappedBy = "nhanvien", fetch = FetchType.LAZY)
	private List<Dskhuyenmai> dskhuyenmais;

	// bi-directional many-to-many association to Donhang
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "nhanvien_donhang", joinColumns = {
			@JoinColumn(name = "manv", nullable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "madon", nullable = false) })
	private List<Donhang> donhangs;

	// bi-directional one-to-one association to Taikhoan
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "manv", nullable = false, insertable = false, updatable = false)
	private Taikhoan taikhoan;
	
	//bi-directional many-to-one association to Binhluan
		@OneToMany(mappedBy="nhanvien")
		private List<Binhluan> binhluans;

	public Nhanvien() {
	}

	public String getManv() {
		return this.manv;
	}

	public void setManv(String manv) {
		this.manv = manv;
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

	public int getSdt() {
		return this.sdt;
	}

	public void setSdt(int sdt) {
		this.sdt = sdt;
	}

	public String getTen() {
		return this.ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public List<Dskhuyenmai> getDskhuyenmais() {
		return this.dskhuyenmais;
	}

	public void setDskhuyenmais(List<Dskhuyenmai> dskhuyenmais) {
		this.dskhuyenmais = dskhuyenmais;
	}

	public Dskhuyenmai addDskhuyenmai(Dskhuyenmai dskhuyenmai) {
		getDskhuyenmais().add(dskhuyenmai);
		dskhuyenmai.setNhanvien(this);

		return dskhuyenmai;
	}

	public Dskhuyenmai removeDskhuyenmai(Dskhuyenmai dskhuyenmai) {
		getDskhuyenmais().remove(dskhuyenmai);
		dskhuyenmai.setNhanvien(null);

		return dskhuyenmai;
	}

	public List<Donhang> getDonhangs() {
		return this.donhangs;
	}

	public void setDonhangs(List<Donhang> donhangs) {
		this.donhangs = donhangs;
	}

	public Taikhoan getTaikhoan() {
		return this.taikhoan;
	}

	public void setTaikhoan(Taikhoan taikhoan) {
		this.taikhoan = taikhoan;
	}
	
	public List<Binhluan> getBinhluans() {
		return this.binhluans;
	}

	public void setBinhluans(List<Binhluan> binhluans) {
		this.binhluans = binhluans;
	}

	public Binhluan addBinhluan(Binhluan binhluan) {
		getBinhluans().add(binhluan);
		binhluan.setNhanvien(this);

		return binhluan;
	}

	public Binhluan removeBinhluan(Binhluan binhluan) {
		getBinhluans().remove(binhluan);
		binhluan.setNhanvien(null);

		return binhluan;
	}

}