package com.herokuapp.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the loaigiay_hang_danhmuc database table.
 * 
 */
@Embeddable
public class LoaigiayHangDanhmucPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ma_lgiay_hang", unique=true, nullable=false)
	private int maLgiayHang;

	@Column(insertable=false, updatable=false, unique=true, nullable=false, length=10)
	private String maloaigiay;

	@Column(insertable=false, updatable=false, unique=true, nullable=false, length=10)
	private String mahang;

	@Column(insertable=false, updatable=false, unique=true, nullable=false, length=10)
	private String madanhmuc;

	public LoaigiayHangDanhmucPK() {
	}
	public int getMaLgiayHang() {
		return this.maLgiayHang;
	}
	public void setMaLgiayHang(int maLgiayHang) {
		this.maLgiayHang = maLgiayHang;
	}
	public String getMaloaigiay() {
		return this.maloaigiay;
	}
	public void setMaloaigiay(String maloaigiay) {
		this.maloaigiay = maloaigiay;
	}
	public String getMahang() {
		return this.mahang;
	}
	public void setMahang(String mahang) {
		this.mahang = mahang;
	}
	public String getMadanhmuc() {
		return this.madanhmuc;
	}
	public void setMadanhmuc(String madanhmuc) {
		this.madanhmuc = madanhmuc;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof LoaigiayHangDanhmucPK)) {
			return false;
		}
		LoaigiayHangDanhmucPK castOther = (LoaigiayHangDanhmucPK)other;
		return 
			(this.maLgiayHang == castOther.maLgiayHang)
			&& this.maloaigiay.equals(castOther.maloaigiay)
			&& this.mahang.equals(castOther.mahang)
			&& this.madanhmuc.equals(castOther.madanhmuc);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.maLgiayHang;
		hash = hash * prime + this.maloaigiay.hashCode();
		hash = hash * prime + this.mahang.hashCode();
		hash = hash * prime + this.madanhmuc.hashCode();
		
		return hash;
	}
}