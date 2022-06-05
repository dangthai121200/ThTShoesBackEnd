package com.herokuapp.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the hang database table.
 * 
 */
@Entity
@NamedQuery(name="Hang.findAll", query="SELECT h FROM Hang h")
public class Hang implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String mahang;

	private String tenhang;

	//bi-directional many-to-many association to Loaigiay
	@ManyToMany(mappedBy="hangs")
	private List<Loaigiay> loaigiays;

	public Hang() {
	}

	public String getMahang() {
		return this.mahang;
	}

	public void setMahang(String mahang) {
		this.mahang = mahang;
	}

	public String getTenhang() {
		return this.tenhang;
	}

	public void setTenhang(String tenhang) {
		this.tenhang = tenhang;
	}

	public List<Loaigiay> getLoaigiays() {
		return this.loaigiays;
	}

	public void setLoaigiays(List<Loaigiay> loaigiays) {
		this.loaigiays = loaigiays;
	}

}