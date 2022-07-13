package com.herokuapp.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the nhanvien_donhang database table.
 * 
 */
@Embeddable
public class NhanvienDonhangPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_nhanviendonhang", unique=true, nullable=false)
	private int idNhanviendonhang;

	@Column(insertable=false, updatable=false, unique=true, nullable=false, length=10)
	private String manv;

	@Column(insertable=false, updatable=false, unique=true, nullable=false, length=10)
	private String madon;

	public NhanvienDonhangPK() {
	}
	public int getIdNhanviendonhang() {
		return this.idNhanviendonhang;
	}
	public void setIdNhanviendonhang(int idNhanviendonhang) {
		this.idNhanviendonhang = idNhanviendonhang;
	}
	public String getManv() {
		return this.manv;
	}
	public void setManv(String manv) {
		this.manv = manv;
	}
	public String getMadon() {
		return this.madon;
	}
	public void setMadon(String madon) {
		this.madon = madon;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof NhanvienDonhangPK)) {
			return false;
		}
		NhanvienDonhangPK castOther = (NhanvienDonhangPK)other;
		return 
			(this.idNhanviendonhang == castOther.idNhanviendonhang)
			&& this.manv.equals(castOther.manv)
			&& this.madon.equals(castOther.madon);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idNhanviendonhang;
		hash = hash * prime + this.manv.hashCode();
		hash = hash * prime + this.madon.hashCode();
		
		return hash;
	}
}