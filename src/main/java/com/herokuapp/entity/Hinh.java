package com.herokuapp.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the hinh database table.
 * 
 */
@Entity
@NamedQuery(name="Hinh.findAll", query="SELECT h FROM Hinh h")
public class Hinh implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String mahinh;

	@Lob
	private String duongdan;

	//bi-directional many-to-one association to Giay
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="magiay")
	private Giay giay;

	//bi-directional many-to-one association to Phukien
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="mapk")
	private Phukien phukien;

	public Hinh() {
	}

	public String getMahinh() {
		return this.mahinh;
	}

	public void setMahinh(String mahinh) {
		this.mahinh = mahinh;
	}

	public String getDuongdan() {
		return this.duongdan;
	}

	public void setDuongdan(String duongdan) {
		this.duongdan = duongdan;
	}

	public Giay getGiay() {
		return this.giay;
	}

	public void setGiay(Giay giay) {
		this.giay = giay;
	}

	public Phukien getPhukien() {
		return this.phukien;
	}

	public void setPhukien(Phukien phukien) {
		this.phukien = phukien;
	}

}