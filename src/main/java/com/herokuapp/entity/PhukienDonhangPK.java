package com.herokuapp.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the phukien_donhang database table.
 * 
 */
@Embeddable
public class PhukienDonhangPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false, unique=true, nullable=false, length=10)
	private String mapk;

	@Column(insertable=false, updatable=false, unique=true, nullable=false, length=10)
	private String madon;

	public PhukienDonhangPK() {
	}
	public String getMapk() {
		return this.mapk;
	}
	public void setMapk(String mapk) {
		this.mapk = mapk;
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
		if (!(other instanceof PhukienDonhangPK)) {
			return false;
		}
		PhukienDonhangPK castOther = (PhukienDonhangPK)other;
		return 
			this.mapk.equals(castOther.mapk)
			&& this.madon.equals(castOther.madon);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.mapk.hashCode();
		hash = hash * prime + this.madon.hashCode();
		
		return hash;
	}
}