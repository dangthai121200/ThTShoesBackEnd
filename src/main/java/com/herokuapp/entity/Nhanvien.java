package com.herokuapp.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the nhanvien database table.
 * 
 */
@Entity
@NamedQuery(name = "Nhanvien.findAll", query = "SELECT n FROM Nhanvien n")
public class Nhanvien implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String manv;

	@Lob
	private String diachi;

	private String ho;

	private int sdt;

	private String ten;

	// bi-directional many-to-one association to Dskhuyenmai
	@OneToMany(mappedBy = "nhanvien")
	private List<Dskhuyenmai> dskhuyenmais;

	// bi-directional many-to-many association to Donhang
	@ManyToMany
	@JoinTable(name = "nhanvien_donhang", joinColumns = { @JoinColumn(name = "manv") }, inverseJoinColumns = {
			@JoinColumn(name = "madon") })
	private List<Donhang> donhangs;

	// bi-directional one-to-one association to Taikhoan
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "manv", referencedColumnName = "manguoidung")
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