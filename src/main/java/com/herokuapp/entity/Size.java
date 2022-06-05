package com.herokuapp.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the size database table.
 * 
 */
@Entity
@NamedQuery(name="Size.findAll", query="SELECT s FROM Size s")
public class Size implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String masize;

	private String tensize;

	//bi-directional many-to-many association to Giay
	@ManyToMany(mappedBy="sizes")
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