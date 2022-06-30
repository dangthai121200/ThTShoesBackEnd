package com.herokuapp.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the loaigiay_hang_danhmuc database table.
 * 
 */
@Entity
@Table(name = "loaigiay_hang_danhmuc")
@NamedQuery(name = "LoaigiayHangDanhmuc.findAll", query = "SELECT l FROM LoaigiayHangDanhmuc l")
public class LoaigiayHangDanhmuc implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LoaigiayHangDanhmucPK id;

	// bi-directional many-to-one association to Danhmuc
	@ManyToOne
	@JoinColumn(name = "madanhmuc", nullable = false, insertable = false, updatable = false)
	private Danhmuc danhmuc;

	// bi-directional many-to-one association to Hang
	@ManyToOne
	@JoinColumn(name = "mahang", nullable = false, insertable = false, updatable = false)
	private Hang hang;

	// bi-directional many-to-one association to Loaigiay
	@ManyToOne
	@JoinColumn(name = "maloaigiay", nullable = false, insertable = false, updatable = false)
	private Loaigiay loaigiay;

	public LoaigiayHangDanhmuc() {
	}

	public LoaigiayHangDanhmucPK getId() {
		return this.id;
	}

	public void setId(LoaigiayHangDanhmucPK id) {
		this.id = id;
	}

	public Danhmuc getDanhmuc() {
		return this.danhmuc;
	}

	public void setDanhmuc(Danhmuc danhmuc) {
		this.danhmuc = danhmuc;
	}

	public Hang getHang() {
		return this.hang;
	}

	public void setHang(Hang hang) {
		this.hang = hang;
	}

	public Loaigiay getLoaigiay() {
		return this.loaigiay;
	}

	public void setLoaigiay(Loaigiay loaigiay) {
		this.loaigiay = loaigiay;
	}


}