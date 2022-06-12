package com.herokuapp.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the mausac database table.
 * 
 */
@Entity
@NamedQuery(name="Mausac.findAll", query="SELECT m FROM Mausac m")
public class Mausac implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String mamau;

	private String tenmau;

	//bi-directional many-to-many association to Giay
	@ManyToMany(mappedBy = "mausacs")
	private List<Giay> giays;

	public Mausac() {
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

	public List<Giay> getGiays() {
		return this.giays;
	}

	public void setGiays(List<Giay> giays) {
		this.giays = giays;
	}

}