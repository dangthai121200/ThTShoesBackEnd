package com.herokuapp.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the giay_donhang database table.
 * 
 */
@Embeddable
public class GiayDonhangPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false, unique=true, nullable=false, length=10)
	private String magiay;

	@Column(insertable=false, updatable=false, unique=true, nullable=false, length=10)
	private String madon;

	public GiayDonhangPK() {
	}
	public String getMagiay() {
		return this.magiay;
	}
	public void setMagiay(String magiay) {
		this.magiay = magiay;
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
		if (!(other instanceof GiayDonhangPK)) {
			return false;
		}
		GiayDonhangPK castOther = (GiayDonhangPK)other;
		return 
			this.magiay.equals(castOther.magiay)
			&& this.madon.equals(castOther.madon);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.magiay.hashCode();
		hash = hash * prime + this.madon.hashCode();
		
		return hash;
	}
}