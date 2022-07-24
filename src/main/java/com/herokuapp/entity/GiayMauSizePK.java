package com.herokuapp.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the giay_mau_size database table.
 * 
 */
@Embeddable
public class GiayMauSizePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "id", unique=true, nullable=false)
	private int id;

	@Column(insertable=false, updatable=false, unique=true, nullable=false, length=10)
	private String magiay;

	@Column(insertable=false, updatable=false, unique=true, nullable=false, length=10)
	private String mamau;

	@Column(insertable=false, updatable=false, unique=true, nullable=false, length=10)
	private String masize;

	public GiayMauSizePK() {
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMagiay() {
		return this.magiay;
	}
	public void setMagiay(String magiay) {
		this.magiay = magiay;
	}
	public String getMamau() {
		return this.mamau;
	}
	public void setMamau(String mamau) {
		this.mamau = mamau;
	}
	public String getMasize() {
		return this.masize;
	}
	public void setMasize(String masize) {
		this.masize = masize;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof GiayMauSizePK)) {
			return false;
		}
		GiayMauSizePK castOther = (GiayMauSizePK)other;
		return 
			(this.id == castOther.id)
			&& this.magiay.equals(castOther.magiay)
			&& this.mamau.equals(castOther.mamau)
			&& this.masize.equals(castOther.masize);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.id;
		hash = hash * prime + this.magiay.hashCode();
		hash = hash * prime + this.mamau.hashCode();
		hash = hash * prime + this.masize.hashCode();
		
		return hash;
	}
}