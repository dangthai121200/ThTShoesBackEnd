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
	private String diachi;

	@Column(nullable = false, length = 10)
	private String ho;

	@Column(nullable = false)
	private int sdt;

	@Column(nullable = false, length = 30)
	private String ten;

	// bi-directional many-to-one association to Dskhuyenmai
	@OneToMany(mappedBy = "nhanvien")
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

}