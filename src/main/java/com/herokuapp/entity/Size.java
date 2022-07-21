package com.herokuapp.entity;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the size database table.
 * 
 */
@Entity
@Table(name = "size")
@NamedQuery(name = "Size.findAll", query = "SELECT s FROM Size s")
public class Size implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(length = 10)
	private String masize;

	@Column(nullable = false, length = 10)
	private String tensize;

	// bi-directional many-to-one association to GiayMauSize
	@OneToMany(mappedBy = "size", fetch = FetchType.LAZY)
	private List<GiayMauSize> giayMauSizes;

	public Size() {
		this.masize = "";
	}

	public String getMasize() {
		return this.masize;
	}

	public void setMasize(String masize) {
		this.masize = masize;
	}

	public String getTensize() {
		return this.tensize;
	}

	public void setTensize(String tensize) {
		this.tensize = tensize;
	}

	public List<GiayMauSize> getGiayMauSizes() {
		return this.giayMauSizes;
	}

	public void setGiayMauSizes(List<GiayMauSize> giayMauSizes) {
		this.giayMauSizes = giayMauSizes;
	}

	public GiayMauSize addGiayMauSize(GiayMauSize giayMauSize) {
		getGiayMauSizes().add(giayMauSize);
		giayMauSize.setSize(this);

		return giayMauSize;
	}

	public GiayMauSize removeGiayMauSize(GiayMauSize giayMauSize) {
		getGiayMauSizes().remove(giayMauSize);
		giayMauSize.setSize(null);

		return giayMauSize;
	}

}