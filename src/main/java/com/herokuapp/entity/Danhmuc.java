package com.herokuapp.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the danhmuc database table.
 * 
 */
@Entity
@Table(name="danhmuc")
@NamedQuery(name="Danhmuc.findAll", query="SELECT d FROM Danhmuc d")
public class Danhmuc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, length=10)
	private String madanhmuc;

	@Column(length=45)
	private String tendanhmuc;

	//bi-directional many-to-one association to LoaigiayHangDanhmuc
	@OneToMany(mappedBy="danhmuc")
	private List<LoaigiayHangDanhmuc> loaigiayHangDanhmucs;

	public Danhmuc() {
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