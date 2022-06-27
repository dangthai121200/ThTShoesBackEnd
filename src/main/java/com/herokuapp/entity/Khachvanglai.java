package com.herokuapp.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the khachvanglai database table.
 * 
 */
@Entity
@NamedQuery(name="Khachvanglai.findAll", query="SELECT k FROM Khachvanglai k")
public class Khachvanglai implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String makh;

	private String diachi;

	private String email;

	@Lob
	private String ghichu;

	private String ho;

	private int sdt;

	private String ten;

	public Khachvanglai() {
	}

	public String getMakh() {
		return this.makh;
	}

	public void setMakh(String makh) {
		this.makh = makh;
	}

	public String getDiachi() {
		return this.diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGhichu() {
		return this.ghichu;
	}

	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
	}

	public String getHo() {
		return this.ho;
	}

	public void setHo(String ho) {
		this.ho = ho;
	}

	public int getSdt() {
		return this.sdt;
	}

	public void setSdt(int sdt) {
		this.sdt = sdt;
	}

	public String getTen() {
		return this.ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

}