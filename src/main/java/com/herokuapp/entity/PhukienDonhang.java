package com.herokuapp.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the phukien_donhang database table.
 * 
 */
@Entity
@Table(name = "phukien_donhang")
@NamedQuery(name = "PhukienDonhang.findAll", query = "SELECT p FROM PhukienDonhang p")
public class PhukienDonhang implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PhukienDonhangPK id;

	private int soluong;

	private int tonggia;

	// bi-directional many-to-one association to Donhang
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "madon", insertable=false, updatable=false)
	private Donhang donhang;

	public PhukienDonhang() {
	}

	public PhukienDonhangPK getId() {
		return this.id;
	}

	public void setId(PhukienDonhangPK id) {
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