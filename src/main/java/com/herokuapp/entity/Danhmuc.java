package com.herokuapp.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the danhmuc database table.
 * 
 */
@Entity
@NamedQuery(name="Danhmuc.findAll", query="SELECT d FROM Danhmuc d")
public class Danhmuc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String madm;

	private String tendanhmuc;

	//bi-directional many-to-one association to Loaigiay
	@OneToMany(mappedBy="danhmuc", fetch = FetchType.LAZY)
	private List<Loaigiay> loaigiays;

	public Danhmuc() {
	}

	public String getMadm() {
		return this.madm;
	}

	public void setMadm(String madm) {
		this.madm = madm;
	}

	public String getTendanhmuc() {
		return this.tendanhmuc;
	}

	public void setTendanhmuc(String tendanhmuc) {
		this.tendanhmuc = tendanhmuc;
	}

	public List<Loaigiay> getLoaigiays() {
		return this.loaigiays;
	}

	public void setLoaigiays(List<Loaigiay> loaigiays) {
		this.loaigiays = loaigiays;
	}

	public Loaigiay addLoaigiay(Loaigiay loaigiay) {
		getLoaigiays().add(loaigiay);
		loaigiay.setDanhmuc(this);

		return loaigiay;
	}

	public Loaigiay removeLoaigiay(Loaigiay loaigiay) {
		getLoaigiays().remove(loaigiay);
		loaigiay.setDanhmuc(null);

		return loaigiay;
	}

}