package com.herokuapp.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.herokuapp.enums.HanhDong;


/**
 * The persistent class for the nhanvien_donhang database table.
 * 
 */
@Entity
@Table(name="nhanvien_donhang")
@NamedQuery(name="NhanvienDonhang.findAll", query="SELECT n FROM NhanvienDonhang n")
public class NhanvienDonhang implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private NhanvienDonhangPK id;

	@Enumerated(EnumType.STRING)
	@Column(length=1)
	private HanhDong hanhdong;

	//bi-directional many-to-one association to Donhang
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="madon", nullable=false, insertable=false, updatable=false)
	private Donhang donhang;

	//bi-directional many-to-one association to Nhanvien
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="manv", nullable=false, insertable=false, updatable=false)
	private Nhanvien nhanvien;

	public NhanvienDonhang() {
	}

	public NhanvienDonhangPK getId() {
		return this.id;
	}

	public void setId(NhanvienDonhangPK id) {
		this.id = id;
	}

	public HanhDong getHanhdong() {
		return this.hanhdong;
	}

	public void setHanhdong(HanhDong hanhdong) {
		this.hanhdong = hanhdong;
	}

	public Donhang getDonhang() {
		return this.donhang;
	}

	public void setDonhang(Donhang donhang) {
		this.donhang = donhang;
	}

	public Nhanvien getNhanvien() {
		return this.nhanvien;
	}

	public void setNhanvien(Nhanvien nhanvien) {
		this.nhanvien = nhanvien;
	}

}