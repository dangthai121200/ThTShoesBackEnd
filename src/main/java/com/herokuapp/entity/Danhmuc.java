package com.herokuapp.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the danhmuc database table.
 * 
 */
@Entity
@Table(name = "danhmuc")
@NamedQuery(name = "Danhmuc.findAll", query = "SELECT d FROM Danhmuc d")
public class Danhmuc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique = true, length = 10)
	private String madanhmuc;

	@Column(unique = true, nullable = false, length = 20)
	private String tendanhmuc;

	// bi-directional many-to-one association to LoaigiayHangDanhmuc
	@OneToMany(mappedBy = "danhmuc")
	private List<LoaigiayHangDanhmuc> loaigiayHangDanhmucs;

	public Danhmuc() {
		this.madanhmuc = "";
	}

	public String getMadanhmuc() {
		return this.madanhmuc;
	}

	public void setMadanhmuc(String madanhmuc) {
		this.madanhmuc = madanhmuc;
	}

	public String getTendanhmuc() {
		return this.tendanhmuc;
	}

	public void setTendanhmuc(String tendanhmuc) {
		this.tendanhmuc = tendanhmuc;
	}

	public List<LoaigiayHangDanhmuc> getLoaigiayHangDanhmucs() {
		return this.loaigiayHangDanhmucs;
	}

	public void setLoaigiayHangDanhmucs(List<LoaigiayHangDanhmuc> loaigiayHangDanhmucs) {
		this.loaigiayHangDanhmucs = loaigiayHangDanhmucs;
	}

	public LoaigiayHangDanhmuc addLoaigiayHangDanhmuc(LoaigiayHangDanhmuc loaigiayHangDanhmuc) {
		getLoaigiayHangDanhmucs().add(loaigiayHangDanhmuc);
		loaigiayHangDanhmuc.setDanhmuc(this);

		return loaigiayHangDanhmuc;
	}

	public LoaigiayHangDanhmuc removeLoaigiayHangDanhmuc(LoaigiayHangDanhmuc loaigiayHangDanhmuc) {
		getLoaigiayHangDanhmucs().remove(loaigiayHangDanhmuc);
		loaigiayHangDanhmuc.setDanhmuc(null);

		return loaigiayHangDanhmuc;
	}

}