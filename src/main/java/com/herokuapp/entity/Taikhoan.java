package com.herokuapp.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.herokuapp.enums.Quyen;

/**
 * The persistent class for the taikhoan database table.
 * 
 */
@Entity
//@Table(name = "taikhoan")
public class Taikhoan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String manguoidung;

	private String email;

	@Lob
	private String password;

	@Enumerated(EnumType.STRING)
	private Quyen quyen;

	private byte tinhtrang;

	private String username;

	// bi-directional one-to-one association to Khachhang
	@OneToOne(mappedBy = "taikhoan", fetch = FetchType.LAZY)
	private Khachhang khachhang;

	// bi-directional one-to-one association to Nhanvien
	@OneToOne(mappedBy = "taikhoan", fetch = FetchType.LAZY)
	private Nhanvien nhanvien;

	public Taikhoan() {
	}

	public String getManguoidung() {
		return this.manguoidung;
	}

	public void setManguoidung(String manguoidung) {
		this.manguoidung = manguoidung;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Quyen getQuyen() {
		return this.quyen;
	}

	public void setQuyen(Quyen quyen) {
		this.quyen = quyen;
	}

	public byte getTinhtrang() {
		return this.tinhtrang;
	}

	public void setTinhtrang(byte tinhtrang) {
		this.tinhtrang = tinhtrang;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Khachhang getKhachhang() {
		return this.khachhang;
	}

	public void setKhachhang(Khachhang khachhang) {
		this.khachhang = khachhang;
	}

	public Nhanvien getNhanvien() {
		return this.nhanvien;
	}

	public void setNhanvien(Nhanvien nhanvien) {
		this.nhanvien = nhanvien;
	}
}