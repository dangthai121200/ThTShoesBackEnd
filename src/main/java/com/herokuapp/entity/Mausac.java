package com.herokuapp.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


/**
 * The persistent class for the mausac database table.
 * 
 */
@Entity
@Table(name="mausac")
@NamedQuery(name="Mausac.findAll", query="SELECT m FROM Mausac m")
public class Mausac implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, length=10)
	private String mamau;

	@Column(nullable=false, length=10)
	private String tenmau;

	//bi-directional many-to-many association to Giay
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name="giay_mau"
		, joinColumns={
			@JoinColumn(name="mamau", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="magiay", nullable=false)
			}
		)
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