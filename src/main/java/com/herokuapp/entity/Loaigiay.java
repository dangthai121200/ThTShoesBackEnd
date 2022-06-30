package com.herokuapp.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the loaigiay database table.
 * 
 */
@Entity
@Table(name="loaigiay")
@NamedQuery(name="Loaigiay.findAll", query="SELECT l FROM Loaigiay l")
public class Loaigiay implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, length=10)
	private String maloaigiay;

	@Column(nullable=false, length=50)
	private String tenloai;

	//bi-directional many-to-one association to LoaigiayHangDanhmuc
	@OneToMany(mappedBy="loaigiay")
	private List<LoaigiayHangDanhmuc> loaigiayHangDanhmucs;

	public Loaigiay() {
	}

	public String getMaloaigiay() {
		return this.maloaigiay;
	}

	public void setMaloaigiay(String maloaigiay) {
		this.maloaigiay = maloaigiay;
	}

	public String getTenloai() {
		return this.tenloai;
	}

	public void setTenloai(String tenloai) {
		this.tenloai = tenloai;
	}

	public List<LoaigiayHangDanhmuc> getLoaigiayHangDanhmucs() {
		return this.loaigiayHangDanhmucs;
	}

	public void setLoaigiayHangDanhmucs(List<LoaigiayHangDanhmuc> loaigiayHangDanhmucs) {
		this.loaigiayHangDanhmucs = loaigiayHangDanhmucs;
	}

	public LoaigiayHangDanhmuc addLoaigiayHangDanhmuc(LoaigiayHangDanhmuc loaigiayHangDanhmuc) {
		getLoaigiayHangDanhmucs().add(loaigiayHangDanhmuc);
		loaigiayHangDanhmuc.setLoaigiay(this);

		return loaigiayHangDanhmuc;
	}

	public LoaigiayHangDanhmuc removeLoaigiayHangDanhmuc(LoaigiayHangDanhmuc loaigiayHangDanhmuc) {
		getLoaigiayHangDanhmucs().remove(loaigiayHangDanhmuc);
		loaigiayHangDanhmuc.setLoaigiay(null);

		return loaigiayHangDanhmuc;
	}

}