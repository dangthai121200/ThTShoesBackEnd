package com.herokuapp.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.herokuapp.enums.Quyen;


/**
 * The persistent class for the taikhoan database table.
 * 
 */
@Entity
@Table(name="taikhoan")
@NamedQuery(name="Taikhoan.findAll", query="SELECT t FROM Taikhoan t")
public class Taikhoan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, length=10)
	private String manguoidung;

	@Column(nullable=false, length=30)
	private String email;

	@Column(nullable=false)
	private String password;

	@Column(nullable=false, length=1)
	@Enumerated(EnumType.STRING)
	private Quyen quyen;

	@Column(nullable=false)
	private Byte tinhtrang;

	@Column(nullable=false, length=20)
	private String username;

	//bi-directional one-to-one association to Khachhang
	@OneToOne(mappedBy="taikhoan")
	private Khachhang khachhang;

	//bi-directional one-to-one association to Nhanvien
	@OneToOne(mappedBy="taikhoan")
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