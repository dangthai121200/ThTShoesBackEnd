package com.herokuapp.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the soluong_phukien database table.
 * 
 */
@Entity
@Table(name = "soluong_phukien")
@NamedQuery(name = "SoluongPhukien.findAll", query = "SELECT s FROM SoluongPhukien s")
public class SoluongPhukien implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int id;

	@Lob
	private String mota;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date ngaythem;

	@Column(nullable = false)
	private int soluong;

	// bi-directional many-to-one association to Phukien
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "mapk", nullable = false)
	private Phukien phukien;

	public SoluongPhukien() {
		this.ngaythem = new Date();
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMota() {
		return this.mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public Date getNgaythem() {
		return this.ngaythem;
	}

	public void setNgaythem(Date ngaythem) {
		this.ngaythem = ngaythem;
	}

	public int getSoluong() {
		return this.soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public Phukien getPhukien() {
		return this.phukien;
	}

	public void setPhukien(Phukien phukien) {
		this.phukien = phukien;
	}

}