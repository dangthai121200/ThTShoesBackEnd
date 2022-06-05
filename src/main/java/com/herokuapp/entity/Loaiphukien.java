package com.herokuapp.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the loaiphukien database table.
 * 
 */
@Entity
@NamedQuery(name="Loaiphukien.findAll", query="SELECT l FROM Loaiphukien l")
public class Loaiphukien implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String maloaipk;

	private String tenloai;

	//bi-directional many-to-one association to Phukien
	@OneToMany(mappedBy="loaiphukien")
	private List<Phukien> phukiens;

	public Loaiphukien() {
	}

	public String getMaloaipk() {
		return this.maloaipk;
	}

	public void setMaloaipk(String maloaipk) {
		this.maloaipk = maloaipk;
	}

	public String getTenloai() {
		return this.tenloai;
	}

	public void setTenloai(String tenloai) {
		this.tenloai = tenloai;
	}

	public List<Phukien> getPhukiens() {
		return this.phukiens;
	}

	public void setPhukiens(List<Phukien> phukiens) {
		this.phukiens = phukiens;
	}

	public Phukien addPhukien(Phukien phukien) {
		getPhukiens().add(phukien);
		phukien.setLoaiphukien(this);

		return phukien;
	}

	public Phukien removePhukien(Phukien phukien) {
		getPhukiens().remove(phukien);
		phukien.setLoaiphukien(null);

		return phukien;
	}

}