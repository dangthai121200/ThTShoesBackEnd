package com.herokuapp.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the giay_mau_size database table.
 * 
 */
@Entity
@Table(name = "giay_mau_size")
@NamedQuery(name = "GiayMauSize.findAll", query = "SELECT g FROM GiayMauSize g")
public class GiayMauSize implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private GiayMauSizePK id;

	// bi-directional many-to-one association to Giay
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "magiay", nullable = false, insertable = false, updatable = false)
	private Giay giay;

	// bi-directional many-to-one association to Size
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "masize", nullable = false, insertable = false, updatable = false)
	private Size size;

	// bi-directional many-to-one association to Mausac
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "mamau", nullable = false, insertable = false, updatable = false)
	private Mausac mausac;

	private int soluong;

	public GiayMauSize() {
	}

	public GiayMauSizePK getId() {
		return this.id;
	}

	public void setId(GiayMauSizePK id) {
		this.id = id;
	}

	public Giay getGiay() {
		return this.giay;
	}

	public void setGiay(Giay giay) {
		this.giay = giay;
	}

	public Size getSize() {
		return this.size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public Mausac getMausac() {
		return this.mausac;
	}

	public void setMausac(Mausac mausac) {
		this.mausac = mausac;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

}