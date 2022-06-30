package com.herokuapp.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the hang database table.
 * 
 */
@Entity
@Table(name="hang")
@NamedQuery(name="Hang.findAll", query="SELECT h FROM Hang h")
public class Hang implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, length=10)
	private String mahang;

	@Column(nullable=false, length=50)
	private String tenhang;

	//bi-directional many-to-one association to LoaigiayHangDanhmuc
	@OneToMany(mappedBy="hang")
	private List<LoaigiayHangDanhmuc> loaigiayHangDanhmucs;

	public Hang() {
	}

	public String getMahang() {
		return this.mahang;
	}

	public void setMahang(String mahang) {
		this.mahang = mahang;
	}

	public String getTenhang() {
		return this.tenhang;
	}

	public void setTenhang(String tenhang) {
		this.tenhang = tenhang;
	}

	public List<LoaigiayHangDanhmuc> getLoaigiayHangDanhmucs() {
		return this.loaigiayHangDanhmucs;
	}

	public void setLoaigiayHangDanhmucs(List<LoaigiayHangDanhmuc> loaigiayHangDanhmucs) {
		this.loaigiayHangDanhmucs = loaigiayHangDanhmucs;
	}

	public LoaigiayHangDanhmuc addLoaigiayHangDanhmuc(LoaigiayHangDanhmuc loaigiayHangDanhmuc) {
		getLoaigiayHangDanhmucs().add(loaigiayHangDanhmuc);
		loaigiayHangDanhmuc.setHang(this);

		return loaigiayHangDanhmuc;
	}

	public LoaigiayHangDanhmuc removeLoaigiayHangDanhmuc(LoaigiayHangDanhmuc loaigiayHangDanhmuc) {
		getLoaigiayHangDanhmucs().remove(loaigiayHangDanhmuc);
		loaigiayHangDanhmuc.setHang(null);

		return loaigiayHangDanhmuc;
	}

}