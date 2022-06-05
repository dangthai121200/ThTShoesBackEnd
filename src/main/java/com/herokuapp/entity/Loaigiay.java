package com.herokuapp.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the loaigiay database table.
 * 
 */
@Entity
@NamedQuery(name="Loaigiay.findAll", query="SELECT l FROM Loaigiay l")
public class Loaigiay implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String maloaigiay;

	private String tenloai;

	//bi-directional many-to-one association to Giay
	@OneToMany(mappedBy="loaigiay")
	private List<Giay> giays;

	//bi-directional many-to-one association to Danhmuc
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="madm")
	private Danhmuc danhmuc;

	//bi-directional many-to-many association to Hang
	@ManyToMany
	@JoinTable(
		name="loaigiay_hang"
		, joinColumns={
			@JoinColumn(name="maloaigiay")
			}
		, inverseJoinColumns={
			@JoinColumn(name="mahang")
			}
		)
	private List<Hang> hangs;

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

	public List<Giay> getGiays() {
		return this.giays;
	}

	public void setGiays(List<Giay> giays) {
		this.giays = giays;
	}

	public Giay addGiay(Giay giay) {
		getGiays().add(giay);
		giay.setLoaigiay(this);

		return giay;
	}

	public Giay removeGiay(Giay giay) {
		getGiays().remove(giay);
		giay.setLoaigiay(null);

		return giay;
	}

	public Danhmuc getDanhmuc() {
		return this.danhmuc;
	}

	public void setDanhmuc(Danhmuc danhmuc) {
		this.danhmuc = danhmuc;
	}

	public List<Hang> getHangs() {
		return this.hangs;
	}

	public void setHangs(List<Hang> hangs) {
		this.hangs = hangs;
	}

}