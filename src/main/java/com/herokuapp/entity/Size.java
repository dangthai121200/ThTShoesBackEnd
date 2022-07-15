package com.herokuapp.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the size database table.
 * 
 */
@Entity
@Table(name="size")
@NamedQuery(name="Size.findAll", query="SELECT s FROM Size s")
public class Size implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, length=10)
	private String masize;

	@Column(nullable=false, length=10)
	private String tensize;

	//bi-directional many-to-one association to GiayMauSize
	@OneToMany(mappedBy="size")
	private List<GiayMauSize> giayMauSizes;

	public Size() {
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