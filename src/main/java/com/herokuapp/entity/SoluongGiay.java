package com.herokuapp.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "soluong_giay")
public class SoluongGiay {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false)
	private int soluongthem;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date ngaythem;

	@Lob
	private String mota;

	@Column(name = "id_giay_size_mau", nullable = true, length = 10)
	private int idGiaySizeMau;

	public SoluongGiay() {
		this.ngaythem = new Date();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSoluongthem() {
		return soluongthem;
	}

	public void setSoluongthem(int soluongthem) {
		this.soluongthem = soluongthem;
	}

	public Date getNgaythem() {
		return ngaythem;
	}

	public void setNgaythem(Date ngaythem) {
		this.ngaythem = ngaythem;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public int getIdGiaySizeMau() {
		return idGiaySizeMau;
	}

	public void setIdGiaySizeMau(int idGiaySizeMau) {
		this.idGiaySizeMau = idGiaySizeMau;
	}
	
	

}
