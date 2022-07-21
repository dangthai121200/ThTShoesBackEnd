package com.herokuapp.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the mausac database table.
 * 
 */
@Entity
@Table(name = "mausac")
@NamedQuery(name = "Mausac.findAll", query = "SELECT m FROM Mausac m")
public class Mausac implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(length = 10)
	private String mamau;

	@Column(nullable = false, length = 10)
	private String tenmau;

	// bi-directional many-to-one association to GiayMauSize
	@OneToMany(mappedBy = "mausac", fetch = FetchType.LAZY)
	private List<GiayMauSize> giayMauSizes;

	public Mausac() {
		this.mamau = "";
	}

	public String getMamau() {
		return this.mamau;
	}

	public void setMamau(String mamau) {
		this.mamau = mamau;
	}

	public String getTenmau() {
		return this.tenmau;
	}

	public void setTenmau(String tenmau) {
		this.tenmau = tenmau;
	}

	public List<GiayMauSize> getGiayMauSizes() {
		return this.giayMauSizes;
	}

	public void setGiayMauSizes(List<GiayMauSize> giayMauSizes) {
		this.giayMauSizes = giayMauSizes;
	}

	public GiayMauSize addGiayMauSize(GiayMauSize giayMauSize) {
		getGiayMauSizes().add(giayMauSize);
		giayMauSize.setMausac(this);

		return giayMauSize;
	}

	public GiayMauSize removeGiayMauSize(GiayMauSize giayMauSize) {
		getGiayMauSizes().remove(giayMauSize);
		giayMauSize.setMausac(null);

		return giayMauSize;
	}

}