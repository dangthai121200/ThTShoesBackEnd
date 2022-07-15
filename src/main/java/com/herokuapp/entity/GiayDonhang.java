package com.herokuapp.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the giay_donhang database table.
 * 
 */
@Entity
@Table(name = "giay_donhang")
@NamedQuery(name = "GiayDonhang.findAll", query = "SELECT g FROM GiayDonhang g")
public class GiayDonhang implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private GiayDonhangPK id;

	@Column(nullable = false)
	private int soluong;

	@Column(nullable = false)
	private int tonggia;

	// bi-directional many-to-one association to Donhang
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "madon", nullable = false, insertable = false, updatable = false)
	private Donhang donhang;


	public GiayDonhang() {
	}

	public GiayDonhangPK getId() {
		return this.id;
	}

	public void setId(GiayDonhangPK id) {
		this.id = id;
	}

	public int getSoluong() {
		return this.soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public int getTonggia() {
		return this.tonggia;
	}

	public void setTonggia(int tonggia) {
		this.tonggia = tonggia;
	}

	public Donhang getDonhang() {
		return this.donhang;
	}

	public void setDonhang(Donhang donhang) {
		this.donhang = donhang;
	}

}