package com.herokuapp.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

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

	//bi-directional many-to-many association to Giay
	@ManyToMany(mappedBy="sizes", fetch = FetchType.LAZY)
	private List<Giay> giays;

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

	public List<Giay> getGiays() {
		return this.giays;
	}

	public void setGiays(List<Giay> giays) {
		this.giays = giays;
	}

}